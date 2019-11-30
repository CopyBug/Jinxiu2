package com.lhw.sion.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.animation.AnimationUtils;
import com.hjq.demo.R;
import com.lhw.sion.until.Until;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/10/1.
 * 让代码更加美观
 */
public class CareViewlayout extends FrameLayout {
    Context mContext;
    @BindView(R.id.Clause)
    TextView Clause;
    @BindView(R.id.transaction)
    TextView transaction;
    @BindView(R.id.more)
    Button more;
    @BindView(R.id.item_music)
    ImageView item_music;
    Boolean isvisable=false;

    public String getMusicmp() {
        return musicmp;
    }

    public void setMusicmp(String musicmp) {
        this.musicmp = musicmp;
    }

    private String musicmp=null;
    private View mView;

    public CareViewlayout(@NonNull Context context) {
        super(context);
        init(context,null);
    }

    public CareViewlayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CareViewlayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    public void init(Context context,AttributeSet attrs){
        mContext=context;
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.item_carview, this, true);
        ButterKnife.bind(mView);
    }


    public void setClause(String text){
      if(this.Clause!=null){

          Clause.setText(text);
      }
    }

    /**
     * @param transaction 释义
     */
    public void setTransaction(String transaction){
      if(this.transaction!=null){
          this.transaction.setText(transaction);
      }
    }
    @OnClick({R.id.more,R.id.transaction,R.id.item_music})
    public void click(View view){
        switch (view.getId()){
            case R.id.more:

                visableButton();

                break;
            case R.id.transaction:
                visableTransaction();

                break;
            case R.id.item_music:
             if(musicmp!=null){
                 int duration = Until.StartPlay(mContext, musicmp);
                 Until.Startanim(item_music,duration);
             }

                break;
        }
    }

    public void visableButton(){
        more.setVisibility(GONE);
        transaction.setVisibility(VISIBLE);
        isvisable=false;
    }

    public void visableTransaction(){
        more.setVisibility(VISIBLE);
        transaction.setVisibility(GONE);
        isvisable=true;
    }
    //A large passenger aircraft will land on the airfield.一架大型民航班机将降落在这个飞机场。
    //Only experienced pilots fly large passenger aircraft.只有有经验的飞行员才能驾驶大型客机。
    //The watchtower followed the aircraft by radar.瞭望塔通过雷达追踪这架飞机的行踪。
    //The aircraft company deals with freight only.这家航空公司只经营货运业务。
    //All aircraft must fuel before flight.所有飞机飞行前都必须加油。
    //The new aircraft is undergoing safety tests.这种新飞机正在接受安全性能检验。
    //The speed of this aircraft is very high.这架飞机的速度非常快。

}
