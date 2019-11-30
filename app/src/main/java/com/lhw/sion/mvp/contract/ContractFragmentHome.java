package com.lhw.sion.mvp.contract;

import androidx.databinding.DataBindingUtil;

import com.hjq.demo.databinding.FragmentHomeBinding;
import com.lhw.sion.bean.DatabingBeanUserInformation;
import com.lhw.sion.bean.HomeBean;
import com.lhw.sion.mvp.model.ModelLoginImp;

import java.util.List;

import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectUserWord;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/25.
 * 让代码更加美观
 */
public interface ContractFragmentHome  {
    interface View extends BaseContract.View{

            void bindData(HomeBean beanBean);
    }
    interface Model extends ContractLogin.ModelLogin   {
         void getFragmentBean(DatabingBeanUserInformation basicUserInformation, JinxiuListning<HomeBean> beanJinxiuListning);
        int  findTodayCount(List<SelectUserWord.BeanBean.WordsBean> bean, int code);
    }
    interface Presenter {
       void initInfoUser();
    }
}
