package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.hjq.demo.R;
import com.lhw.sion.bean.DatabingBeanUserInformation;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.helper.InputTextHelper;
import com.lhw.sion.mvp.contract.BaseContract;
import com.lhw.sion.mvp.contract.ContractLogin;
import com.lhw.sion.mvp.presenter.PresenterLoginImp;
import com.lhw.sion.other.IntentKey;
import com.lhw.sion.until.Until;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 登录界面
 */
public final class LoginActivity extends MyActivity implements ContractLogin.ViewLogin {

    @BindView(R.id.iv_login_logo)
    ImageView mLogoView;
    @BindView(R.id.ll_login_body)
    LinearLayout mBodyLayout;
    @BindView(R.id.et_login_phone)
    EditText mPhoneView;
    @BindView(R.id.et_login_password)
    EditText mPasswordView;
    @BindView(R.id.btn_login_commit)
    Button mCommitView;
    @BindView(R.id.v_login_blank)
    View mBlankView;

    @BindView(R.id.ll_login_other)
    View mOtherView;
    @BindView(R.id.iv_login_qq)
    View mQQView;
    @BindView(R.id.iv_login_wx)
    View mWeChatView;
    protected ContractLogin.PresenterLogin presenterLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        InputTextHelper.with(this)
                .addView(mPhoneView)
                .addView(mPasswordView)
                .setMain(mCommitView)
                .setListener(new InputTextHelper.OnInputTextListener() {
                    @Override
                    public boolean onInputChange(InputTextHelper helper) {
                        return presenterLogin.judgeInputFormat();
                    }
                })
                .build();


    }

    @Override
    protected void initData() {
        presenterLogin = new PresenterLoginImp(this);

    }

    @Override
    public void onRightClick(View v) {
        // 跳转到注册界面
        startActivityForResult(RegisterActivity.class, new ActivityCallback() {

            @Override
            public void onActivityResult(int resultCode, @Nullable Intent data) {
                // 如果已经注册成功，就执行登录操作 activit回传
                if (resultCode == RESULT_OK && data != null) {
                    mPhoneView.setText(data.getStringExtra(IntentKey.PHONE));
                    mPasswordView.setText(data.getStringExtra(IntentKey.PASSWORD));
                    onClick(mCommitView);
                }
            }
        });
    }

    @Override
    public DatabingBeanUserInformation returnUserInfomation() {
        return new DatabingBeanUserInformation(mPhoneView.getText().toString(), mPasswordView.getText().toString());
    }

    @Override
    public void loginSuccess() {
        BaseContract.HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                Until.SetShareP(getActivity(),"JinxiuPhone",mPhoneView.getText().toString(),"JinxiuPassword",mPasswordView.getText().toString());
                UserInfo.Phone=mPhoneView.getText().toString().trim();
                UserInfo.Password=mPasswordView.getText().toString().trim();
                startActivityFinish(HomeActivity.class);
            }
        },1000);
    }

    @Override
    public void loginFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public FragmentActivity setActivity() {
        return this;
    }


    @OnClick({R.id.btn_login_commit})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_commit:
                presenterLogin.judgeLoginStatus();
                break;
            default:
                break;
        }
    }


}