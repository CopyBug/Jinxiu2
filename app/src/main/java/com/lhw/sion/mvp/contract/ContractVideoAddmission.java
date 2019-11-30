package com.lhw.sion.mvp.contract;

/**
 * 作者： 梁浩文, 日期： 2019/10/21.
 * 让代码更加美观
 */
public interface ContractVideoAddmission {
    interface  View extends BaseContract.View{

    }
    interface Model {

    }
    interface Presenter{
        boolean isSupportOpenGL();
        void setcompetence();
    }


}
