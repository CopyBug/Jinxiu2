package com.lhw.sion.bean;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.demo.R;
import com.lhw.sion.common.BindingListining;

import java.util.List;


public class DataBindingRecyclerAdapter<T> extends RecyclerView.Adapter  {
    protected  boolean isScrolling=false;

    public void setScrolling(boolean scrolling) {
        isScrolling = scrolling;
    }

    public List<T> getDatalist() {
        return datalist;
    }

    private List<T> datalist;
    private int layoutId;
    private int variableId;
    View view;
    private BindingListining bindingListining;

    public DataBindingRecyclerAdapter(List<T> datalist, int layoutId, int variableId) {
      this.datalist=datalist;
        this.layoutId = layoutId;
        this.variableId = variableId;
//        this.setHasStableIds(true);
    }

    public void setBindingListining(BindingListining bindingListining) {
        this.bindingListining = bindingListining;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view=null;
        if(layoutId!=-1){
            view=LayoutInflater.from(viewGroup.getContext()).inflate(layoutId,viewGroup,false);
        }

        return new DataBindingRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(variableId!=-1){
            DataBindingRecyclerHolder viewHolder = (DataBindingRecyclerHolder) holder;

            T t =(T) datalist.get(position);
            viewHolder.dataBinding.setVariable(variableId,t);

            viewHolder.dataBinding.notifyChange();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(bindingListining!=null){
                        bindingListining.click(position);

                    }
                }
            });


        }

    }
    //当用户滑动一半的话加载第二页的数据


    @Override
    public int getItemCount() {
        return datalist!=null?datalist.size():0;
    }



}
