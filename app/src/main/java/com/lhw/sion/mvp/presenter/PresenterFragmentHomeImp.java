package com.lhw.sion.mvp.presenter;

import com.hjq.demo.R;
import com.lhw.sion.bean.DatabingBeanRegisterUser;
import com.lhw.sion.bean.DatabingBeanUserInformation;
import com.lhw.sion.bean.HomeBean;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractFragmentHome;
import com.lhw.sion.mvp.contract.ContractRegister;
import com.lhw.sion.mvp.model.ModelFragmentHome;
import com.lhw.sion.mvp.model.ModelRegisterImp;
import com.lhw.sion.ui.dialog.ToastDialog;
import com.lhw.sion.until.Until;

import sion.my.jinxiu.bean.LoginBean;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class PresenterFragmentHomeImp implements ContractFragmentHome.Presenter {



    private ContractFragmentHome.View view;
    private ContractFragmentHome.Model model;

    public PresenterFragmentHomeImp(ContractFragmentHome.View view) {
        this.view = view;
        model= new ModelFragmentHome();
    }

    @Override
    public void initInfoUser() {
        DatabingBeanUserInformation databingBeanRegisterUser=new DatabingBeanUserInformation(UserInfo.Phone,UserInfo.Password);
      this.model.getFragmentBean(databingBeanRegisterUser, new JinxiuListning<HomeBean>() {
          @Override
          public void SuccessRequest(HomeBean homeBean) {
              view.bindData(homeBean);
          }

          @Override
          public void FailRequest(Throwable throwable) {
              view.toast(throwable.getMessage());
          }

          @Override
          public void OtherError(String error) {
              view.toast(error);
          }
      });
    }
}
