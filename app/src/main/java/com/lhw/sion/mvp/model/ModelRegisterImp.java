package com.lhw.sion.mvp.model;

import com.lhw.sion.bean.DatabingBeanRegisterUser;
import com.lhw.sion.mvp.contract.ContractLogin;
import com.lhw.sion.mvp.contract.ContractRegister;
import com.lhw.sion.until.IsError;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.LoginBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class ModelRegisterImp implements ContractRegister.ModelRegister {
    @Override
    public void getVerificationCode(String phone,JinxiuListning<Integer> jinxiuListning) {
        boolean nullError = IsError.isNullError(phone);
        if(!nullError){
            JinxiuImp.RequestSendVerificationCode(phone,jinxiuListning);
        }
    }

    @Override
    public boolean judgeInputFormat(DatabingBeanRegisterUser beanRegisterUser) {
        if(beanRegisterUser!=null){
            boolean nullError = IsError.isNullError(beanRegisterUser.getPhone(), beanRegisterUser.getVerificationCode(), beanRegisterUser.getPasswordOne(), beanRegisterUser.getPasswordTwo());
            if(!nullError){
                return   beanRegisterUser.getPhone().length()==11&& beanRegisterUser.getPasswordOne().toString().equals(beanRegisterUser.getPasswordTwo().toString())&&beanRegisterUser.getVerificationCode().length()==4;
            }
            return nullError;
        }else{
            return false;
        }
    }

    @Override
    public void judgeAddUser(DatabingBeanRegisterUser beanRegisterUser,JinxiuListning<LoginBean> jinxiuListning) {
    if(!IsError.isNullError(beanRegisterUser.getPhone(), beanRegisterUser.getPasswordOne())) {
        JinxiuImp.addUser(beanRegisterUser.getPhone(), beanRegisterUser.getPasswordOne(),jinxiuListning);
    }
    }
}
