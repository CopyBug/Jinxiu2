package com.lhw.sion.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.FragmentActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivityRegisterBinding;
import com.hjq.widget.view.CountdownView;
import com.lhw.sion.bean.DatabingBeanRegisterUser;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.helper.InputTextHelper;
import com.lhw.sion.mvp.contract.BaseContract;
import com.lhw.sion.mvp.contract.ContractRegister;
import com.lhw.sion.mvp.presenter.PresenterRegisterImp;
import com.lhw.sion.other.IntentKey;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 注册界面
 */
public final class RegisterActivity extends MyActivity implements ContractRegister.ViewRegister {

    @BindView(R.id.et_register_phone)
    EditText mPhoneView;
    @BindView(R.id.cv_register_countdown)
    CountdownView mCountdownView;
    @BindView(R.id.et_register_code)
    EditText mCodeView;
    @BindView(R.id.et_register_password1)
    EditText mPasswordView1;
    @BindView(R.id.et_register_password2)
    EditText mPasswordView2;
    @BindView(R.id.btn_register_commit)
    Button mCommitView;
    ActivityRegisterBinding binding;
    ContractRegister.PresenterRegister presenterRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


    @Override
    protected void initView() {
        InputTextHelper.with(this)
                .addView(mPhoneView)
                .addView(mCodeView)
                .addView(mPasswordView1)
                .addView(mPasswordView2)
                .setMain(mCommitView)
                .setListener(new InputTextHelper.OnInputTextListener() {
                    @Override
                    public boolean onInputChange(InputTextHelper helper) {
                        return presenterRegister.judgeInputFormat();
                    }
                })
                .build();
    }

    @Override
    protected void initData() {
        binding = (ActivityRegisterBinding) super.viewDataBinding;
        binding.setRegisterUser(new DatabingBeanRegisterUser());
        presenterRegister = new PresenterRegisterImp(this);
    }

    @Override
    protected ImmersionBar statusBarConfig() {
        // 不要把整个布局顶上去
        return super.statusBarConfig().keyboardEnable(true);
    }

    @OnClick({R.id.cv_register_countdown, R.id.btn_register_commit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_register_countdown:
                //发送验证码
                if (mPhoneView.getText().toString().length() != 11) {
                    // 重置验证码倒计时控件
                    mCountdownView.resetState();
                } else {
                    presenterRegister.sendTheVerificationCode();

                }
                break;
            case R.id.btn_register_commit:
                // 用户存在提交注册
                presenterRegister.submitUserInformation();

                break;
            default:
                break;
        }
    }

    @Override
    public DatabingBeanRegisterUser returnRegisterInfo() {
        return binding.getRegisterUser();
    }

    @Override
    public void SuccessRegister() {
        BaseContract.HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra(IntentKey.PHONE, mPhoneView.getText().toString());
                intent.putExtra(IntentKey.PASSWORD, mPasswordView1.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        },1000);

    }

    @Override
    public void FailRegister(String error) {

    }

    @Override
    public FragmentActivity setActivity() {
        return this;
    }



}