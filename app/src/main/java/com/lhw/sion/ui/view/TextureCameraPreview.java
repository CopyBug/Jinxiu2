package com.lhw.sion.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.ToneGenerator;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.Toast;

import com.lhw.sion.until.FFmpeUntil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenhua on 3/29/2017.
 * Email shenhuanet@126.com
 */
//https://blog.csdn.net/klxh2009/article/details/68062195
public class TextureCameraPreview extends TextureView implements TextureView.SurfaceTextureListener, Camera.PictureCallback, Camera.ShutterCallback {


    private Camera.AutoFocusCallback myAutoFocusCallback = null;
    private Camera mCamera;

    public Camera getmCamera() {
        return mCamera;
    }
    private List<String> file=new ArrayList<>();

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }

    private int index = 0;
    private OnPictureTakenListener onPictureTakenListener;
    private MediaRecorder mMediaRecorder;
    private boolean isRecording = false;
    private OnStartVideoListener onStartVideoListener;
    private SurfaceTexture mSurface;
    private Camera.AutoFocusMoveCallback autoFocusCallback;

    public void setAutoFocusCallback(Camera.AutoFocusMoveCallback autoFocusCallback) {
        this.autoFocusCallback = autoFocusCallback;
    }

    public TextureCameraPreview(Context context) {
        this(context, null);
    }

    public TextureCameraPreview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextureCameraPreview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSurfaceTextureListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        mSurface = surface;
        openCamera();

    }

    public void autoFocus(){
      /*  Camera.Parameters parameters = mCamera.getParameters();
        parameters.setFocusMode("continuous-video");
        mCamera.setAutoFocusMoveCallback(autoFocusCallback);*/
    }

    private void openCamera() {
        // 1.打开相机
        mCamera = getCameraInstance(getContext(), index);
        autoFocus();
        if (mCamera != null) {
            // 2.设置相机参数
            Camera.Parameters parameters = mCamera.getParameters();
            // 3.调整预览方向
            mCamera.setDisplayOrientation(90);
            // 4.设置预览尺寸
            parameters.setPreviewSize(1920, 1080);
            parameters.setPictureSize(1920, 1080);
            // 5.调整拍照图片方向
            if (index == 0) {
                parameters.setRotation(90);
            }
            if (index == 1) {
                parameters.setRotation(270);
            }
            mCamera.setParameters(parameters);
            // 6.开始相机预览
            try {
                mCamera.setPreviewTexture(mSurface);
                mCamera.startPreview();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Error setting camera preview:" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        releaseCamera();
        return true;
    }

    private void releaseCamera() {
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    public static Camera getCameraInstance(Context context, int i) {
        Camera c = null;
        try {
            c = Camera.open(i);
        } catch (Exception e) {
            Toast.makeText(context, "相机打开失败", Toast.LENGTH_SHORT).show();
        }
        return c;
    }

    public void takePicture(OnPictureTakenListener listener) {
        if (listener != null) {
            onPictureTakenListener = listener;
            if (mCamera != null) {
                mCamera.takePicture(this, null, this);
            } else {
                onPictureTakenListener.onFailed("拍照失败");
            }
        }
    }

    public void setZoom(int progress) {
        if (mCamera != null) {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setZoom((int) (progress * 1.0f / (40 * 100) * 40));
            mCamera.setParameters(parameters);
        }
    }

    public void switchCamera(int index) {
        if (isRecording) {
            stopRecord();
        }
        releaseCamera();
        this.index = index;
        openCamera();
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        if (index == 1) {
            bitmap = reversalBitmap(bitmap, -1, 1);
        }
        if (onPictureTakenListener != null) {
            onPictureTakenListener.onSuccess(bitmap);
        }

        // 使拍照结束后重新预览
        releaseCamera();
        openCamera();
    }

    private Bitmap reversalBitmap(Bitmap srcBitmap, float sx, float sy) {
        Bitmap cacheBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        int w = cacheBitmap.getWidth();
        int h = cacheBitmap.getHeight();
        Canvas canvas = new Canvas(cacheBitmap);
        Matrix matrix = new Matrix();
        matrix.postScale(sx, sy);
        Bitmap bitmap = Bitmap.createBitmap(srcBitmap, 0, 0, w, h, matrix, true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, srcBitmap.getWidth(), srcBitmap.getHeight()), new Rect(0, 0, w, h), null);
        return bitmap;
    }

    @Override
    public void onShutter() {

    }

    public interface OnPictureTakenListener {
        void onSuccess(Bitmap bitmap);

        void onFailed(String msg);
    }

// ---------------- 录像

    private boolean initMediaRecorder(String outputPath) {
        mMediaRecorder = new MediaRecorder();
        if (mCamera != null) {
            // 1.解锁并将相机设置daoMediaRecorder
            mCamera.unlock();
            mMediaRecorder.setMaxDuration(10*60*1000);
            mMediaRecorder.setCamera(mCamera);
            // 2.设置资源
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
            mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            // 3.设置CamcorderProfile（需要API级别8或更高版本）
            mMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));
            // 4.设置输出文件
            mMediaRecorder.setOutputFile(outputPath);
            // 5.准备配置的MediaRecorder
            try {
                mMediaRecorder.prepare();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "录像配置准备失败", Toast.LENGTH_SHORT).show();
                releaseMediaRecorder();
                return false;
            }
            return true;
        }
        return false;
    }


    private void releaseMediaRecorder() {
        if (mMediaRecorder != null) {
            mMediaRecorder.reset();
            mMediaRecorder.release();
            mMediaRecorder = null;
        }
    }

    public void startRecord(String outputPath, OnStartVideoListener listener) {
        this.onStartVideoListener = listener;
        if (initMediaRecorder(outputPath)) {
            file.add(outputPath);
            new MediaPrepareTask(listener).execute();

        } else {
            Toast.makeText(getContext(), "开始录制视频失败", Toast.LENGTH_SHORT).show();
        }
    }
    //视频合并
    public void FinishRecord(String outPath){
        if(file!=null){
            if(file.size()==1){
                this.onStartVideoListener.RecordonFinish(outPath);
            }else{
                //合并
                FFmpeUntil.joinVideos(getContext(), file, outPath, new FFmpeUntil.FFmpeUntilListning() {

                    @Override
                    public void completeFile(String outPath) {
                         //完成合并 并且输出文件路径
                        onStartVideoListener.RecordonFinish(outPath);
                    }

                    @Override
                    public void failTorequest(String msg) {
                         //合并错误
                        /*销毁文件*/
                        onStartVideoListener.RecordonError(msg);
                    }
                });
            }
        }
    }
    public void stopRecord() {
        try {
            if (isRecording) {
                mMediaRecorder.stop();
                releaseMediaRecorder();
                mCamera.lock();
                if (onStartVideoListener != null)
                    onStartVideoListener.RecordonStop(file.get(file.size()-1));
            } else {
                releaseMediaRecorder();
            }
            isRecording = false;
        }catch (Exception e){
            Toast.makeText(getContext(), "录制视频小于1秒", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isRecording() {
        return isRecording;
    }

    class MediaPrepareTask extends AsyncTask<Void, Void, Boolean> {

        OnStartVideoListener listener;

        MediaPrepareTask(OnStartVideoListener listener) {
            this.listener = listener;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            mMediaRecorder.start();

            isRecording = true;
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (listener != null)
                listener.RecordonStart();
        }
    }

    public interface OnStartVideoListener {
        void RecordonStart();
        void RecordonFinish(String outPath);
        void RecordonStop(String path);
        void RecordonError(String error);
    }

}