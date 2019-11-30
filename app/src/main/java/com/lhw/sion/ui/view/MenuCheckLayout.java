package com.lhw.sion.ui.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hjq.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 梁浩文, 日期： 2019/10/20.
 * 让代码更加美观
 */
public class MenuCheckLayout extends FrameLayout
{
    private List<ImageView> imageViews = new ArrayList<>();
    Context mContext;
    boolean isOpen=false;
    private View mView;
    @BindView(R.id.iv_a)
    ImageView iv_a;
    @BindView(R.id.iv_b)
    ImageView iv_b;
    @BindView(R.id.iv_c)
    ImageView iv_c;
    int height ;
    ViewGroup.LayoutParams layoutParams;
    public MenuCheckLayout(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public MenuCheckLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MenuCheckLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    public void setImagesArray(List<Integer> imagesArray){

    }
    public void initView(Context context){
        this.mContext=context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.layout_menu_check, this, true);
        ButterKnife.bind(mView);
        imageViews.add(iv_a);
        imageViews.add(iv_b);
        imageViews.add(iv_c);
        initListning();


    }
    public void initListning(){
        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    close();

                }else{
                    open();
                }
                isOpen=!isOpen;
            }
        });
    }
    private void close(){
        //1.要遍历所有视图
        for (int i = 1;i<imageViews.size();i++){
            //取出每张图片
            ImageView iv = imageViews.get(i);
            //计算每个图标之间的夹角
            double avgAngle = (90/(imageViews.size()-1));
            //计算出每个图标的角度
            double angle = avgAngle*i;
            //计算每个图标的x位移
            int translationX = -(int)(200*Math.sin(angle));
            //计算每个图标的y位移
            int translationY = -(int)(200*Math.cos(angle));
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(iv,"translationX",translationX,0f);
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(iv,"translationY",translationY,0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500);
            animatorSet.play(objectAnimatorX).with(objectAnimatorY);
            animatorSet.start();
        }
    }

    //定义打开动画
    private void open(){
        //1.要遍历所有视图，i=1是为了让第一张图片保持不动


        for (int i = 1;i<imageViews.size();i++){
            //取出每张图片
            ImageView iv = imageViews.get(i);
            //计算每个图标之间的夹角
//            double avgAngle = (90/(imageViews.size()-1));
            //计算出每个图标的角度
//            double angle = avgAngle*i;
            //计算每个图标的x位移

            //计算每个图标的y位移
//            int translationY = -(int)(200*Math.cos(angle));
            //给图片添加动画
            ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(iv,"translationX",0f,iv.getTranslationX());
            ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(iv,"translationY",0f,iv.getTranslationY()-((i+1)*100));
            //new一个对象 Animator为组合动画
            AnimatorSet animatorSet = new AnimatorSet();
            //设置动画过程的时长
            animatorSet.setDuration(1000);
            //添加弹性效果
            animatorSet.setInterpolator(new BounceInterpolator());
            //使动画在x轴和y轴同时移动
            animatorSet.play(objectAnimatorX).with(objectAnimatorY);
            animatorSet.start();
        }
    }
}
