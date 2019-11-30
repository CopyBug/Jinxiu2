package com.lhw.sion.mvp.presenter;

import com.hjq.base.BaseDialog;
import com.lhw.sion.bean.DatabingLearnAdapter;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractLearn;
import com.lhw.sion.mvp.contract.ContractLogin;
import com.lhw.sion.mvp.contract.ContractRegister;
import com.lhw.sion.mvp.model.ModelLearnImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.MaxNumber;
import sion.my.jinxiu.bean.SelectUserWord;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/28.
 * 让代码更加美观
 */
public class PresenterLearnImp implements ContractLearn.Presenter {
    private ContractLearn.View view;
    private ContractLearn.Model model;

    public PresenterLearnImp(ContractLearn.View view) {
        this.view = view;
        this.model = new ModelLearnImp();
    }

    @Override
    public void initView() {
        view.showMLoading();
        this.model.SelectUserWord(UserInfo.Phone, new JinxiuListning<List<DatabingLearnAdapter>>() {
            @Override
            public void SuccessRequest(List<DatabingLearnAdapter> beanBeans) {
                view.setstars(beanBeans);
                view.hideMLoading();
                view.setlearnword(model.getWordCount());
            }
            @Override
            public void FailRequest(Throwable throwable) {
                view.hideMLoading();
            }

            @Override
            public void OtherError(String error) {
                view.hideMLoading();
            }
        });
    }

}
