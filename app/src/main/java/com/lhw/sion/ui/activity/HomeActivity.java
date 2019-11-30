package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hjq.base.BaseActivity;
import com.hjq.base.BaseFragmentAdapter;
import com.hjq.demo.R;
import com.lhw.sion.bean.MFragment;
import com.lhw.sion.common.BindingListining;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractHome;
import com.lhw.sion.mvp.presenter.PresenterHomeimp;
import com.lhw.sion.ui.fragment.MoveFragment;
import com.lhw.sion.ui.fragment.RankFragment;
import com.lhw.sion.ui.fragment.HomeFragment;
import com.lhw.sion.ui.fragment.PersonalDataFragment;

import butterknife.BindView;
import sion.my.jinxiu.bean.SelectUserBean;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : 主页界面
 */
public final class HomeActivity extends MyActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ContractHome.View, BindingListining {


    public    SelectUserBean selectUserBean;
    ContractHome.Presenter presenter;
    public static BaseActivity activity;
    @BindView(R.id.vp_home_pager)
    ViewPager mViewPager;
    @BindView(R.id.bv_home_navigation)
    BottomNavigationView mBottomNavigationView;
    int[] navigationid;
    /**
     * ViewPager 适配器
     */
    private BaseFragmentAdapter<MFragment> mPagerAdapter;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_home;
    }


    @Override
    protected void initView() {
        // 不使用图标默认变色
        SetActivity(this);
        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initData() {
            activity=getActivity();
            presenter=new PresenterHomeimp(this,this);
            mPagerAdapter = new BaseFragmentAdapter<>(this);
            mPagerAdapter.addFragment(HomeFragment.newInstance());
            mPagerAdapter.addFragment(RankFragment.newInstance());
            mPagerAdapter.addFragment(MoveFragment.newInstance());
            mPagerAdapter.addFragment(PersonalDataFragment.newInstance());
            mViewPager.setAdapter(mPagerAdapter);

            // 限制页面数量
            mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
            presenter.SelectUserBean();
            navigationid= new int[]{R.id.menu_home, R.id.home_found, R.id.home_message, R.id.home_me};
            initpage();


    }
    public void initpage(){
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        mViewPager.setCurrentItem(position);
        mBottomNavigationView.setSelectedItemId(navigationid[position]);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                mViewPager.setCurrentItem(0);
                return true;
            case R.id.home_found:
                mViewPager.setCurrentItem(1);
                return true;
            case R.id.home_menu:
                presenter.SelectUserBean();
                presenter.initDialogView(selectUserBean);
                return true;
            case R.id.home_message:
                mViewPager.setCurrentItem(2);
                return true;
            case R.id.home_me:

                mViewPager.setCurrentItem(3);
                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public void setSelectUserBean(SelectUserBean selectUserBean) {
        this.selectUserBean=selectUserBean;

    }

    @Override
    public View getDialogView() {
        return  LayoutInflater.from(this).inflate(R.layout.dialog_botton_menu,getContentView(),false);

    }



    @Override
    public FragmentActivity setActivity() {
        return this;
    }

    @Override
    public void click(int position) {
        presenter.hidedialog();
        switch (position){
            case 0:
                //个人中心
                mBottomNavigationView.setSelectedItemId(R.id.home_me);
                mViewPager.setCurrentItem(3);
                break;
            case 1:
                //统计中心
                startActivityForResult(MyJourney.class,null);
                break;
            case 2:
                //夜间模式
                break;
            case 3:
                //视频学习
                startActivityForResult(LearnVideoActivity.class,null);
                break;
            case 4:
                //工具箱
                break;
            case 5:
                //错题本
                break;
            case 6:
                //搜索
                startActivityForResult(SearchActivity.class,null);
                break;
            case 7:
                //设置
                startActivityForResult(SettingActivity.class,null);
                break;
            case 8:
                //注销
                startActivityFinish(LoginActivity.class);
                break;
            case 9:
                //退出
                break;
        }

    }

    @Override
    protected void onRestart() {
        SetActivity(this);
        super.onRestart();
    }
}