package com.lhw.sion.until.BindingAdapter;

import android.view.View;
import android.widget.LinearLayout;

import androidx.databinding.BindingAdapter;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class LoadingBindingAdapter {
    @BindingAdapter("android:isload")
    public static void isshowLoading(LinearLayout linearLayout,boolean isshow){
        if(linearLayout!=null){
            if(isshow){
                linearLayout.setVisibility(View.VISIBLE);
            }else{
                linearLayout.setVisibility(View.GONE);
            }
        }
    }
}
