package com.lhw.sion.ui.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.MenuItem;

import com.dueeeke.videoplayer.player.VideoViewManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.hjq.base.BaseFragmentAdapter;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivityLearnVideoBinding;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.ui.fragment.MyAudioFragment;
import com.lhw.sion.ui.fragment.RecommendFragment;

import butterknife.BindView;

public class LearnVideoActivity extends MyActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

ActivityLearnVideoBinding binding;
    @BindView(R.id.video_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.video_tablayout)
    TabLayout mTabLayout;
    private BaseFragmentAdapter<Fragment> mPagerAdapter;
    private int[] tabs=new int[]{R.string.learnvideo_person_nav_tab1,R.string.learnvideo_person_nav_tab2};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_learn_video;
    }

    @Override
    protected void initView() {
        SetActivity(this);
    }


    @Override
    protected void initData() {
        binding= (ActivityLearnVideoBinding) super.viewDataBinding;
        for (int i = 0; i < tabs.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab());
        }
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(RecommendFragment.newInstance());
        mPagerAdapter.addFragment(MyAudioFragment.newInstance());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i <tabs.length ; i++) {
            mTabLayout.getTabAt(i).setText(getResources().getText(tabs[i]));
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            if(position==0){
                VideoViewManager.instance().resume();
            }else{
                VideoViewManager.instance().pause();
            }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_recommend:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.menu_me:
                mViewPager.setCurrentItem(1);
                break;
        }
        return false;
    }

    @Override
    protected void onPause() {
        Log.i("onPause", "onPause: ");
        VideoViewManager.instance().pause();
        super.onPause();

    }

    @Override
    protected void onRestart() {
        int currentItem = mViewPager.getCurrentItem();
        if(currentItem==0){
            VideoViewManager.instance().resume();
        }


        super.onRestart();
    }
}
