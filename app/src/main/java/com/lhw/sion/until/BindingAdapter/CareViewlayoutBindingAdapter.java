package com.lhw.sion.until.BindingAdapter;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.hjq.demo.R;
import com.lhw.sion.bean.DataBindingLearnInfoAdapter;
import com.lhw.sion.ui.view.CareViewlayout;

import sion.my.jinxiu.bean.SelectWordSentence;

/**
 * 作者： 梁浩文, 日期： 2019/10/1.
 * 让代码更加美观
 */
public class CareViewlayoutBindingAdapter {
    @BindingAdapter(value = {"android:adapterbean"},requireAll = false)
    public static void setInfo(CareViewlayout carVeiewlayout, SelectWordSentence.BeanBean beanBean) {
       if(carVeiewlayout!=null){
           carVeiewlayout.setTransaction(beanBean.getNetwork_cn());
           carVeiewlayout.setClause(beanBean.getNetwork_en());
           carVeiewlayout.setMusicmp(beanBean.getTts_mp3());
       }
    }

}
