package com.lhw.sion.mvp.contract;

import com.lhw.sion.bean.DataBindingLearnInfoAdapter;

import java.util.List;

import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.WordSentence;
import sion.my.jinxiu.bean.WordSpecificLearn;

/**
 * 作者： 梁浩文, 日期： 2019/10/1.
 * 让代码更加美观
 */
public interface ContractLearnInfo {
    interface View extends BaseContract.View{
        WordSpecificLearn.BeanBean.WordSpecificBean getIntentWordSpecific();
        SelectWordSentence getIntentWordSentence();
    }
    interface Model{
        List<DataBindingLearnInfoAdapter> getDataBingBean(WordSpecificLearn.BeanBean.WordSpecificBean beanBean);
    }
    interface Presenter  {
        List<DataBindingLearnInfoAdapter> initView();
    }
}
