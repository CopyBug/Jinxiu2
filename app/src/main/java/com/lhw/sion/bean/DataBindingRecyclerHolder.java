package com.lhw.sion.bean;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Lionel on 2019/5/6.
 */

public class DataBindingRecyclerHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public T dataBinding;

    public DataBindingRecyclerHolder(View itemView) {
        super(itemView);
        dataBinding = DataBindingUtil.bind(itemView);
    }
}
