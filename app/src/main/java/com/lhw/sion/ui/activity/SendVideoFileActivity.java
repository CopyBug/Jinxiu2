package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivitySendVideoFileBinding;
import com.hjq.image.ImageLoader;
import com.lhw.sion.bean.DataBingSendVideo;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractSendVideo;
import com.lhw.sion.mvp.presenter.PresenterSendVideo;
import com.lhw.sion.until.Until;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class SendVideoFileActivity extends MyActivity implements ContractSendVideo.View {
    ContractSendVideo.Presenter presenter;
    ActivitySendVideoFileBinding binding;
    @BindView(R.id.send_img)
    ImageView send_img;
    @BindView(R.id.set_word)
    Button set_word;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_send_video_file;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        binding = (ActivitySendVideoFileBinding) super.viewDataBinding;
        binding.setSendVideo(new DataBingSendVideo());
        presenter = new PresenterSendVideo(this);
        ImageLoader.with(this)
                .load(presenter.getFile())
                .into(send_img);
    }



    @Override
    public void SuccessSend() {
          finish();
    }

    @Override
    public ActivitySendVideoFileBinding getBinding() {
        return binding;
    }

    @Override
    public void setWord(String word) {
        set_word.setText(word);
    }

    @Override
    public FragmentActivity setActivity() {
        return this;
    }

    @OnClick({R.id.btn_send_commit,R.id.set_word})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_commit:
                //空值
                if(binding!=null){
                    DataBingSendVideo sendVideo = binding.getSendVideo();
                    if(sendVideo.getComment()==null||sendVideo.getComment().equals("")){
                        toast("内容不要留空");
                        return;
                    }
                    if(sendVideo.getTitle()==null||sendVideo.getTitle().equals("")){
                        toast("单词不要留空");
                        return;
                    }
                    presenter.SendVideo();
                }

                break;
            case R.id.set_word:
                presenter.showDialog_Word();
                break;
        }
    }
}
