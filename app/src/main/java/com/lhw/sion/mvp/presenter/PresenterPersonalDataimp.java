package com.lhw.sion.mvp.presenter;

import android.util.Log;
import android.widget.Toast;

import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractPersonalData;
import com.lhw.sion.mvp.model.ModelPersonalData;

import java.io.File;

import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.UpdataFile;
import sion.my.jinxiu.listning.JinxiuListning;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class PresenterPersonalDataimp implements ContractPersonalData.Presenter {
    private ContractPersonalData.View view;
    private ContractPersonalData.Model model;
    private SelectUserBean.BeanBean bean;

    public PresenterPersonalDataimp(ContractPersonalData.View view) {
        this.view = view;
        this.model=new ModelPersonalData();
    }

    @Override
    public void initView() {
        String jinxiuPhone = UserInfo.Phone;
        String jinxiuPassword = UserInfo.Password;

        this.model.getUserBean(jinxiuPhone, jinxiuPassword, new JinxiuListning<SelectUserBean>() {
            @Override
            public void SuccessRequest(SelectUserBean selectUserBean) {
                bean = selectUserBean.getBean();
                view.setUserbean(bean);

            }

            @Override
            public void FailRequest(Throwable throwable) {

            }

            @Override
            public void OtherError(String error) {

            }
        });
    }

    @Override
    public void uploadPhoto(File file) {
        this.view.showMLoading();
        this.model.uploadPhotos(file, UserInfo.Phone, new JinxiuListning<UpdataFile>() {
            @Override
            public void SuccessRequest(UpdataFile updataFile) {
                Log.i(TAG, updataFile.getName());
                Toast.makeText(view.setActivity(), "上传成功", Toast.LENGTH_SHORT).show();
                view.hideMLoading();
            }

            @Override
            public void FailRequest(Throwable throwable) {
                Toast.makeText(view.setActivity(), "上传失败", Toast.LENGTH_SHORT).show();
                view.hideMLoading();
            }

            @Override
            public void OtherError(String error) {
                view.hideMLoading();
            }
        });
    }
}
