package com.lhw.sion.mvp.presenter;

import android.graphics.Bitmap;
import android.util.Log;

import com.hjq.base.BaseDialog;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivitySendVideoFileBinding;
import com.lhw.sion.bean.DataBingSendVideo;
import com.lhw.sion.mvp.contract.ContractSendVideo;
import com.lhw.sion.mvp.model.ModelSendVideo;
import com.lhw.sion.ui.dialog.InputDialog;
import com.lhw.sion.until.Until;

import java.io.File;

import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.SendVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/18.
 * 让代码更加美观
 */
public class PresenterSendVideo implements ContractSendVideo.Presenter {
    ContractSendVideo.View view;
    ContractSendVideo.Model model;
    String fileUrl;

    public PresenterSendVideo(ContractSendVideo.View view) {
        this.view = view;
        this.model=new ModelSendVideo();
    }

 /*   @Override
    public void getImageView() {
        fileUrl = view.setActivity().getIntent().getStringExtra("fileUrl");
        Bitmap firstView = Until.getFirstView(fileUrl, Until.dptopx(130), Until.dptopx(200));
        view.setImageView(firstView);
    }*/

    @Override
    public File getFile() {
        fileUrl = view.setActivity().getIntent().getStringExtra("fileUrl");
        File file = new File(fileUrl);
        return file.exists()?file:null;
    }

    @Override
    public void SendVideo() {
        SelectVideo.BeanBean.WordWritingsBean wordWritingsBean=new SelectVideo.BeanBean.WordWritingsBean();
        DataBingSendVideo sendVideo  = this.view.getBinding().getSendVideo();
        sendVideo.setVideoFile(fileUrl);
        Log.i("DataBingSendVideo", sendVideo.toString());
        //
        if(wordWritingsBean!=null){
            BaseDialog dialog = this.view.showWaitingLoading("上传中...");
            this.model.requestSendVideo(sendVideo, new Jinxiu2Listining<SendVideo>() {
                @Override
                public void SuccessRequest(SendVideo sendVideo) {
                    view.hideWaitinigLoading(dialog);
                    view.successDialog();
                    view.SuccessSend();
                }

                @Override
                public void FailRequest(String throwable) {
                    view.hideWaitinigLoading(dialog);
                    view.Error();
                }
            });
        }else{
            view.Error();
        }
    }

    @Override
    public void showDialog_Word(){
        new InputDialog.Builder(view.setActivity())
                // 标题可以不用填写
                .setTitle("请输入你的单词")

                // 确定按钮文本
                .setConfirm(view.setActivity().getString(R.string.common_confirm))
                // 设置 null 表示不显示取消按钮
                .setCancel(view.setActivity().getString(R.string.common_confirm))
                //.setAutoDismiss(false) // 设置点击按钮后不关闭对话框
                .setListener(new InputDialog.OnListener() {

                    @Override
                    public void onConfirm(BaseDialog dialog, String content) {
                     if(content!=null){
                         if(!content.equals("")){
                             view.setWord(content);
                         }else{

                         }
                     }
                    }

                    @Override
                    public void onCancel(BaseDialog dialog) {

                    }
                })
                .show();

    }
}
