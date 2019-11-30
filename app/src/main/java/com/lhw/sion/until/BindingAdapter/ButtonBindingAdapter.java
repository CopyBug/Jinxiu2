package com.lhw.sion.until.BindingAdapter;

import android.view.View;
import android.widget.Button;

import androidx.databinding.BindingAdapter;

import com.lhw.sion.common.UserInfo;

/**
 * 作者： 梁浩文, 日期： 2019/10/16.
 * 让代码更加美观
 */
public class ButtonBindingAdapter
{
    /*判断是否为作者*/
    @BindingAdapter(value = {"android:writer","android:reader"},requireAll = false)
    public static void isWriter(Button button, String writer,String reader){
        if(button!=null){
            button.setVisibility(View.GONE);
            if(writer!=null&& reader!=null){
                if(writer.equals(reader)){
                    button.setVisibility(View.VISIBLE);
                    return;
                }
            }
        }
    }
}
