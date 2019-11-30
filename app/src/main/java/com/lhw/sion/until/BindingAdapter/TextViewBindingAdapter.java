package com.lhw.sion.until.BindingAdapter;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.SelectVideo;

/**
 * 作者： 梁浩文, 日期： 2019/10/16.
 * 让代码更加美观
 */
public class TextViewBindingAdapter {
@BindingAdapter("android:translation")
    public static void setTranslation(TextView translation,List<JinsanTransation.BaesInfoBean.SymbolsBean > symbolsBeans){
    if(translation!=null){
        if(symbolsBeans.size()>=1){
            JinsanTransation.BaesInfoBean.SymbolsBean  symbolsBean=   symbolsBeans.get(0);
        if(symbolsBean!=null){
            if(symbolsBean.getParts()!=null){
                if(symbolsBean.getParts().size()>=1){
                    JinsanTransation.BaesInfoBean.SymbolsBean.PartsBean partsBean = symbolsBean.getParts().get(0);
                    List<String> means = partsBean.getMeans();
                    if(means!=null){
            StringBuffer stringBuffer=new StringBuffer();
                        for (int i = 0; i < means.size(); i++) {
                            stringBuffer.append(means.get(i)).append("\t");
                        }
                        translation.setText(stringBuffer.toString());
                    }
                }
            }
        }}
    }
}
//转时间
    @BindingAdapter("android:toDate")
    public static void toDate(TextView textView,String time){
    if(textView!=null){
     try {
         Date date = new Date(Long.valueOf(time));
         SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
         String format1 = format.format(date);
         textView.setText(format1);
     }catch (Exception e){

     }
    }
    }





}
