package com.lhw.sion.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hjq.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 梁浩文, 日期： 2019/9/29.
 * 让代码更加美观
 */
public class CulationLayout extends FrameLayout implements View.OnClickListener {
    Handler handler=new Handler(Looper.myLooper());
    Context mContext;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textview)
    TextView textView;
    private View mView;
    private boolean isblue=false;
    private AnimationDrawable animationDrawable;
    private String video;//URL
    private String text;//文字

    public void setText(String text) {
        this.text = text;
        textView.setText(text);
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public CulationLayout(@NonNull Context context) {
        super(context);
        init(context,null);
    }

    public CulationLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CulationLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public void init(Context context, AttributeSet attributeSet) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.item_culation, this, true);
        ButterKnife.bind(mView);
        initdata();
        mView.setOnClickListener(this);
    }

    private void initdata() {

    }

    public void start_culation() {
        if(!isblue){
            imageView.setImageResource(R.drawable.bg_culation);

        }else{
            //变蓝色
//            imageView.setImageResource(R.drawable.bg_culation);
//            textView.setTextColor(R.color.blue02);
        }

        animationDrawable=(AnimationDrawable)imageView.getDrawable();
        animationDrawable.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationDrawable.stop();
            }
        },2000);

    }
    public void start_video(){
            //播放音乐
        if(video!=null){
            try {

                MediaPlayer mediaPlayer=new MediaPlayer();
                try {
                    mediaPlayer.setDataSource( mContext, Uri.parse(video));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onClick(View v) {
        start_culation();//开始播放按钮
        start_video();//播放音乐
    }
    public void startplay(){
        start_video();
    }
}
