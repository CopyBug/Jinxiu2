package com.lhw.sion.mvp.contract;

import android.view.View;
import android.view.ViewGroup;

import com.lhw.sion.ui.fragment.VideoFragment;

import java.util.List;

import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public interface ContractRecommend {
    interface View extends BaseContract.View{


        void setSelectVideo (List<SelectVideo.BeanBean> beanBean);
        void  relushVideo(List<SelectVideo.BeanBean> beanBean);

    }

    interface Model extends BaseContract.Model {
        void loadNextLoad(String phone, String nowtime, Jinxiu2Listining<SelectVideo> jinxiu2Listining);

    }

    interface Presenter {
        void loadNextLoad(boolean isAgain,boolean isReflush);


        void jumpVidePerson(android.view.View view, SelectVideo.BeanBean.WordWritingsBean writingsBean);





        BaseContract.WindowLeangth getWindow();


    }
}
