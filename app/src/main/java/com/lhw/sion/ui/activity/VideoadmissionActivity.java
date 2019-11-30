package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.hjq.base.BaseDialog;
import com.hjq.demo.R;
import com.hjq.image.ImageLoader;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.hjq.widget.view.ScaleImageView;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractVideoAddmission;
import com.lhw.sion.mvp.presenter.PresenterVideoAddmission;
import com.lhw.sion.ui.view.RecordButton;
import com.lhw.sion.ui.view.TextureCameraPreview;
import com.lhw.sion.ui.view.YNlayout;
import com.lhw.sion.until.FFmpeUntil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;

public class VideoadmissionActivity extends MyActivity implements ContractVideoAddmission.View ,TextureCameraPreview.OnStartVideoListener{

    @BindView(R.id.video_glSurface)
    GLSurfaceView video_glSurface;
    @BindView(R.id.iv_video_image)
    ScaleImageView scaleImageView;
    @BindView(R.id.texture_camera_view)
    TextureCameraPreview cameraPreview;
    @BindView(R.id.video_recording)
    RecordButton video_recording;
    @BindView(R.id.video_Send)
    YNlayout video_send;
    String mp4VideoPath;
    TextureCameraPreview.OnStartVideoListener startVideoListener;
    private ContractVideoAddmission.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_videoadmission;
    }


    @Override
    protected void initView() {

        initListning();

    }

    @Override
    protected void initData() {
        newAVideoFile();
        presenter = new PresenterVideoAddmission(this);
        startVideoListener=this;


    }
    public String newAVideoFile(){
     return String.format(Locale.getDefault(), "%s/精修/短視頻",
                Environment.getExternalStorageDirectory().getAbsolutePath()) + "/Jinxiu" +System.currentTimeMillis()+".mp4";
    }

    private void initListning() {
        video_recording.setOnRecordStateChangedListener(new RecordButton.OnRecordStateChangedListener() {
            @Override
            public void onRecordStart() {

                if(!cameraPreview.isRecording()){
                    cameraPreview.startRecord(newAVideoFile(),startVideoListener);
                }


            }

            @Override
            public void onRecordStop() {
                if (cameraPreview.isRecording()) {
                    cameraPreview.stopRecord();
                }
            }

            @Override
            public void onZoom(float percentage) {

            }
        });
        video_send.setListning(new YNlayout.YnListning() {
            @Override
            public void YnSelect(boolean isSend) {
                    if(isSend){
                        showWaitingDialog("视频合并压缩中...");
                        cameraPreview.FinishRecord(newAVideoFile());
                    }else{
                        //销毁文件
                    }
            }
        });
    }

    @Override
    public FragmentActivity setActivity() {
        return this;
    }






    @Override
    public void RecordonStart() {
        video_send.isSubmit(View.GONE);
        toast("RecordonStart");
    }

    @Override
    public void RecordonFinish(String outPath) {
            toast(outPath);
        completeWaittingDialog();
            Intent sendIntent=new Intent(getActivity(),SendVideoFileActivity.class);
            sendIntent.putExtra("fileUrl",outPath);
            startActivityForResult(sendIntent,null);
            finish();
    }

    @Override
    public void RecordonStop(String path) {
        toast("RecordonStop");


            File file = new File(path);
            if(file.exists()){
                ImageLoader.with(getBaseContext()).load(file).into(scaleImageView);
            }

        video_send.isSubmit(View.VISIBLE);
    }

    @Override
    public void RecordonError(String error) {
        Log.i("RecordonTag", error);
        video_send.isSubmit(View.GONE);
    }




    //现在OpenGL ES版本已经到3.0了，Android平台上目前有1.0和2.0，我们使用的是2.0，在使用前在onCreate()方法中检查是否支持2.0的版本并且确定使用2.0
    //检查系统是否支持OpenGL ES 2.0
    //申请权限
/*    public void getcompetence() {
        XXPermissions.with(this)
                .permission(Permission.Group.STORAGE[0], Permission.Group.STORAGE[1], Permission.CAMERA)
                .constantRequest()
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if (quick) {
                            toast(R.string.common_permission_fail);
                            XXPermissions.gotoPermissionSettings(VideoadmissionActivity.this, false);
                        } else {
                            toast(R.string.common_permission_hint);
                        }
                    }
                });
    }*/


}
