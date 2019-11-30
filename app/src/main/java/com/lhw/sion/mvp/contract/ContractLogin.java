package com.lhw.sion.mvp.contract;

import com.lhw.sion.bean.DatabingBeanUserInformation;

import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

public interface ContractLogin {
    interface ViewLogin extends BaseContract.View{
        DatabingBeanUserInformation returnUserInfomation();
        void loginSuccess();

        void loginFail(String msg);
    }
    interface PresenterLogin{
        boolean judgeInputFormat();
        void judgeLoginStatus();
    }
    interface  ModelLogin extends BaseContract.Model{
        boolean judgeInputFormat(DatabingBeanUserInformation basicUserInformation);
        void judgeLoginStatus(DatabingBeanUserInformation basicUserInformation,  JinxiuListning<SelectUserBean> jinxiuListning);
    }

}
