package com.lhw.sion.mvp.presenter;

import com.hjq.demo.R;
import com.lhw.sion.mvp.contract.ContractRegister;
import com.lhw.sion.mvp.model.ModelRegisterImp;
import com.lhw.sion.ui.dialog.ToastDialog;
import com.lhw.sion.until.Until;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.LoginBean;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class PresenterRegisterImp implements ContractRegister.PresenterRegister {

    private String requestPhone=null;

    private ContractRegister.ViewRegister viewRegister;
    private ContractRegister.ModelRegister modelRegister;

    public PresenterRegisterImp(ContractRegister.ViewRegister viewRegister) {
        this.viewRegister = viewRegister;
        this.modelRegister = new ModelRegisterImp();

    }

    @Override
    public boolean judgeInputFormat() {
        return this.modelRegister.judgeInputFormat(this.viewRegister.returnRegisterInfo());
    }

    @Override
    public void sendTheVerificationCode() {
        if (this.viewRegister.returnRegisterInfo() != null) {
            modelRegister.getVerificationCode(viewRegister.returnRegisterInfo() != null ? viewRegister.returnRegisterInfo().getPhone() : null, new JinxiuListning<Integer>() {
                @Override
                public void SuccessRequest(Integer integer) {
                    viewRegister.toast(Until.GetRource(viewRegister.setActivity(),R.string.common_code_send_hint));
                    viewRegister.returnRegisterInfo().setVerificationCode(integer + "");
                    requestPhone=viewRegister.returnRegisterInfo().getPhone();
                }

                @Override
                public void FailRequest(Throwable throwable) {
                    viewRegister.toast(throwable.getMessage());
                }

                @Override
                public void OtherError(String error) {
                    viewRegister.toast(error);
                }
            });
        }

    }

    @Override
    public void submitUserInformation() {
        //先判断用户是否修改过
        if(requestPhone.equals(viewRegister.returnRegisterInfo().getPhone())){
            modelRegister.judgeAddUser(viewRegister.returnRegisterInfo(), new JinxiuListning<LoginBean>() {
                @Override
                public void SuccessRequest(LoginBean loginBean) {
                    if (loginBean.isBean()){
                        viewRegister.ShowPromptDialog(R.string.common_confirm,ToastDialog.Type.FINISH);
                        viewRegister.SuccessRegister();

                    }else{

                        viewRegister.ShowPromptDialog(R.string.common_code_send_statue2,ToastDialog.Type.ERROR);
                    }

                }

                @Override
                public void FailRequest(Throwable throwable) {

                }

                @Override
                public void OtherError(String error) {

                }
            });
        }
        //验证码是否正确
        //注册成功

    }
}
