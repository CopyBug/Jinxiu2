package com.lhw.sion.ui.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.VideoView;
import com.hjq.demo.BR;
import com.hjq.demo.R;
import com.lhw.sion.common.MyLazyFragment;
import com.lhw.sion.mvp.contract.ContractRecommentFragment;
import com.lhw.sion.mvp.presenter.PresenterRecommentFragment;

import java.util.List;

import sion.my.jinxiu.bean.SelectVideo;

/**
 * 作者： 梁浩文, 日期： 2019/10/19.
 * 让代码更加美观
 */
public class PullToRefreshAdapter extends BaseQuickAdapter<SelectVideo.BeanBean, PullToRefreshAdapter.MovieViewHolder> implements ContractRecommentFragment.View {

    private final PresenterRecommentFragment presenterRecommentFragment;
    MyLazyFragment activity;

    public PullToRefreshAdapter(@Nullable List<SelectVideo.BeanBean> data, MyLazyFragment activity) {
        super(R.layout.item_recy_recommend, data);
        this.activity = activity;
        presenterRecommentFragment = new PresenterRecommentFragment(this);
    }
    ViewDataBinding binding;
    @Override
    protected void convert(MovieViewHolder helper, SelectVideo.BeanBean item) {
        if (item != null) {

            binding = helper.getBinding();
            binding.setVariable(BR.presenter, presenterRecommentFragment);
            binding.setVariable(BR.recommendVideo, item);
            VideoView videoView = helper.getView(R.id.player);
            StandardVideoController controller = new StandardVideoController(mContext);
            videoView.setVideoController(controller);
            videoView.setUrl(item.getWordWritings().getSource());
            videoView.setLooping(true);


        }
    }
    ViewGroup parent;
    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        this.parent=parent;
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    @Override
    public MyLazyFragment getActivity() {
        return activity;
    }

    @Override
    public void requestSuccess(boolean isSuccess) {

    }

    @Override
    public void reflushView(SelectVideo.BeanBean selectVideo) {
        binding.setVariable(BR.recommendVideo, selectVideo);
        binding.notifyPropertyChanged(BR.recommendVideo);
//        notifyDataSetChanged();
    }



    @Override
    public ViewGroup getviewGroup() {
        return parent;
    }


    @Override
    public FragmentActivity setActivity() {
        return activity.getActivity();
    }


    public static class MovieViewHolder extends BaseViewHolder {

        public MovieViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }

}
