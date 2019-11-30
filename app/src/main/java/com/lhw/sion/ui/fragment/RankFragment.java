package com.lhw.sion.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hjq.demo.R;
import com.lhw.sion.bean.MFragment;
import com.lhw.sion.ui.adapter.MfragmentAdapters;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者： 梁浩文, 日期： 2019/9/25.
 * 让代码更加美观
 */
public class RankFragment extends MFragment {
    @BindView(R.id.discovery_tab)
    TabLayout tabLayout;
    @BindView(R.id.discovery_page)
    ViewPager viewPager;
    MfragmentAdapters mfragmentAdapters;
    List<Fragment> fragmentList;
    List<String> titlelist;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    public static RankFragment newInstance() {
        return new RankFragment();
    }

    @Override
    protected void initView() {

    }
    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
    @Override
    protected void initData() {
        fragmentList=new ArrayList<>();
        titlelist=new ArrayList<>();
        titlelist.add("排行榜");
        titlelist.add("留言板");
        fragmentList.add(new FragmentRank());
        fragmentList.add(new FragmentMessage());
        mfragmentAdapters=new MfragmentAdapters(getFragmentManager(),fragmentList,titlelist);
        viewPager.setAdapter(mfragmentAdapters);
        tabLayout.setupWithViewPager(viewPager);
    }
}
