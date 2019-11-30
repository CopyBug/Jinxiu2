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

/**
 * 作者： 梁浩文, 日期： 2019/10/16.
 * 让代码更加美观
 */
public class ExpandView extends FrameLayout {
    View mView;
    @BindView(R.id.dialog_text)
    TextView dialog_text;
    @BindView(R.id.dialog_rotation)
    ImageView dialog_rotation;
    boolean isExpand=false;
    String EXPAND="收起";
    String UNEXPAND="展开更多消息";
    public ExpandListning expandListning;

    public void setExpandListning(ExpandListning expandListning) {
        this.expandListning = expandListning;
    }

    public ExpandView(@NonNull Context context) {
        super(context);
        initView(context);
    }


    public ExpandView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ExpandView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public ExpandView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.expand_comment, this, true);
        ButterKnife.bind(mView);
        initData();
    }

    private void initData() {
        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExpand){
                    dialog_text.setText(EXPAND);
                    dialog_rotation.setRotation(-180);
                }else{
                    dialog_text.setText(UNEXPAND);
                    dialog_rotation.setRotation(0);
                }
                if(expandListning!=null){
                    expandListning.isExpand(isExpand);
                }
                isExpand=!isExpand;
            }
        });
    }

    public interface ExpandListning{
        void isExpand(boolean isexpand);
    }
}
