package com.lhw.sion.until;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import nl.bravobit.ffmpeg.ExecuteBinaryResponseHandler;
import nl.bravobit.ffmpeg.FFcommandExecuteResponseHandler;
import nl.bravobit.ffmpeg.FFmpeg;

/**
 * 作者： 梁浩文, 日期： 2019/10/21.
 * 让代码更加美观
 */
public class FFmpeUntil {

    // to Ts ffmpeg -i input1.flv -c copy -bsf:v h264_mp4toannexb -f mpegts input1.ts
    public static String toTscmd = "-i %s -c copy -bsf:v h264_mp4toannexb -f mpegts %s";
    //合并 没有分离器
    public static String joinVideo = "-i \"concat:%s\" -c copy -bsf:a aac_adtstoasc -movflags +faststart %s";
    //合并有分离器
    public static String concatVideo = "-f concat -safe 0 -i %s -c copy %s";
    public static String compressionVideo="-i %s -b:v 1M -s 960x540 %s";


    public static String appendConcatVideoCmd(List<String> file, String outpath) {
        String fFmpegconcat = FFmpegconcat(file);
        if (fFmpegconcat != null) {
            String format = String.format(concatVideo, fFmpegconcat, outpath);
            return format;
        }
        return null;
    }
    public static String appendCompressionVideo(String intput,String output){
        String format = String.format(compressionVideo, intput, output);
        return format;
    }

