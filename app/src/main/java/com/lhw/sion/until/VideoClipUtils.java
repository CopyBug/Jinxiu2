package com.lhw.sion.until;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AppendTrack;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;
import com.lhw.sion.ui.view.thumb.interfaces.VideoTrimListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.SQLTransactionRollbackException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import nl.bravobit.ffmpeg.ExecuteBinaryResponseHandler;
import nl.bravobit.ffmpeg.FFcommandExecuteResponseHandler;
import nl.bravobit.ffmpeg.FFmpeg;


public class VideoClipUtils {
    static Handler handler=new Handler(Looper.myLooper());
    private static final String TAG = VideoClipUtils.class.getSimpleName();

    /**
     * 裁剪视频
     * @param srcPath 需要裁剪的原视频路径
     * @param outPath 裁剪后的视频输出路径
     * @param startTimeMs 裁剪的起始时间
     * @param endTimeMs 裁剪的结束时间
     */
    public static void clip(String srcPath, String outPath, double startTimeMs, double endTimeMs, VideoTrimListener videoTrimListener) throws IOException, IllegalArgumentException {
        if (TextUtils.isEmpty(srcPath) || TextUtils.isEmpty(outPath)) {
            throw new IllegalArgumentException("file path can't be null!!!!");
        }
        if (!(new File(srcPath).exists())) {
            throw new IllegalArgumentException("the source file is not exist!!!!");
        }
        if (startTimeMs >= endTimeMs) {
            throw new IllegalArgumentException("the startTimeMs is larger than endTimeMs!!!!");
        }
        Movie movie = MovieCreator.build(srcPath);
        List<Track> tracks = movie.getTracks();
        //移除旧的track
        movie.setTracks(new LinkedList<Track>());
        //处理的时间以秒为单位
        double startTime = startTimeMs/1000;
        double endTime = endTimeMs/1000;
        Log.d(TAG, "--->>>>startTimeMs = " + startTimeMs + "\n endTimeMs = " + endTimeMs + "\n tracks.size = " + tracks.size());
        //计算剪切时间，视频的采样间隔大，以视频为准
        for (Track track : tracks) {
            if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                startTime = correctTimeToSyncSample(track, startTime, false);
                endTime = correctTimeToSyncSample(track, endTime, true);
                if (track.getHandler().equals("vide")) {
                    break;
                }
            }
        }
        Log.d(TAG, "--->>>>startTime = " + startTime + "\n endTime = " + endTime);

        long currentSample;
        double currentTime;
        double lastTime;
        long startSample1;
        long endSample1;
        long delta;

        for (Track track : tracks) {
            currentSample = 0;
            currentTime = 0;
            lastTime = -1;
            startSample1 = -1;
            endSample1 = -1;

            //根据起始时间和截止时间获取起始sample和截止sample的位置
            for (int i = 0; i < track.getSampleDurations().length; i++) {
                delta = track.getSampleDurations()[i];
                if (currentTime > lastTime && currentTime <= startTime) {
                    startSample1 = currentSample;
                }
                if (currentTime > lastTime && currentTime <= endTime) {
                    endSample1 = currentSample;
                }
                lastTime = currentTime;
                currentTime += (double)delta / (double)track.getTrackMetaData().getTimescale();
                currentSample++;
            }
            Log.d(TAG, "track.getHandler() = " + track.getHandler() + "\n startSample1 = " + startSample1 + "\n endSample1 = " + endSample1);
            if (startSample1 <= 0 && endSample1 <= 0) {
                throw new RuntimeException("clip failed !!");
            }
            movie.addTrack(new CroppedTrack(track, startSample1, endSample1));// 添加截取的track
        }

        //合成视频mp4
        Container out = new DefaultMp4Builder().build(movie);
        FileOutputStream fos = new FileOutputStream(outPath);
        FileChannel fco = fos.getChannel();
        out.writeContainer(fco);
        fco.close();
        fos.close();
        videoTrimListener.onFinishTrim(outPath );
    }


    /**
     * 换算剪切时间
     * @param track
     * @param cutHere
     * @param next
     * @return
     */
    public static double correctTimeToSyncSample(Track track, double cutHere, boolean next) {
        double[] timeOfSyncSamples = new double[track.getSyncSamples().length];
        long currentSample = 0;
        double currentTime = 0;
        for (int i = 0; i < track.getSampleDurations().length; i++) {
            long delta = track.getSampleDurations()[i];
            int index = Arrays.binarySearch(track.getSyncSamples(), currentSample + 1);
            if (index >= 0) {
                timeOfSyncSamples[index] = currentTime;
            }
            currentTime += ((double)delta / (double)track.getTrackMetaData().getTimescale());
            currentSample++;
        }
        double previous = 0;
        for (double timeOfSyncSample : timeOfSyncSamples) {
            if (timeOfSyncSample > cutHere) {
                if (next) {
                    return timeOfSyncSample;
                } else {
                    return previous;
                }
            }
            previous = timeOfSyncSample;
        }
        return timeOfSyncSamples[timeOfSyncSamples.length - 1];
    }
