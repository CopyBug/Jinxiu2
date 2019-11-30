package com.lhw.sion.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hjq.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者： 梁浩文, 日期： 2019/9/27.
 * 让代码更加美观
 */
public class LearnLayout extends FrameLayout {
    private Context mContext;
    private View mview;
    @BindView(R.id.cardcount)
    TextView cardcount;
    @BindView(R.id.star1)
    ImageView star1;
    @BindView(R.id.star2)
    ImageView star2;
    @BindView(R.id.star3)
    ImageView star3;

    ImageView[] views;
    int stars=0;
    private String string;

    public LearnLayout(@NonNull Context context) {
        super(context);
        init(context,null);

    }

    public LearnLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public LearnLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
        public void init(Context context,AttributeSet attributeSet){
                mContext=context;
            LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mview = inflater.inflate(R.layout.view_layout_learn_item, this, true);
            initxml(attributeSet);
            ButterKnife.bind(this);
            if(string!=null){
                cardcount.setText(string);
            }

            views= new ImageView[]{star1, star2, star3};
            initdraw();

        }
        public void setshut(int shut){
        cardcount.setText(shut+"");
        }

        public void setStars(int stars){
            initdraw();//初始化
            for (int i = 0; i <stars ; i++) {

                Glide.with( views[i].getContext())
                        .load(R.drawable.icon_star)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                        .into((ImageView) views[i]);
            }
            this.stars=stars;
        }
        public void initdraw(){
            for (int i = 0; i < views.length; i++) {
                Glide.with( views[i].getContext())
                        .load(R.drawable.icon_star_off)
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                        .into((ImageView) views[i]);

            }
        }
    public void setButtonBackground(int id){
        cardcount.setBackgroundResource(id);
    }

    public void initxml(AttributeSet attrs){
        TypedArray ta = mContext.obtainStyledAttributes(attrs,R.styleable.myView);
        string = ta.getString(R.styleable.myView_text);
        //记得此处要recycle();
        ta.recycle();
    }
    public void  setText(String tv){
        cardcount.setText(tv);
    }
}
