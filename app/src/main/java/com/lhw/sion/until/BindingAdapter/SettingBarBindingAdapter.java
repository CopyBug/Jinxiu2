package com.lhw.sion.until.BindingAdapter;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.hjq.widget.layout.SettingBar;

import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class SettingBarBindingAdapter {
    @BindingAdapter("android:righttext_bar")
    public static void setRightText(SettingBar settingBar, String righttext) {
        if(settingBar!=null){
            settingBar.setRightText(righttext);
        }else{

        }


    }



    @BindingAdapter("android:bar_left_text")
    public static void setRightText(SettingBar settingBar, List<String> lefttext) {
        if(settingBar!=null){
           if(lefttext!=null){
               if(lefttext.size()>=1){
                   settingBar.setLeftText(lefttext.get(0));
                   return;
               }
           }
        }else{

        }
        settingBar.setVisibility(View.GONE);
    }
}