//视频合并
    public static void joinVideo(Context context, List<String> filePaths, String resultPath, VideoCut videoCut)  {
        String sjj = String.format(Locale.getDefault(), "%s/精修/短視頻", Environment.getExternalStorageDirectory().getAbsolutePath()) + "/jinxiu" + System.currentTimeMillis() +"temp"+ ".mp4";
        if(filePaths==null||filePaths.size()<=0||TextUtils.isEmpty(resultPath)){
            videoCut.failFile("空指针");
            return;
        }
        if(filePaths.size()==1){
            videoCut.successFile(filePaths.get(0));
            return;
        }
        try {
            Movie[] movies = new Movie[filePaths.size()];
            for (int i = 0; i < filePaths.size(); i++) {
                File file = new File(filePaths.get(i));
                if(file.exists()){
                    Movie build = MovieCreator.build(filePaths.get(i));
                    movies[i]=build;
                }
            }
            //分别取出音轨和视频
            List<Track> videoTracks=new LinkedList<>();
            List<Track> audioTracks=new LinkedList<>();
            for (Movie movie : movies) {
                for (Track track : movie.getTracks()) {
                    if(track.getHandler().equals("soun")){
                        audioTracks.add(track);
                    }else if(track.getHandler().equals("vide")){
                        videoTracks.add(track);
                    }
                }
            }
            //合并到最终的视频文件
            Movie outMovie=new Movie();
            if(audioTracks.size()>0){
                outMovie.addTrack(new AppendTrack(audioTracks.toArray(new Track[audioTracks.size()])));
            }
            if(videoTracks.size()>0){
                outMovie.addTrack(new AppendTrack(videoTracks.toArray(new Track[videoTracks.size()])));
            }
            Container mp4fil = new DefaultMp4Builder().build(outMovie);
            //将文件输出
            FileOutputStream fos = new FileOutputStream(sjj);
            FileChannel fco = fos.getChannel();
            mp4fil.writeContainer(fco);
            fco.close();
            fos.close();
            //最后删除原片段文件
            for (String filePath : filePaths) {
                File file = new File(filePath);
                file.delete();
            }

            String mCmd="-i \""+fos+"\" -r 10 -b:a 32k \""+resultPath+"\"";
String cmd[]=mCmd.split(" ");
FFmpeg.getInstance(context).execute(cmd, new FFcommandExecuteResponseHandler() {
    @Override
    public void onSuccess(String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                videoCut.successFile(resultPath);
            }
        });

    }

    @Override
    public void onProgress(String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                videoCut.process(message);
            }
        });
    }

    @Override
    public void onFailure(String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                videoCut.failFile(message);
            }
        });

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }
});


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static  void ffmgpJoinVideo(Context context, List<String> filePath, String outpath,VideoCut listener){
        /*转ts文件*/

        /*合并文件*/

        /*销毁文件*/

        //2. ==使用ts拼接==
//        速度快，文件小
        //先将 mp4 转化为同样编码形式的 ts 流，因为 ts流是可以 concate 的，先把 mp4 封装成 ts ，然后 concate ts 流， 最后再把 ts 流转化为 mp4
        /*ffmpeg -i 1.mp4 -vcodec copy -acodec copy -vbsf h264_mp4toannexb 1.ts
ffmpeg -i 2.mp4 -vcodec copy -acodec copy -vbsf h264_mp4toannexb 2.ts
ffmpeg -i "concat:1.ts|2.ts" -acodec copy -vcodec copy -absf aac_adtstoasc output.mp4
*/
        if(filePath!=null){
            List<String> tefile=new ArrayList<>();
            for (int i = 0; i < filePath.size(); i++) {
                Random random = new Random();
                int nextInt = random.nextInt(1000);
                String tsfile = String.format(Locale.getDefault(), "%s/精修/短視頻", Environment.getExternalStorageDirectory().getAbsolutePath()) + "/" +nextInt  + System.currentTimeMillis() + ".ts";
                FFmpgtoTs(context,filePath.get(i),tsfile,tefile,i==filePath.size()-1,listener);
            }


        }



    }
