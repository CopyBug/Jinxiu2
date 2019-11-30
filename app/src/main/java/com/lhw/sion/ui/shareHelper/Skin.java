package com.lhw.sion.ui.shareHelper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者： 梁浩文, 日期： 2019/9/26.
 * 让代码更加美观
 */
public class Skin {
   public static Context activity;
    public static boolean IsDay(){
        SharedPreferences mSkin = activity.getSharedPreferences("MSkin", Context.MODE_PRIVATE);
      return   mSkin.getBoolean("Day",false);
    }
    public static void SetDay(boolean isday){
        SharedPreferences mSkin = activity.getSharedPreferences("MSkin", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = mSkin.edit();
        edit.putBoolean("Day",isday);
        edit.commit();

    }
}
