package com.lhw.sion.bean;

import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;


/**
 * Created by Lionel on 2019/5/6.
 */

public abstract class DataBindingRecyclerAdapterListener<T extends ViewDataBinding> {
    public abstract DataBindingRecyclerHolder<T> onCreateHolder(View itemView, ViewGroup parent, int viewType);
    public void onBind(DataBindingRecyclerHolder<T> holder, int position) {}
    public void onBind(DataBindingRecyclerHolder<T> holder, int position, Object data) {}
}
