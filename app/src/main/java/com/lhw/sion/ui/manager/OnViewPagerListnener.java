package com.lhw.sion.ui.manager;

import android.view.View;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public interface OnViewPagerListnener {

    /**
     * item滑出释放的监听
     * @param isNext true 下一页
     * @param position 页数
     */
    void onPageRelease(boolean isNext, int position, View view);

    /**item滑入的监听以及判断是否滑到底部
     * @param position 页数
     * @param isBotton true 滑到底部
     */
    void onPageSelected(int position,boolean isBotton,View view);
    void isScrollinig(int position,boolean isBotton);
}