    public static String FFmpegconcat(List<String> ffmpeg) {
        //创建一个txt文件
        String sjj = String.format(Locale.getDefault(), "%s/精修/ffmpg文本",
                Environment.getExternalStorageDirectory().getAbsolutePath()) + "/filelist.txt";

        FileOutputStream outPut = null;

        try {
            File file = new File(sjj);
            if(!file.exists()){
                File dir = new File(file.getParent());
                dir.mkdirs();
                dir.createNewFile();
            }
            outPut = new FileOutputStream(file);
            FileChannel channel = outPut.getChannel();
            for (int i = 0; i < ffmpeg.size(); i++) {
                String msg = ffmpeg.get(i);
                msg = "file \'" + msg + "\'";
                if(i!=ffmpeg.size()-1){
                    msg+="\n";
                }
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes("utf-8"));
                channel.write(byteBuffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outPut != null) {
                try {
                    outPut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return outPut != null ? sjj : null;
    }

    public static String appendToTsCMD(String inputPath, String outPath) {
        if (inputPath != null && outPath != null) {
            File file = new File(inputPath);
            boolean exists = file.exists();
            if (exists) {
                String format = String.format(toTscmd, inputPath, outPath);
                return format;
            }
            return null;
        }
        return null;
    }

    public static String appendToJoin(List<String> tsFile, String outPath) {
        if (tsFile != null && outPath != null) {
            StringBuffer tsPathcmd = new StringBuffer();
            for (int i = 0; i < tsFile.size(); i++) {
                tsPathcmd.append(tsFile.get(i));
                if (i == tsFile.size() - 1) {
                    break;
                }
                tsPathcmd.append("|");
            }
            String format = String.format(joinVideo, tsPathcmd.toString(), outPath);
            return format;
        }
        return null;
    }

    public static void executionCmd(String cmd, Context context, FFcommandExecuteResponseHandler handler) {
        FFmpeg.getInstance(context).execute(cmd.split(" "), handler);
    }

    /*视频合并*/ /*mp4转ts文件*//*ts合并mp4*/
    public static void joinVideos(Context mContext, List<String> filePaths, String outPath, FFmpeUntilListning listning) {
        if (filePaths == null || filePaths.size() <= 0 || TextUtils.isEmpty(outPath)) {
            listning.failTorequest("空指针");
            return;
        }
        if (filePaths.size() == 1) {
            listning.completeFile(filePaths.get(0));
            return;
        }
        //转ts的命令
        List<String> cmdToTss = new ArrayList<>();
        //存放ts的文件集合
        List<String> tsPath = new ArrayList<>();
        for (String filePath : filePaths) {
            File file = new File(filePath);
            String mName = file.getName();
            String[] split = mName.split("\\.mp4");
            String sjj = String.format(Locale.getDefault(), "%s/精修/短視頻",
                    Environment.getExternalStorageDirectory().getAbsolutePath()) + "/" + split[0] + "Jinxiu.ts";
            tsPath.add(sjj);
            String toTsCMD = appendToTsCMD(filePath, sjj);
            if (toTsCMD != null) {
                cmdToTss.add(toTsCMD);
            }
        }

        for (int i = 0; i < cmdToTss.size(); i++) {
            int finalI = i;
            //转txt文件
            executionCmd(cmdToTss.get(i), mContext, new ExecuteBinaryResponseHandler() {
                @Override
                public void onSuccess(String message) {
                    super.onSuccess(message);
                    Log.i("onSuccess", message);
                    if (finalI == (cmdToTss.size() - 1)) {
                        //合并
                        String appendConcatVideoCmd = appendConcatVideoCmd(tsPath, outPath);
                        if (appendConcatVideoCmd != null) {
                            executionCmd(appendConcatVideoCmd, mContext, new ExecuteBinaryResponseHandler() {
                                @Override
                                public void onSuccess(String message) {
                                    listning.destory(filePaths, tsPath);
                                    super.onSuccess(message);
                                    String outCompress = newAVideoFile();
                                    String appendCompressionVideo = appendCompressionVideo(outPath, outCompress);
                                    executionCmd(appendCompressionVideo,mContext,new ExecuteBinaryResponseHandler(){
                                        @Override
                                        public void onSuccess(String message) {
                                            super.onSuccess(message);
                                            //输出文件
                                            File file = new File(outPath);
                                            if(file.exists()){
                                                file.delete();
                                            }
                                            listning.completeFile(outCompress);
                                        }

                                        @Override
                                        public void onFailure(String message) {
                                            super.onFailure(message);
                                            listning.destory(filePaths, tsPath);
                                            listning.failTorequest(message);
                                            return;
                                        }
                                    });




                                }

                                @Override
                                public void onFailure(String message) {
                                    super.onFailure(message);
                                    Log.i("onFailure", message);
                                    listning.destory(filePaths, tsPath);
                                    listning.failTorequest(message);
                                    return;
                                }
                            });
                        }}


                    }

                    @Override
                    public void onFailure (String message){
                        super.onFailure(message);
                        Log.i("onFailure", message);
                        listning.destory(filePaths, tsPath);
                        listning.failTorequest(message);
                        return;
                    }

            });
        }

    }
    public static String newAVideoFile(){
        return String.format(Locale.getDefault(), "%s/精修/短視頻",
                Environment.getExternalStorageDirectory().getAbsolutePath()) + "/JinxiuCompress" +System.currentTimeMillis()+".mp4";
    }

    /*销毁*/
    public interface FFmpeUntilListning {
        default void destory(List<String>... file) {
            for (int i = 0; i < file.length; i++) {
                List<String> strings = file[i];
                for (int j = 0; j < strings.size(); j++) {
                    File tempFile = new File(strings.get(j));
                    tempFile.delete();
                }
            }

        }
        void completeFile(String outPath);
        void failTorequest(String msg);
    }
    //文件压缩
    public static void FileCompress(Context context,String inputOut, FFmpeUntilListning listning){
        String newAVideoFile = newAVideoFile();
        String appendCompressionVideo = appendCompressionVideo(inputOut,newAVideoFile);
        executionCmd(appendCompressionVideo,context,new ExecuteBinaryResponseHandler(){
            @Override
            public void onSuccess(String message) {
                super.onSuccess(message);
                listning.completeFile(newAVideoFile);
            }

            @Override
            public void onFailure(String message) {
                super.onFailure(message);
                listning.failTorequest(message);
            }
        });
    }

}
