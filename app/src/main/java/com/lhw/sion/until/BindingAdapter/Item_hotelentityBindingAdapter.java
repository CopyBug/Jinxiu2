package com.lhw.sion.until.BindingAdapter;

import androidx.databinding.BindingAdapter;

import com.lhw.sion.ui.view.HotelentityView;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class Item_hotelentityBindingAdapter {
    @BindingAdapter("android:hotelentityParent")
    public static void setHotelentityParentText(HotelentityView view,String partentext){
        if(view!=null){
            view.setParentText(partentext);
        }
    }
    @BindingAdapter("android:hotelentityChild")
    public static void setHotelentityChildText(HotelentityView view,String childtext){
        if(view!=null){
            view.setChildText(childtext);
        }
    }
}
