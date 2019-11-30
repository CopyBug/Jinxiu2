package com.lhw.sion.ui.manager;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * 作者： 梁浩文, 日期： 2019/10/13.
 * 让代码更加美观
 */
public class VerticalPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View view, float position) {
        /**
         * 0 当前界面
         * -1 前一页
         * 1 后一页
         */
        if (position >= -1 && position <= 1) {
            view.setTranslationX(view.getWidth() * -position);
            float yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);
        }
    }
}