package com.lhw.sion.until;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hjq.base.BaseDialog;
import com.hjq.demo.R;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.common.MyApplication;
import com.lhw.sion.ui.dialog.ToastDialog;
import com.lhw.sion.ui.dialog.WaitDialog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iknow.android.utils.callback.SingleCallback;
import iknow.android.utils.thread.BackgroundExecutor;


public class Until {
    public static int CHART_ONLY_CN = 1;
    public static int CHART_ONLY_EN = 2;
    public static int CHART_EN_CN = 0;
    public static int CHART_NOONLY_CN_CN = -1;


    //    static  String textcolor="<font color='#FF0000'>红颜色</font>";
    public static Handler handler = new Handler(Looper.myLooper());

    public static String ChangeTextviewcolor(String juzi, String ts, String textcolor) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<font color='");
        stringBuffer.append(textcolor);
        stringBuffer.append("'>");
        stringBuffer.append(ts);
        stringBuffer.append("</font>");
        StringBuffer stringBuffer2 = new StringBuffer();
        String[] split = juzi.split(ts);
        for (int i = 0; i < split.length; i++) {
            if (i == split.length - 1) {
                stringBuffer2.append(split[i]);
                break;
            }
            stringBuffer2.append(split[i]).append(stringBuffer);
        }

        return stringBuffer2.toString();
    }

    public static boolean isNetworkAvailable(Context context) {

        NetworkInfo info = getNetworkInfo(context);
        return info != null && info.isAvailable();
    }

    private static NetworkInfo getNetworkInfo(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
//        获取长宽
        if (drawable != null) {

            int intrinsicWidth = (int) (drawable.getIntrinsicWidth());
            int intrinsicHeight = (int) (drawable.getIntrinsicHeight());
            // 取 drawable 的颜色格式
            Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            //创建Bitmap
            Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
            //创建画布
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmap;
        }
        return null;
    }

    public static String getDayTime() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static Map<String, String> BaseMap(FragmentActivity activity) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", GetShareP(activity, "WordRem_Phone"));
        return hashMap;
    }

    public static Throwable throwable(String msg) {
        return new Throwable(msg);
    }

    public static boolean isChinese(char c) {
        boolean result = false;
        if (c >= 19968 && c <= 171941) {
            return true;
        }
        return result;
    }

    public static int isEnglishorChinese(String word) {
        Set<Boolean> is_cn = new HashSet<>();
        if (word != null) {
            for (int i = 0; i < word.length(); i++) {
                is_cn.add(isChinese(word.charAt(i)));
            }
            List<Boolean> list = new ArrayList<>(is_cn);
            if (list.size() == 2) {
                return CHART_EN_CN;
            } else if (list.size() == 1) {
                return list.get(0) ? CHART_ONLY_CN : CHART_ONLY_EN;

            }
            return CHART_NOONLY_CN_CN;
        }
        return CHART_NOONLY_CN_CN;

    }

    private void writeWaveFileHeader(FileOutputStream out, long totalAudioLen, long totalDataLen, long longSampleRate,
                                     int channels, long byteRate) throws IOException {
        byte[] header = new byte[44];
        header[0] = 'R'; // RIFF
        header[1] = 'I';
        header[2] = 'F';
        header[3] = 'F';
        header[4] = (byte) (totalDataLen & 0xff);//数据大小
        header[5] = (byte) ((totalDataLen >> 8) & 0xff);
        header[6] = (byte) ((totalDataLen >> 16) & 0xff);
        header[7] = (byte) ((totalDataLen >> 24) & 0xff);
        header[8] = 'W';//WAVE
        header[9] = 'A';
        header[10] = 'V';
        header[11] = 'E';
        //FMT Chunk
        header[12] = 'f'; // 'fmt '
        header[13] = 'm';
        header[14] = 't';
        header[15] = ' ';//过渡字节
        //数据大小
        header[16] = 16; // 4 bytes: size of 'fmt ' chunk
        header[17] = 0;
        header[18] = 0;
        header[19] = 0;
        //编码方式 10H为PCM编码格式
        header[20] = 1; // format = 1
        header[21] = 0;
        //通道数
        header[22] = (byte) channels;
        header[23] = 0;
        //采样率，每个通道的播放速度
        header[24] = (byte) (longSampleRate & 0xff);
        header[25] = (byte) ((longSampleRate >> 8) & 0xff);
        header[26] = (byte) ((longSampleRate >> 16) & 0xff);
        header[27] = (byte) ((longSampleRate >> 24) & 0xff);
        //音频数据传送速率,采样率*通道数*采样深度/8
        header[28] = (byte) (byteRate & 0xff);
        header[29] = (byte) ((byteRate >> 8) & 0xff);
        header[30] = (byte) ((byteRate >> 16) & 0xff);
        header[31] = (byte) ((byteRate >> 24) & 0xff);
        // 确定系统一次要处理多少个这样字节的数据，确定缓冲区，通道数*采样位数
        header[32] = (byte) (1 * 16 / 8);
        header[33] = 0;
        //每个样本的数据位数
        header[34] = 16;
        header[35] = 0;
        //Data chunk
        header[36] = 'd';//data
        header[37] = 'a';
        header[38] = 't';
        header[39] = 'a';
        header[40] = (byte) (totalAudioLen & 0xff);
        header[41] = (byte) ((totalAudioLen >> 8) & 0xff);
        header[42] = (byte) ((totalAudioLen >> 16) & 0xff);
        header[43] = (byte) ((totalAudioLen >> 24) & 0xff);
        out.write(header, 0, 44);
    }

    public static String GetRource(FragmentActivity activity, int id) {
        return activity != null && id != 0 ? activity.getResources().getString(id) : null;
    }

    public static void ShowMsg(FragmentActivity activity, String msg, ToastDialog.Type type) {
        new ToastDialog.Builder(activity)
                .setType(type)
                .setMessage(msg)
                .show();
    }

    public static String GetShareP(FragmentActivity activity, String key) {
        SharedPreferences wordRem = activity.getSharedPreferences("Jinxiu", Context.MODE_PRIVATE);
        return wordRem.getString(key, null);
    }

    public static void SetShareP(FragmentActivity activity, String key1, String value1, String key2, String value2) {
        SharedPreferences wordRem = activity.getSharedPreferences("Jinxiu", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = wordRem.edit();
        edit.putString(key1, value1);
        edit.putString(key2, value2);
        edit.commit();

    }

    public static BaseDialog dialog;

    public static void showDialog(FragmentActivity activity) {

        dialog = new WaitDialog.Builder(activity)
                // 消息文本可以不用填写
                .setMessage(activity.getString(R.string.common_loading))
                .show();


    }

    public static void hideDialog() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }

    public static int StartPlay(Context context, String musicurl) {
        if (musicurl != null) {
            MediaPlayer mediaPlayer = null;
            try {

                mediaPlayer = new MediaPlayer();
                try {

                    mediaPlayer.setDataSource(context, Uri.parse(musicurl));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {

            }
            return mediaPlayer != null ? mediaPlayer.getDuration() : 0;
        }
        return 0;
    }

    public static void Startanim(ImageView imageView, int duration) {
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.stop();
            }
        }, duration);
    }

    public static void GlideUrlImg(ImageView img, String url) {
        Glide.with(img.getContext())
                .load(url)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .into(img);
    }

    //dpTopx
    public static int dptopx(float dpValue) {
        final float scale = MyApplication.applicationContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    /*获取界面*/
    public static Bitmap getFirstView(String path,int width,int height){
        MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(500,  MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        frameAtTime=Bitmap.createScaledBitmap(frameAtTime,width,height,false);
        return frameAtTime;
    }

    public static Bitmap getFirstView(String path){
        MediaMetadataRetriever mediaMetadataRetriever=new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(500,  MediaMetadataRetriever.OPTION_CLOSEST_SYNC);

        return frameAtTime;
    }
    /**/
    public static void setGlideImage(ImageView imageView, Bitmap bitmap){
        RequestOptions requestOptions=new RequestOptions();
        requestOptions.error(R.drawable.default_image);
        requestOptions.placeholder(R.drawable.default_image);
        Glide.with(imageView.getContext()).load(bitmap).apply(requestOptions).into(imageView);
    }

    public static void setGlideImage(AppCompatImageView imageView, Bitmap bitmap){
        RequestOptions requestOptions=new RequestOptions();
        requestOptions.error(R.drawable.default_image);
        requestOptions.placeholder(R.drawable.default_image);
        Glide.with(imageView.getContext()).load(bitmap).apply(requestOptions).into(imageView);
    }

}
