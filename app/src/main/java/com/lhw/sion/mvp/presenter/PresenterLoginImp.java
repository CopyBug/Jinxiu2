package com.lhw.sion.mvp.presenter;

import android.app.Dialog;
import android.widget.Toast;

import com.lhw.sion.mvp.contract.ContractLogin;
import com.lhw.sion.mvp.model.ModelLoginImp;
import com.lhw.sion.ui.dialog.ToastDialog;

import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class PresenterLoginImp implements ContractLogin.PresenterLogin{
    private final String LOGINFAIL="登录失败";
    private final String LOGINSUCCESS="登录成功";
    private ContractLogin.ViewLogin viewLogin;
    private ContractLogin.ModelLogin modelLogin;

    public PresenterLoginImp(ContractLogin.ViewLogin viewLogin) {
        this.viewLogin = viewLogin;
        this.modelLogin=new ModelLoginImp();
    }

    @Override
    public boolean judgeInputFormat() {
        return this.modelLogin.judgeInputFormat(this.viewLogin.returnUserInfomation());
    }

    @Override
    public void judgeLoginStatus() {
        this.modelLogin.judgeLoginStatus(this.viewLogin.returnUserInfomation(), new JinxiuListning<SelectUserBean>() {
            @Override
            public void SuccessRequest(SelectUserBean selectUserBean) {

                if ("登录失败".equals(selectUserBean.getError())) {
                    viewLogin.ShowPromptDialog("登录失败", ToastDialog.Type.ERROR);
                    viewLogin.loginFail(LOGINFAIL);

                } else {
                    viewLogin.ShowPromptDialog("登录成功", ToastDialog.Type.FINISH);
                    viewLogin.loginSuccess();
                }

            }

            @Override
            public void FailRequest(Throwable throwable) {
                    viewLogin.loginFail(throwable.getMessage());
            }

            @Override
            public void OtherError(String error) {
                viewLogin.loginFail(error);
            }
        });
    }
}
