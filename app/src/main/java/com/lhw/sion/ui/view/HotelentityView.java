package com.lhw.sion.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.hjq.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class HotelentityView extends FrameLayout {
    @BindView(R.id.item_choice)
    AppCompatImageView item_choice;
    @BindView(R.id.item_parentControl)
    TextView item_parentControl;
    @BindView(R.id.item_childControl)
    TextView item_childControl;
    @BindView(R.id.item_parent)
    RelativeLayout item_parent;
    @BindView(R.id.m_content)
    LinearLayout m_content;
    private boolean isopen=true;
    private Context mContext;
    private View mView;

    public HotelentityView(@NonNull Context context) {
        super(context);
        initView(context, null);
    }

    public HotelentityView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public HotelentityView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public void initView(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.item_recy_hotelentity, this, true);
        ButterKnife.bind(mView);
        //初始化xml属性
        initAttrs(attrs);

    }
    public void setParentText(String parentText){
        item_parentControl.setText(parentText);
    }
    public void setChildText(String childText){
        item_childControl.setText(childText);
    }

    private void initAttrs(AttributeSet attrs) {
        if(attrs!=null){
//            int [] item_recy_hotelentity={R.attr.parentText,R.attr.subtext};
            TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.item_secondaryLinkage);
//            String parentext = typedArray.getString(0);
//            String subtext = typedArray.getString(1);
            if(typedArray.hasValue(R.styleable.item_secondaryLinkage_parentText)){
                String parentext = typedArray.getString(R.styleable.item_secondaryLinkage_parentText);
                item_parentControl.setText(parentext==null?"":parentext);
            }
            if(typedArray.hasValue(R.styleable.item_secondaryLinkage_subtext)){
                String subtext = typedArray.getString(R.styleable.item_secondaryLinkage_subtext);
                item_childControl.setText(subtext==null?"":subtext);
            }


        }
    }
    @OnClick(R.id.item_parent)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.item_parent:
                openItem();
                break;
        }
    }

    /**
     * isopen true打开 false关闭
     */
    public void openItem(){
        isopen=!isopen;
        if(isopen){
            item_choice.setImageResource(R.drawable.icon_dot_on);

            item_childControl.setVisibility(VISIBLE);
        }else{
            item_choice.setImageResource(R.drawable.icon_dot_off);

            item_childControl.setVisibility(GONE);
        }
    }
    //默认展开


    interface ItemsecondaryLinkageListining{

    }
}
