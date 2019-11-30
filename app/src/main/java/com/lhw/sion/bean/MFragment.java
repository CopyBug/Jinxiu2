package com.lhw.sion.bean;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lhw.sion.common.MyLazyFragment;
import com.lhw.sion.mvp.listning.Reflashview;

/**
 * 作者： 梁浩文, 日期： 2019/10/8.
 * 让代码更加美观
 */
public abstract class MFragment extends MyLazyFragment implements Reflashview {
    public boolean isrendering=false;


    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isrendering=true;
//        OnNetChange(netMobile);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //第一次判断


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }






    @Override
    protected void initData() {

    }




    @Override
    public void reflashinitview() {
        if(isrendering==true){
            initView();
            initData();
        }
    }


}
