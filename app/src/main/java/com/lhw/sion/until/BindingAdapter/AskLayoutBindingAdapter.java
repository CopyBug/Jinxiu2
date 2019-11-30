package com.lhw.sion.until.BindingAdapter;

import androidx.databinding.BindingAdapter;

import com.lhw.sion.ui.view.AskLayout;
import com.lhw.sion.ui.view.CulationLayout;

import java.util.List;

import sion.my.jinxiu.bean.WordSpecificLearn;

/**
 * 作者： 梁浩文, 日期： 2019/9/30.
 * 让代码更加美观
 */
public class AskLayoutBindingAdapter {
    @BindingAdapter("android:AskLayoutstringarray")
    public static void setquestion(AskLayout askLayout, List<String> question) {
        if(askLayout!=null&&question!=null){
            for (int i = 0; i < question.size(); i++) {
                String s = question.get(i);
                String[] split = s.split("；");
                if(split.length>=0){
                    question.set(i,split[0]);

                }
            }
            askLayout.setbutton(question);
        }
    }
    @BindingAdapter("android:setask")
    public static void setask(AskLayout askLayout, Integer ask) {
        if(askLayout!=null&&ask!=null){
            askLayout.setAsk(ask);
        }
    }

}
