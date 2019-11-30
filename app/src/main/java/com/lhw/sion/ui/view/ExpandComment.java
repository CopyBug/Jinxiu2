package com.lhw.sion.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hjq.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/10/15.
 * 让代码更加美观
 */
public class ExpandComment extends FrameLayout {

    private Context mContext;
    private View mView;
    private int load=-1;
    private boolean initLoad=true;
    private int NODATA=-1; //-1没有数据 1有数据为更新 2 数据全部加载完
    private int HaveDATATOUPDATA=1; //-1没有数据 1有数据要更新 2 数据全部加载完
    private int DATAISALLLOADED=-2; //-1没有数据 1有数据为更新 2 数据全部加载完
    @BindView(R.id.dialog_text)
    TextView dialogText;
    @BindView(R.id.dialog_rotation)
    ImageView imageView;
    ExpandListining expandListining;

    public void setExpandListining(ExpandListining expandListining) {
        this.expandListining = expandListining;
    }

    public ExpandComment(@NonNull Context context) {
        super(context);
        init(context);
    }

    public void IsetVisibility(int visibility){
        mView.setVisibility(visibility);
    }
    public ExpandComment(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ExpandComment(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        this.mContext=context;
        LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView=layoutInflater.inflate(R.layout.expand_comment,this,true);
        ButterKnife.bind(mView);
        if(initLoad){
            //有数据更新
            load=HaveDATATOUPDATA;
            mView.setVisibility(VISIBLE);
            dialogText.setText("展开回复");
        }else{
            load=NODATA;
            mView.setVisibility(GONE);
        }

        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setRotation(imageView);

            }
        });
    }

    public void isThereAnyDataNotLoaded(boolean is){
        this.initLoad=is;

    }
    public void setRotation(View view){
        if(load==HaveDATATOUPDATA){
            view.setRotation(-180);
            //展开
            load=DATAISALLLOADED;
            dialogText.setText("收起");
            if(expandListining!=null){
                expandListining.isVisable(true);
            }

        }else if(load==DATAISALLLOADED) {
            view.setRotation(-90);
            //收起
            load=HaveDATATOUPDATA;
            dialogText.setText("展开回复");
            if(expandListining!=null){
                expandListining.isVisable(false);
            }
        }

    }
enum ExpandStatue{
        //展开**数据   收起
                NOMESSAGE_STATUE,EXPAND_STATUE
    }
   public interface ExpandListining{
        void isVisable(boolean visable);
    }
}
