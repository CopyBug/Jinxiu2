package com.lhw.sion.mvp.contract;

import com.lhw.sion.bean.DatabingBeanRegisterUser;
import com.lhw.sion.bean.DatabingBeanUserInformation;
import com.lhw.sion.ui.activity.RegisterActivity;

import java.util.Vector;

import sion.my.jinxiu.bean.LoginBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public interface ContractRegister {

    interface ViewRegister extends BaseContract.View{
            DatabingBeanRegisterUser returnRegisterInfo();
            void SuccessRegister();
            void FailRegister(String error);

    }
    interface ModelRegister{
            void getVerificationCode(String phone, JinxiuListning<Integer> jinxiuListning);
            boolean judgeInputFormat(DatabingBeanRegisterUser beanRegisterUser);
            void judgeAddUser(DatabingBeanRegisterUser databingBeanRegisterUser,JinxiuListning<LoginBean> jinxiuListning);


    }
    interface PresenterRegister{
        boolean judgeInputFormat();
        void sendTheVerificationCode();
        void submitUserInformation();

    }
}
