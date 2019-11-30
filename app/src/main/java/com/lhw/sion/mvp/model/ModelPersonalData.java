package com.lhw.sion.mvp.model;

import com.lhw.sion.mvp.contract.ContractPersonalData;
import com.lhw.sion.until.ResultCode;

import java.io.File;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.UpdataFile;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class ModelPersonalData implements ContractPersonalData.Model {
    @Override
    public void getUserBean(String phone, String psw, JinxiuListning<SelectUserBean> listning) {
        JinxiuImp.selectUser(phone,psw,listning);
    }

    @Override
    public void uploadPhotos(File file, String phone, JinxiuListning<UpdataFile> listning) {
        JinxiuImp.UpdataFile(phone, ResultCode.UPDATA_IMGHEAD,file,listning);
    }
}
