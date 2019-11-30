package com.lhw.sion.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hjq.demo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/9/30.
 * 让代码更加美观
 */
public class AskLayout extends FrameLayout {
    private int allcount=0;
    private int successask=0;
    Handler handler=new Handler(Looper.myLooper());
    public void setAskLayoutListinin(onAskLayoutListinin askLayoutListinin) {
        this.askLayoutListinin = askLayoutListinin;
    }

    public interface onAskLayoutListinin{
        void ask(boolean issuccess);
    }
    public boolean isclick=false;
    Context mContext;
    private View mView;
   private onAskLayoutListinin askLayoutListinin;

    @BindView(R.id.ask1)
    Button ask1;
    @BindView(R.id.ask2)
    Button ask2;
    @BindView(R.id.ask3)
    Button ask3;
    @BindView(R.id.ask4)
    Button ask4;
    private Integer ask;

    public void setAsk(Integer ask) {
        this.ask = ask;
    }

    public AskLayout(@NonNull Context context) {
        super(context);
        init(context,null);
    }

    public AskLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public AskLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    public void init(Context context,AttributeSet attrs){
        this.mContext=context;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.item_ask, this, true);
        ButterKnife.bind(mView);
    }
    public void setbutton(List<String> questionlist){
        if(questionlist!=null){
            if(questionlist.size()==4){
                ask1.setText(questionlist.get(0));
                ask2.setText(questionlist.get(1));
                ask3.setText(questionlist.get(2));
                ask4.setText(questionlist.get(3));
            }
        }
    }

   @OnClick({R.id.ask1,R.id.ask2,R.id.ask3,R.id.ask4})
    public void onClick(View v) {
        if(!isclick){
            switch (v.getId()){
                case R.id.ask1:
                    ask(0,ask1);
                    break;
                case R.id.ask2:
                    ask(1,ask2);
                    break;
                case R.id.ask3:
                    ask(2,ask3);
                    break;
                case R.id.ask4:
                    ask(3,ask4);
                    break;
            }
            isclick=true;
        }

    }

    public int getAllcount() {
        return allcount;
    }

    public int getSuccessask() {
        return successask;
    }

    public void ask(int position, Button button){
        allcount+=1;
        boolean success = isSuccess(position);

        if(success){
            askSuccess(position,button);
            successask+=1;
        }else{
            askError(position,button);
            Ssuo();//闪烁
        }

//        等待动画结束
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(askLayoutListinin!=null){
                    askLayoutListinin.ask(success);
                }
            }
        },700);

    }
    public boolean isSuccess(int position){

     return ask==position?true:false;
    }
    public void askError(int position,Button button){
        //回答错误 布局变红色 并且振动
        vibrator();//振动
        anivibrator(button);//振动控件
        button.setBackgroundResource(R.drawable.bg_ask_button_warn);
    }
    public void askSuccess(int position,Button button){
        //回答成功 改变单词状态
        button.setBackgroundResource(R.drawable.bg_ask_button_success);


    }
    public void Ssuo(){
        Button[] buttons=new Button[]{ask1,ask2,ask3,ask4};
        AlphaAnimation alphaAnimation1 = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation1.setDuration(500);
        alphaAnimation1.setRepeatCount(2);
        alphaAnimation1.setRepeatMode(Animation.RESTART);
        buttons[ask].setAnimation(alphaAnimation1);
        alphaAnimation1.start();
    }
    public void vibrator(){
        Vibrator vibrator = (Vibrator)mContext.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);
    }
    public void anivibrator(Button button){
        TranslateAnimation animation = new TranslateAnimation(0, -10, 0, 0);
        animation.setInterpolator(new OvershootInterpolator());
        animation.setDuration(50);
        animation.setRepeatCount(10);
        animation.setRepeatMode(Animation.REVERSE);
        button.startAnimation(animation);

    }

    public void initview(){
        ask1.setBackgroundResource(R.drawable.bg_ask_button);
        ask2.setBackgroundResource(R.drawable.bg_ask_button);
        ask3.setBackgroundResource(R.drawable.bg_ask_button);
        ask4.setBackgroundResource(R.drawable.bg_ask_button);
        isclick=false;

    }
}
