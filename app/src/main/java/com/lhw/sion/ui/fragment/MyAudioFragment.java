package com.lhw.sion.ui.fragment;

import android.view.View;

import com.hjq.demo.R;
import com.lhw.sion.bean.MFragment;
import com.lhw.sion.ui.activity.VideoActivityLoacalActivity;

import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/10/11.
 * 让代码更加美观
 */
public class MyAudioFragment extends MFragment {

    public static MFragment newInstance() {
        return new MyAudioFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_myaudio;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
    @OnClick(R.id.admissionOfSmallVideos)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.admissionOfSmallVideos:
                startActivityForResult(VideoActivityLoacalActivity.class,null);
                break;
        }
    }
}
