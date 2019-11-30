package com.lhw.sion.until.BindingAdapter;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.lhw.sion.ui.view.CulationLayout;
import com.lhw.sion.ui.view.LearnLayout;

/**
 * 作者： 梁浩文, 日期： 2019/9/30.
 * 让代码更加美观
 */
public class CulationLayoutBindingAdapter {

    @BindingAdapter("android:CulationLayoutvideo")
    public static void setSrc(CulationLayout culationLayout, String url) {
        if(culationLayout!=null&&url!=null){
            culationLayout.setVisibility(View.VISIBLE);
            culationLayout.setVideo(url);

        }else{
            culationLayout.setVisibility(View.GONE);
        }


    }

    @BindingAdapter("android:CulationLayouttext")
    public static void settext(CulationLayout culationLayout, String text) {
        if(culationLayout!=null&&text!=null){
            culationLayout.setVisibility(View.VISIBLE);
            culationLayout.setText(text);
        }else{
            culationLayout.setVisibility(View.GONE);
        }

    }
}
