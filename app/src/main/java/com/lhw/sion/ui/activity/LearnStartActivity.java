package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hjq.base.BaseDialog;
import com.hjq.base.BaseDialogFragment;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivityLearnStartBinding;
import com.hjq.umeng.Platform;
import com.hjq.umeng.UmengShare;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractStratLearn;
import com.lhw.sion.mvp.presenter.PresenterLearnStartimp;
import com.lhw.sion.ui.dialog.ShareDialog;
import com.lhw.sion.ui.view.AskLayout;
import com.lhw.sion.ui.view.CulationLayout;
import com.lhw.sion.until.ResultCode;

import butterknife.BindView;
import sion.my.jinxiu.bean.WordSpecificLearn;

/**
 * @author Sion
 */
public class LearnStartActivity extends MyActivity implements ContractStratLearn.View, AskLayout.onAskLayoutListinin {


    private ActivityLearnStartBinding binding;
    @BindView(R.id.culation1)
    CulationLayout culationLayout;
    @BindView(R.id.masklayout)
    AskLayout askLayout;
    private ContractStratLearn.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_learn_start;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ResultCode.NextPage && resultCode == RESULT_OK) {
            presenter.showworddpagenext();
            initview();
        }
    }

    @Override
    protected void initView() {
        askLayout.setAskLayoutListinin(this);

    }

    @Override
    protected void initData() {
        binding = (ActivityLearnStartBinding) super.viewDataBinding;

        presenter = new PresenterLearnStartimp(this);
        presenter.initview();
        initview();
    }

    @Override
    public int getNumber() {
        return getIntent().getIntExtra("NumberWord", 1);
    }

    @Override
    public ActivityLearnStartBinding setbind() {
        return binding;
    }

    @Override
    public void showFinishDialog(Integer stars) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_learnword_success, null,true);
      RatingBar bar= view.findViewById(R.id.top_dialog_stars);
        TextView textView = view.findViewById(R.id.center_dialog_textvview);
        textView.setText("恭喜你成功收获"+stars+"颗小星星");
        bar.setRating(stars);
        new BaseDialogFragment.Builder(this)
                .setContentView(view)

                //.setText(id, "我是预设置的文本")
                .setOnClickListener(R.id.btn_dialog_custom_ok, new BaseDialog.OnClickListener<ImageView>() {

                    @Override
                    public void onClick(BaseDialog dialog, ImageView view) {
                        dialog.dismiss();
                        startActivityFinish(LearnActivity.class);
                    }
                }).
                setOnClickListener(R.id.other_dialog_enjoy, new BaseDialog.OnClickListener() {
                    @Override
                    public void onClick(BaseDialog dialog, View view) {
                        new ShareDialog.Builder(getActivity())
                                // 分享标题
                                .setShareTitle("Github")
                                // 分享描述
                                .setShareDescription("AndroidProject")
                                // 分享缩略图
                                .setShareLogo("https://avatars1.githubusercontent.com/u/28616817?s=460&v=4")
                                // 分享链接
                                .setShareUrl("https://github.com/getActivity/AndroidProject")
                                .setListener(new UmengShare.OnShareListener() {

                                    @Override
                                    public void onSucceed(Platform platform) {
                                        toast("分享成功");
                                    }

                                    @Override
                                    public void onError(Platform platform, Throwable t) {
                                        toast("分享出错");
                                    }

                                    @Override
                                    public void onCancel(Platform platform) {
                                        toast("分享取消");
                                    }
                                })
                                .show();
                    }
                }).
                setCancelable(false)
                .show();

    }


    /**
     * 重新绘制
     */
    @Override
    public void initview() {
        askLayout.initview();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.activity_right_in);
        getContentView().setAnimation(animation);
        animation.start();
    }

    @Override
    public void resetprocess(String process) {
        binding.setMProcess(process);
    }

    @Override
    public void playvideo() {
        culationLayout.startplay();
    }

    @Override
    public int getaskData() {
        return askLayout.getSuccessask();
    }

    @Override
    public FragmentActivity setActivity() {
        return this;
    }

    @Override
    public void ask(boolean issuccess) {
        presenter.subumitLearnWord(binding.getWord().getWordSpecific().getWord(),issuccess);
        if (issuccess) {
            presenter.showworddpagenext();
            initview();
        } else {
            //回答失败
            WordSpecificLearn.BeanBean.WordSpecificBean specific = binding.getWord().getWordSpecific();
            presenter.jumLearnInfoActivity(specific);
        }

    }


}
