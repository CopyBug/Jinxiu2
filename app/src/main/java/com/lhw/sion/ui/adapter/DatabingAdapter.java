package com.lhw.sion.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjq.demo.R;
import com.lhw.sion.mvp.contract.BaseContract;
import com.lhw.sion.mvp.contract.ContractRecommend;
import com.lhw.sion.mvp.presenter.BasePresenter;

import java.util.List;

import sion.my.jinxiu.bean.SelectVideo;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class DatabingAdapter<T> extends BaseQuickAdapter<T, DatabingAdapter.RecommentViewHolder> {
    private int mVariable;
    private int mpresenterVariable;
    BasePresenter mPresenter;
    public DatabingAdapter(int layoutResId, @Nullable List<T> data, BasePresenter mPresenter,int mVariable,int mpresenterVariable) {
        super(layoutResId, data);
        this.mPresenter=mPresenter;
        this.mVariable=mVariable;
        this.mpresenterVariable=mpresenterVariable;
    }


    @Override
    protected void convert(RecommentViewHolder helper, T item) {
        ViewDataBinding binding = helper.getBinding();
        binding.setVariable(mVariable, item);
        binding.setVariable(mpresenterVariable,mPresenter);
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }


    public static class RecommentViewHolder extends BaseViewHolder {

        public RecommentViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }

    }
}
