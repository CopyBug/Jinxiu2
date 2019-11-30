package com.lhw.sion.mvp.presenter;

import com.lhw.sion.bean.DataBindingLearnInfoAdapter;
import com.lhw.sion.mvp.contract.ContractLearnInfo;
import com.lhw.sion.mvp.model.ModelLearnInfo;

import java.util.List;

import sion.my.jinxiu.bean.WordSpecificLearn;

/**
 * 作者： 梁浩文, 日期： 2019/10/1.
 * 让代码更加美观
 */
public class PresenterLearnInfoimp implements ContractLearnInfo.Presenter {
    public ContractLearnInfo. View view;
    public ContractLearnInfo.Model model;

    public PresenterLearnInfoimp(ContractLearnInfo.View view) {
        this.view = view;
        this.model=new ModelLearnInfo();
    }

    @Override
    public List<DataBindingLearnInfoAdapter> initView() {
        this.view.showMLoading();
        WordSpecificLearn.BeanBean.WordSpecificBean beanBean = view.getIntentWordSpecific();
        List<DataBindingLearnInfoAdapter> bean = this.model.getDataBingBean(beanBean);
        this.view.hideMLoading();
        return bean;
    }
}
