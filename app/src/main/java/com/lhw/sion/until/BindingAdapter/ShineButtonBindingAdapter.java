package com.lhw.sion.until.BindingAdapter;

import androidx.databinding.BindingAdapter;

import com.lhw.sion.common.UserInfo;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.List;

import sion.my.jinxiu.bean.SelectVideo;

/**
 * 作者： 梁浩文, 日期： 2019/10/20.
 * 让代码更加美观
 */
public class ShineButtonBindingAdapter {
    @BindingAdapter("android:ShineButtonCheck")
    public static void isCheck(ShineButton button, List<SelectVideo.BeanBean.WordWritingsBean.WordStarsBean> wordStarsBeans){
        if(button!=null){
            if(wordStarsBeans!=null){
                for (int i = 0; i < wordStarsBeans.size(); i++) {
                    boolean equals = wordStarsBeans.get(i).getPhone().equals(UserInfo.Phone);
                    if(equals){
                        button.setChecked(true);
                        break;
                    }
                }
            }
        }
    }
}