public  static  void JoinVideo(Context context,List<String> tsfile, String outpath,VideoCut listener){
        if(tsfile!=null){
    //ffmpeg -i "concat:input1.ts|input2.ts|input3.ts" -c copy -bsf:a aac_adtstoasc -movflags +faststart output.mp4
                StringBuffer stringBuffer=new StringBuffer();
                stringBuffer.append("-i \"");
                for (int i = 0; i < tsfile.size(); i++) {
                    stringBuffer.append(tsfile.get(i));
                    if(i!=tsfile.size()-1){
                        stringBuffer.append("|");
                    }
                }
                stringBuffer.append("\" -c copy -bsf:a aac_adtstoasc -movflags +faststart "+outpath);
            Log.i("JoinVideo", stringBuffer.toString());
                String cmd[]=stringBuffer.toString().split(" ");
                FFmpeg.getInstance(context).execute(cmd, new ExecuteBinaryResponseHandler() {
                    @Override
                    public void onSuccess(String s) {
                        for (String s1 : tsfile) {
                            new File(s1).delete();
                        }
                        listener.successFile(outpath);
                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onFailure(String message) {
                        super.onFailure(message);
                        listener.failFile(message);
                    }
                });


        }
}

public static void FFmpgtoTs(Context context, String intput, String output, List<String> tefile, boolean b,VideoCut listener){

        //  /*ffmpeg -i 1.mp4 -vcodec copy -acodec copy -vbsf h264_mp4toannexb 1.ts
    String cmd = "-i "+intput+" -vcodec copy -acodec copy -vbsf h264_mp4toannexb "+output;
    String[] command = cmd.split(" ");
    FFmpeg.getInstance(context).execute(command, new ExecuteBinaryResponseHandler() {
        @Override
        public void onSuccess(String s) {
            tefile.add(output);
            new File(intput).delete();
            if(b){
                JoinVideo(context,tefile,output,listener);
            }
        }

        @Override
        public void onStart() {

        }
    });
}



    public static void FFmpgtrim(Context context, String inputFile, String outputFile, long startMs, long endMs, final VideoTrimListener callback) {
/*        final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        final String outputName = "trimmedVideo_" + timeStamp + ".mp4";*/
//        outputFile = outputFile + "/" + outputName;

        String start = convertSecondsToTime(startMs / 1000);
        String duration = convertSecondsToTime((endMs - startMs) / 1000);
        //String start = String.valueOf(startMs);
        //String duration = String.valueOf(endMs - startMs);

        /** 裁剪视频ffmpeg指令说明：
         * ffmpeg -ss START -t DURATION -i INPUT -codec copy -avoid_negative_ts 1 OUTPUT
         -ss 开始时间，如： 00:00:20，表示从20秒开始；
         -t 时长，如： 00:00:10，表示截取10秒长的视频；
         -i 输入，后面是空格，紧跟着就是输入视频文件；
         -codec copy -avoid_negative_ts 1 表示所要使用的视频和音频的编码格式，这里指定为copy表示原样拷贝；
         INPUT，输入视频文件；
         OUTPUT，输出视频文件
         */
        //TODO: Here are some instructions
        //https://trac.ffmpeg.org/wiki/Seeking
        //https://superuser.com/questions/138331/using-ffmpeg-to-cut-up-video

        String cmd = "-ss " + start + " -t " + duration + " -accurate_seek" + " -i " + inputFile + " -codec copy -avoid_negative_ts 1 " + outputFile;
        //String cmd = "-ss " + start + " -i " + inputFile + " -ss " + start + " -t " + duration + " -vcodec copy " + outputFile;
        //{"ffmpeg", "-ss", "" + startTime, "-y", "-i", inputFile, "-t", "" + induration, "-vcodec", "mpeg4", "-b:v", "2097152", "-b:a", "48000", "-ac", "2", "-ar", "22050", outputFile}
        //String cmd = "-ss " + start + " -y " + "-i " + inputFile + " -t " + duration + " -vcodec " + "mpeg4 " + "-b:v " + "2097152 " + "-b:a " + "48000 " + "-ac " + "2 " + "-ar " + "22050 "+ outputFile;
        String[] command = cmd.split(" ");
        try {
            final String tempOutFile = outputFile;
            FFmpeg.getInstance(context).execute(command, new ExecuteBinaryResponseHandler() {

                @Override
                public void onSuccess(String s) {
                    callback.onFinishTrim(tempOutFile);
                    Log.i("FFMPG", "onSuccess: ");
                }

                @Override
                public void onStart() {
                    callback.onStartTrim();
                    Log.i("FFMPG", "onStart: ");

                }

                @Override
                public void onFailure(String message) {
                    super.onFailure(message);
                    Log.i("FFMPG", "onFailure: "+message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        } else {
            retStr = "" + i;
        }
        return retStr;
    }
    private static String convertSecondsToTime(long seconds) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (seconds <= 0) {
            return "00:00";
        } else {
            minute = (int) seconds / 60;
            if (minute < 60) {
                second = (int) seconds % 60;
                timeStr = "00:" + unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    return "99:59:59";
                }
                minute = minute % 60;
                second = (int) (seconds - hour * 3600 - minute * 60);
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }
    public interface VideoCut{
        void successFile(String file);
        void failFile(String msg);
        void process(String process);

    }
}
