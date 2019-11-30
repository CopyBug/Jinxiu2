package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.util.Log;

import com.dueeeke.videoplayer.player.VideoViewManager;
import com.hjq.demo.R;
import com.lhw.sion.bean.LocalVideoBean;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.BaseContract;
import com.lhw.sion.ui.dialog.ToastDialog;
import com.lhw.sion.ui.view.thumb.VideoTrimmerView;
import com.lhw.sion.ui.view.thumb.interfaces.VideoTrimListener;
import com.lhw.sion.until.FFmpeUntil;

import butterknife.BindView;

public class ThumbVideoActivity extends MyActivity {

    private static final String TAG = "ThumbVideoActivity_TAG";
    @BindView(R.id.thumb_view)
    VideoTrimmerView mThumbView;
    LocalVideoBean video_url;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_thumb_video;
    }

    @Override
    protected void initView() {
        video_url= (LocalVideoBean) getIntent().getSerializableExtra("videoUrl");

    }

    @Override
    protected void initData() {

       if(video_url!=null){
           mThumbView.initVideoByURI(video_url);
           mThumbView.setOnTrimVideoListener(new VideoTrimListener() {
               @Override
               public void onStartTrim() {

               }

               @Override
               public void onFinishTrim(String url) {

                   showComplete();
                   Intent intent=new Intent(getActivity(),SendVideoFileActivity.class);
                   FFmpeUntil.FileCompress(getBaseContext(), url, new FFmpeUntil.FFmpeUntilListning() {
                       @Override
                       public void completeFile(String outPath) {
                            completeWaittingDialog();
                           intent.putExtra("fileUrl",outPath);
                           startActivityForResult(intent,null);
                           finish();
                       }

                       @Override
                       public void failTorequest(String msg) {
                           completeWaittingDialog();
                           showErrorDialog();
                           finish();
                       }
                   });



               }

               @Override
               public void onCancel() {
                finish();
               }

               @Override
               public void errorCut(String msg) {
                   completeWaittingDialog();
               }

               @Override
               public void onLoad() {
                   showWaitingDialog("文件处理中");
               }
           });
       }

    }

    @Override
    protected void onPause() {
        Log.i("onPause", "onPause: ");

        super.onPause();

    }

    @Override
    protected void onRestart() {
        VideoViewManager.instance().resume();
        super.onRestart();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void finish() {
        if(mThumbView!=null){
            mThumbView.RemoveVideo();
        }
        super.finish();
    }
}
