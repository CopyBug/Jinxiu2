package com.lhw.sion.ui.fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.demo.BR;
import com.hjq.demo.R;
import com.hjq.demo.databinding.FragmentRankBinding;
import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.bean.DatabingRank;
import com.lhw.sion.common.MyLazyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者： 梁浩文, 日期： 2019/10/10.
 * 让代码更加美观
 */
public class FragmentRank extends MyLazyFragment {
    @BindView(R.id.rank_recy)
    RecyclerView rank_recy;
    private FragmentRankBinding dataBing;
    DataBindingRecyclerAdapter dataBindingRecyclerAdapter;
    List<DatabingRank> rankList;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rank;
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        rank_recy.setLayoutManager(linearLayoutManager);
        rank_recy.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initData() {
        rankList=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            rankList.add(new DatabingRank());
        }
        dataBing = (FragmentRankBinding) getDataBing(FragmentRankBinding.class);
        dataBindingRecyclerAdapter=new DataBindingRecyclerAdapter(rankList,R.layout.item_recy_rank, BR.rank);
        dataBing.setRankAdapter(dataBindingRecyclerAdapter);

    }
}
