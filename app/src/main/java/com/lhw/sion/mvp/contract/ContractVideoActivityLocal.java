package com.lhw.sion.mvp.contract;

import com.lhw.sion.bean.LocalVideoBean;

import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/17.
 * 让代码更加美观
 */
public interface ContractVideoActivityLocal {
    interface View extends BaseContract.View{
         void   Loading();
         void hideLoading();
       void setvideoBeans(LocalVideoBean  localVideoBean);
    }
    interface Model{

    }
    interface Presenter{
         void getLocalVideo();
        void getauthorize();
    }
}
