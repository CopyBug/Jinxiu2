package com.lhw.sion.mvp.model;

import com.lhw.sion.bean.DatabingBeanUserInformation;
import com.lhw.sion.mvp.contract.ContractLogin;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class ModelLoginImp implements ContractLogin.ModelLogin {

    @Override
    public boolean judgeInputFormat(DatabingBeanUserInformation basicUserInformation) {
        if(basicUserInformation!=null){
            return basicUserInformation.getPhone().length()==11&&basicUserInformation.getPassword().length()>=6;
        }
        return false;
    }

    @Override
    public  void judgeLoginStatus(DatabingBeanUserInformation basicUserInformation, JinxiuListning<SelectUserBean> jinxiuListning) {
        JinxiuImp.selectUser(basicUserInformation.getPhone(), basicUserInformation.getPassword(), jinxiuListning);

    }

}
