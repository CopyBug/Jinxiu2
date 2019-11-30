package com.lhw.sion.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.hjq.base.BaseDialog;
import com.hjq.demo.R;
import com.hjq.demo.databinding.FragmentPersonalDataBinding;
import com.hjq.image.ImageLoader;
import com.hjq.widget.layout.SettingBar;
import com.lhw.sion.bean.MFragment;
import com.lhw.sion.bean.PostionBean;
import com.lhw.sion.mvp.contract.ContractPersonalData;
import com.lhw.sion.mvp.presenter.PresenterPersonalDataimp;
import com.lhw.sion.ui.activity.ImageActivity;
import com.lhw.sion.ui.activity.PhoneResetActivity;
import com.lhw.sion.ui.activity.PhoneVerifyActivity;
import com.lhw.sion.ui.activity.PhotoActivity;
import com.lhw.sion.ui.dialog.AddressDialog;
import com.lhw.sion.ui.dialog.InputDialog;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import sion.my.jinxiu.bean.SelectUserBean;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2019/04/20
 * desc   : 个人资料
 */
public final class PersonalDataFragment extends MFragment implements ContractPersonalData.View {
    FragmentActivity activity;
    @BindView(R.id.iv_person_data_avatar)
    CircleImageView mAvatarView;
    @BindView(R.id.sb_person_data_id)
    SettingBar mIDView;
    @BindView(R.id.sb_person_data_name)
    SettingBar mNameView;
    @BindView(R.id.sb_person_data_address)
    SettingBar mAddressView;
    @BindView(R.id.sb_person_data_phone)
    SettingBar mPhoneView;
    PostionBean postionBean;
    private String mAvatarUrl;
    private SelectUserBean.BeanBean beanBean;
    ContractPersonalData.Presenter presenter;
    private FragmentPersonalDataBinding dataBing;

    public static PersonalDataFragment newInstance() {
        return new PersonalDataFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal_data;
    }

    @Override
    protected void initView() {
        dataBing = (FragmentPersonalDataBinding) getDataBing(FragmentPersonalDataBinding.class);
    }

    @Override
    protected void initData() {
        activity = getActivity();
        presenter = new PresenterPersonalDataimp(this);
        presenter.initView();



    }

    @OnClick({R.id.iv_person_data_avatar, R.id.fl_person_data_head, R.id.sb_person_data_name, R.id.sb_person_data_address, R.id.sb_person_data_phone})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_person_data_avatar:
                ImageActivity.start(getActivity(), this.beanBean.getImghead());
                break;
            case R.id.fl_person_data_head:
                Intent intent=new Intent(getActivity(),PhotoActivity.class);
                PhotoActivity.Fragmentactivity(activity, intent, new PhotoActivity.OnPhotoSelectListener() {
                    @Override
                    public void onSelect(List<String> data) {
                        mAvatarUrl = data.get(0);
                        ImageLoader.with(getActivity())
                                .load(mAvatarUrl)
                                .into(mAvatarView);
                        File file = new File(mAvatarUrl);
                        presenter.uploadPhoto(file);
                        Mfinish();

                    }

                    @Override
                    public void onCancel() {

                    }


                });

                break;
            case R.id.sb_person_data_name:
                new InputDialog.Builder(activity)
                        // 标题可以不用填写
                        .setTitle(getString(R.string.personal_data_name_hint))
                        .setContent(mNameView.getRightText())
                        //.setHint(getString(R.string.personal_data_name_hint))
                        //.setConfirm("确定")
                        // 设置 null 表示不显示取消按钮
                        //.setCancel("取消")
                        // 设置点击按钮后不关闭对话框
                        //.setAutoDismiss(false)
                        .setListener(new InputDialog.OnListener() {

                            @Override
                            public void onConfirm(BaseDialog dialog, String content) {
                                if (!mNameView.getRightText().equals(content)) {
                                    mNameView.setRightText(content);
                                }
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {
                            }
                        })
                        .show();
                break;
            case R.id.sb_person_data_address:
                new AddressDialog.Builder(activity)
                        //.setTitle("选择地区")
                        // 设置默认省份
                        .setProvince(postionBean.getProvince())
                        // 设置默认城市（必须要先设置默认省份）
                        .setCity(postionBean.getCity())
                        // 不选择县级区域
//                        .setIgnoreArea()
                        .setListener(new AddressDialog.OnListener() {

                            @Override
                            public void onSelected(BaseDialog dialog, String province, String city, String area) {
                                String address = province + city + area;
                                if (!mAddressView.getRightText().equals(address)) {
                                    mAddressView.setRightText(address);
                                }
                            }

                            @Override
                            public void onCancel(BaseDialog dialog) {
                            }
                        })
                        .show();
                break;
            case R.id.sb_person_data_phone:
                // 先判断有没有设置过手机号
                if (true) {
                    activity.startActivity(new Intent(activity, PhoneVerifyActivity.class));
                } else {
                    activity.startActivity(new Intent(activity, PhoneResetActivity.class));
                ;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void setUserbean(SelectUserBean.BeanBean beanBean) {
        this.beanBean = beanBean;
        postionBean = new PostionBean(beanBean.getPosition());
        beanBean.setPosition(postionBean.toString());
        dataBing.setUserinfo(beanBean);
    }

    @Override
    public FragmentActivity setActivity() {
        return activity;
    }
}