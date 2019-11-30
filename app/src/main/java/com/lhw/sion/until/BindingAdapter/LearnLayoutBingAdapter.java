package com.lhw.sion.until.BindingAdapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.lhw.sion.ui.view.LearnLayout;

/**
 * 作者： 梁浩文, 日期： 2019/9/27.
 * 让代码更加美观
 */
public class LearnLayoutBingAdapter {
    @BindingAdapter("android:mtextview")
    public static void setSrc(LearnLayout learnLayout, String string) {
        if(string!=null){
            learnLayout.setText(string);
        }
    }
    @BindingAdapter("android:binstars")
    public static void setstars(LearnLayout learnLayout, Integer stats) {
        if(learnLayout!=null){
            learnLayout.setStars(stats);
        }
    }
}
