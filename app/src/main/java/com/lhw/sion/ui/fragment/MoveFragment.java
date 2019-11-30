package com.lhw.sion.ui.fragment;

import com.hjq.demo.R;
import com.lhw.sion.bean.MFragment;
import com.lhw.sion.common.MyLazyFragment;
import com.lhw.sion.ui.activity.HomeActivity;

/**
 * 作者： 梁浩文, 日期： 2019/10/11.
 * 让代码更加美观
 */
public class MoveFragment extends MFragment {
    public static MFragment newInstance() {
        return new MoveFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_move;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
