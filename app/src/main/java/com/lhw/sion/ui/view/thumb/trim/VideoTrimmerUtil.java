package com.lhw.sion.ui.view.thumb.trim;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.lhw.sion.ui.view.thumb.interfaces.VideoTrimListener;
import com.lhw.sion.until.VideoClipUtils;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import iknow.android.utils.DeviceUtil;
import iknow.android.utils.UnitConverter;
import iknow.android.utils.callback.SingleCallback;
import iknow.android.utils.thread.BackgroundExecutor;


/**
 * Author：J.Chou
 * Date：  2016.08.01 2:23 PM
 * Email： who_know_me@163.com
 * Describe:
 */
public class VideoTrimmerUtil {
  private static Handler handler=new Handler(Looper.myLooper());
  private static final String TAG = VideoTrimmerUtil.class.getSimpleName();
  public static final long MIN_SHOOT_DURATION = 3000L;// 最小剪辑时间3s
  public static  int VIDEO_MAX_TIME = 10;// 10秒
  public static final long MAX_SHOOT_DURATION = VIDEO_MAX_TIME * 1000L;//视频最多剪切多长时间10s

  public static final int MAX_COUNT_RANGE = 10;  //seekBar的区域内一共有多少张图片
  private static final int SCREEN_WIDTH_FULL = DeviceUtil.getDeviceWidth();
  public static final int RECYCLER_VIEW_PADDING = UnitConverter.dpToPx(35);
  public static final int VIDEO_FRAMES_WIDTH = SCREEN_WIDTH_FULL - RECYCLER_VIEW_PADDING * 2;
  private static final int THUMB_WIDTH = (SCREEN_WIDTH_FULL - RECYCLER_VIEW_PADDING * 2) / VIDEO_MAX_TIME;
  private static final int THUMB_HEIGHT = UnitConverter.dpToPx(50);



  public static void shootVideoThumbInBackground(final String  videoUri, final int totalThumbsCount, final long startPosition,
                                                 final long endPosition, final SingleCallback<Bitmap, Integer> callback) {
    BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0L, "") {
      @Override
      public void execute() {
        try {
          MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
          mediaMetadataRetriever.setDataSource( videoUri);
          // Retrieve media data use microsecond
          long interval = (endPosition - startPosition) / (totalThumbsCount - 1);
          for (long i = 0; i < totalThumbsCount; ++i) {
            long frameTime = startPosition + interval * i;
            Bitmap bitmap = mediaMetadataRetriever.getFrameAtTime(frameTime * 1000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
            if(bitmap == null) continue;
            try {
              bitmap = Bitmap.createScaledBitmap(bitmap, THUMB_WIDTH, THUMB_HEIGHT, false);
            } catch (final Throwable t) {
              t.printStackTrace();
            }
            callback.onSingleCallback(bitmap, (int) interval);
          }
          mediaMetadataRetriever.release();
        } catch (final Throwable e) {
          Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
      }
    });
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

  private static String unitFormat(int i) {
    String retStr = null;
    if (i >= 0 && i < 10) {
      retStr = "0" + Integer.toString(i);
    } else {
      retStr = "" + i;
    }
    return retStr;
  }


  public synchronized  void trim(Context context,String inputFile, long startMs, long endMs, final VideoTrimListener callback) {

    final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    final String outputName = "trimmedVideo_" + timeStamp + ".mp4";
    String outfile = String.format(Locale.getDefault(), "%s/精修/短視頻", Environment.getExternalStorageDirectory().getAbsolutePath())+"/"+outputName;
//       VideoClipUtils videoClip=new VideoClipUtils(inputFile,outfile,outputName,startMs,endMs);
    try {
      VideoClipUtils.FFmpgtrim(context,inputFile,outfile,startMs,endMs,callback);
    } catch (Exception e) {
      e.printStackTrace();
      callback.errorCut(e.getMessage());
    }
/*    try {
      final String tempOutFile = outputFile;
      VideoClipUtils videoClip=new VideoClipUtils(inputFile,tempOutFile,)
      callback.onFinishTrim(tempOutFile);
      callback.onCancel();
    } catch (Exception e) {
      e.printStackTrace();
    }*/
  }
}
