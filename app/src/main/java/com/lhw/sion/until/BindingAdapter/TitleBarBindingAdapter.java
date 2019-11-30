package com.lhw.sion.until.BindingAdapter;

import androidx.databinding.BindingAdapter;

import com.hjq.bar.TitleBar;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class TitleBarBindingAdapter {
    @BindingAdapter("android:setTitleText")
    public static void settitle(TitleBar titleBar,String title){
        if(titleBar!=null){
            titleBar.setTitle(title);
        }
    }
}
