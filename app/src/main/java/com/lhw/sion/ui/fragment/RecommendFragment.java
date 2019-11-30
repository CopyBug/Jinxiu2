package com.lhw.sion.ui.fragment;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dueeeke.videoplayer.player.VideoView;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.hjq.base.BaseLazyFragment;
import com.hjq.demo.R;
import com.lhw.sion.bean.MFragment;
import com.lhw.sion.mvp.contract.ContractRecommend;
import com.lhw.sion.mvp.presenter.PresenterRecommendImp;
import com.lhw.sion.ui.adapter.PullToRefreshAdapter;
import com.lhw.sion.ui.manager.MyLayoutManager;
import com.lhw.sion.ui.manager.OnViewPagerListnener;
import com.lhw.sion.ui.view.loadmore.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import sion.my.jinxiu.bean.SelectVideo;

/**
 * 作者： 梁浩文, 日期： 2019/10/11.
 * 让代码更加美观
 */
public class RecommendFragment extends MFragment implements ContractRecommend.View, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rv_video)
    RecyclerView rv_video;
    @BindView(R.id.recomment_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    List<SelectVideo.BeanBean> datalist=new ArrayList<>();
    PullToRefreshAdapter pullToRefreshAdapter;
    MyLayoutManager layoutManager;
    private ContractRecommend.Presenter mPresenter;



    public static MFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {

        pullToRefreshAdapter=new PullToRefreshAdapter(datalist,this);
        pullToRefreshAdapter.setLoadMoreView(new CustomLoadMoreView());
        layoutManager=new MyLayoutManager(getContext(), OrientationHelper.VERTICAL,false);
        rv_video.setLayoutManager(layoutManager);
        rv_video.setAdapter(pullToRefreshAdapter);

    }



    @Override
    protected void initData() {
        mPresenter = new PresenterRecommendImp(this);
        mPresenter.loadNextLoad(true,false);
        swipeRefreshLayout.setOnRefreshListener(this);
        initListener();
    }

    public void initListener(){
        layoutManager.setmOnViewPagerListnener(new OnViewPagerListnener() {
            @Override
            public void onPageRelease(boolean isNext, int position, View view) {
                int index = 0;
                if (isNext){
                    index = 0;
                }else {
                    index = 1;
                }

                VideoView videView = findVideView(index);
                if(videView!=null){
                    videView.pause();
                }
            }

            @Override
            public void onPageSelected(int position, boolean isBotton, View view) {

                VideoView videView = findVideView(0);
                if(videView!=null){
                   if(!videView.isPlaying()){
                       videView.release();
                       videView.start();
                   }
                }
            }

            @Override
            public void isScrollinig(int position, boolean isBotton) {


//                playVideo(0);
            }
        });


        pullToRefreshAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.loadNextLoad(false,false);
            }
        });
    }



    @Override
    public FragmentActivity setActivity() {
        return getActivity();
    }
    public VideoView findVideView(int  position){
        View childAt = rv_video.getChildAt(position);
        if(childAt!=null){
          return   childAt.findViewById(R.id.player);
        }else{
            return null;
        }
    }





    @Override
    public void setSelectVideo(List<SelectVideo.BeanBean> beanBean) {
        if(beanBean!=null){
            for (int i = 0; i < beanBean.size(); i++) {
                pullToRefreshAdapter.addData(beanBean.get(i));
            }
            pullToRefreshAdapter.loadMoreComplete();
        }else{

            pullToRefreshAdapter.loadMoreEnd();
        }



    }

    @Override
    public void relushVideo(List<SelectVideo.BeanBean> beanBean) {
        if(swipeRefreshLayout.isRefreshing()){
            if(beanBean!=null){
                pullToRefreshAdapter.setNewData(beanBean);
                pullToRefreshAdapter.setEnableLoadMore(true);
//                pullToRefreshAdapter.loadMoreComplete();
            }else{

//                pullToRefreshAdapter.loadMoreEnd();
            }

            swipeRefreshLayout.setRefreshing(false);

        }
    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onRefresh() {

        pullToRefreshAdapter.setEnableLoadMore(false);
        VideoViewManager.instance().pause();
        rv_video.removeAllViews();
        mPresenter.loadNextLoad(true,true);

    }

    @Override
    public void onDestroy() {
        VideoViewManager.instance().pause();
        super.onDestroy();

    }
}
