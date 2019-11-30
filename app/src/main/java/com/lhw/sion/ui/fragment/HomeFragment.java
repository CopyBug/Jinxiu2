package com.lhw.sion.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.hjq.demo.R;
import com.hjq.demo.databinding.FragmentHomeBinding;
import com.lhw.sion.bean.HomeBean;
import com.lhw.sion.bean.MFragment;
import com.lhw.sion.mvp.contract.ContractFragmentHome;
import com.lhw.sion.mvp.presenter.PresenterFragmentHomeImp;
import com.lhw.sion.ui.activity.LearnActivity;
import com.lhw.sion.ui.activity.PkActivity;
import com.lhw.sion.ui.activity.SearchActivity;
import com.lhw.sion.widget.XCollapsingToolbarLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者： 梁浩文, 日期： 2019/9/25.
 * 让代码更加美观
 */
public class HomeFragment extends MFragment implements ContractFragmentHome.View, XCollapsingToolbarLayout.OnScrimsListener {
    ContractFragmentHome.Presenter fragmentHomeImp;
    private FragmentHomeBinding binding;
    @BindView(R.id.ctl_test_bar)
    XCollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.t_test_title)
    Toolbar mToolbar;
    @BindView(R.id.tv_test_search)
    TextView mSearchView;

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_home;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected void initView() {
        // 给这个ToolBar设置顶部内边距，才能和TitleBar进行对齐
        ImmersionBar.setTitleBar(getAttachActivity(), mToolbar);
        //设置渐变监听
        mCollapsingToolbarLayout.setOnScrimsListener(this);

    }

    @Override
    protected void initData() {
        binding = (FragmentHomeBinding) getDataBing(FragmentHomeBinding.class);
        fragmentHomeImp = new PresenterFragmentHomeImp(this);
        fragmentHomeImp.initInfoUser();//初始化数据


    }


    @Override
    public void bindData(HomeBean beanBean) {
        binding.setHome(beanBean);
    }

    @Override
    public FragmentActivity setActivity() {
        return getActivity();
    }


    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }

    /**
     * CollapsingToolbarLayout 渐变回调
     * <p>
     * {@link XCollapsingToolbarLayout.OnScrimsListener}
     */
    @Override
    public void onScrimsStateChange(XCollapsingToolbarLayout layout, boolean shown) {
        if (shown) {

            mSearchView.setBackgroundResource(R.drawable.bg_home_search_bar_gray);
            getStatusBarConfig().statusBarDarkFont(true).init();
        } else {

            mSearchView.setBackgroundResource(R.drawable.bg_home_search_bar_transparent);
            getStatusBarConfig().statusBarDarkFont(false).init();
        }
    }

    @OnClick({R.id.btn_recite_commit, R.id.tv_test_search, R.id.btn_recite_pk})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_recite_commit:
                //背单词
                startActivity(LearnActivity.class);
                break;
            case R.id.tv_test_search:
                //搜索界面
                startActivityForResult(new Intent(getActivity(), SearchActivity.class), null);
                break;
            case R.id.btn_recite_pk:
                startActivityForResult(new Intent(getActivity(), PkActivity.class), null);
                break;
        }
    }

    @Override
    public void noneNet() {

    /*    //没有网
        BaseDialog.Builder builder = new BaseDialogFragment.Builder(getActivity()).setContentView(R.layout.custom_error_view).setOnClickListener(R.id.reline, new BaseDialog.OnClickListener() {
            @Override
            public void onClick(BaseDialog dialog, View view) {

            }
        });
        builder.setBackgroundDimEnabled(false);
        builder.show();*/
/*        final int index = ((ViewGroup) getView().getParent()).indexOfChild(getView());
        ViewGroup.LayoutParams params = getView().getLayoutParams();*/
  /*      ViewGroup parent = (ViewGroup) getView().getParent();
        parent.removeView(getView());*/

//        LayoutInflater.from(getContext()).inflate(R.layout.custom_error_view,null,false);
//        parent.addView(view);
        View view = getLayoutInflater().inflate(R.layout.custom_error_view, getContainer());
        getActivity().setContentView(view);
    }



}
