package com.lhw.sion.ui.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
//参考 https://blog.csdn.net/qq_38164867/article/details/81541432
public class MyLayoutManager extends LinearLayoutManager implements RecyclerView.OnChildAttachStateChangeListener {
    private int mDrift;//位移，用来判断移动方向，是向上还是向下滑，大于0向上滑，小于0向下滑
    //PagerSnapHelper 可以使recyclerview实现跟viewpager一样的效果，每次滑一个item
    private PagerSnapHelper mPagerSnapHelper;
    //滑动监听回调接口
    private OnViewPagerListnener mOnViewPagerListnener;

    public MyLayoutManager(Context context) {
        super(context);
    }

    public MyLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        mPagerSnapHelper = new PagerSnapHelper();

    }

    public MyLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onChildViewAttachedToWindow(@NonNull View view) {
        int position=getPosition(view);
        //主要为了第一次进入时,没进行滑动，让第一个item播放
        if(position==0){
            if(mOnViewPagerListnener!=null){
                mOnViewPagerListnener.onPageSelected(getPosition(view),false,view);
            }
        }
    }

    /*当item滑出时，会调用这个方法*/
    @Override
    public void onChildViewDetachedFromWindow(@NonNull View view) {
           if(mDrift>=0){//向上滑
               if(mOnViewPagerListnener!=null) mOnViewPagerListnener.onPageRelease(true,getPosition(view),view);
           }else{
               if(mOnViewPagerListnener!=null) mOnViewPagerListnener.onPageRelease(false,getPosition(view),view);
           }
    }

    //在onAttachedToWindow中修改窗口尺寸 https://blog.csdn.net/guxiao1201/article/details/41517871
    @Override
    public void onAttachedToWindow(RecyclerView view) {
        view.addOnChildAttachStateChangeListener(this);
        mPagerSnapHelper.attachToRecyclerView(view);
        super.onAttachedToWindow(view);
    }

    /*对滑动状态监听，主要是手指释放时，找到惯性滑动停止后的item*/
    @Override
    public void onScrollStateChanged(int state) {
        switch (state){
            case RecyclerView.SCROLL_STATE_IDLE://静止状态
                View snapView = mPagerSnapHelper.findSnapView(this);//获取当前的item
                if(snapView!=null){
                    int position = getPosition(snapView);
                    if(mOnViewPagerListnener!=null){
                        mOnViewPagerListnener.onPageSelected(position,position==getItemCount()-1,snapView);
                    }
                }


        }
        super.onScrollStateChanged(state);
    }

    public void setmOnViewPagerListnener(OnViewPagerListnener mOnViewPagerListnener) {
        this.mOnViewPagerListnener = mOnViewPagerListnener;
    }

    //这里主要是为了判断是向上滑还是向下滑
    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        //dy 大于0向上滑，小于0向下滑
        this.mDrift=dy;
        return super.scrollVerticallyBy(dy, recycler, state);
    }
}
