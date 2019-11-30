package com.lhw.sion.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hjq.demo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/10/21.
 * 让代码更加美观
 */
public class YNlayout extends FrameLayout {

    private View inflate;
    private YnListning listning;

    public void setListning(YnListning listning) {
        this.listning = listning;
    }

    public YNlayout(@NonNull Context context) {
        super(context);
        initview(context);
    }


    public YNlayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }

    public YNlayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview(context);
    }

    private void initview(Context context) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflate = inflater.inflate(R.layout.layout_is_send, this, true);
        ButterKnife.bind(inflate);
    }
    public void isSubmit(int Visable){
        inflate.setVisibility(Visable);
    }
    @OnClick({R.id.icon_yes,R.id.icon_no})
    public  void OnClick(View view){
        isSubmit(GONE);
        switch (view.getId()){
            case R.id.icon_yes:
                listning.YnSelect(true);

                break;
            case R.id.icon_no:
                listning.YnSelect(false);
                break;
        }

    }
    public interface YnListning{
        void YnSelect(boolean isSend);
    }
}
