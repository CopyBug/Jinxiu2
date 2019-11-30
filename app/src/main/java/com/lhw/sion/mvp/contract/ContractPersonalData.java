package com.lhw.sion.mvp.contract;

import java.io.File;

import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.UpdataFile;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public interface ContractPersonalData {
    interface View extends BaseContract.View{
      void setUserbean(SelectUserBean.BeanBean beanBean);

    }
    interface Presenter{
      void initView();
      void  uploadPhoto(File file);

    }
    interface  Model{
    //获取用户信息
    void getUserBean(String phone, String psw, JinxiuListning<SelectUserBean> listning);
    void uploadPhotos(File file, String phone, JinxiuListning<UpdataFile> listning);
    }

}
