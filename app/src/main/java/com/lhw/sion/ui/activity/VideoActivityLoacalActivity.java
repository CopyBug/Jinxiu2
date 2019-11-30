package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.base.BaseDialog;
import com.hjq.base.BaseRecyclerViewAdapter;
import com.hjq.demo.R;
import com.lhw.sion.bean.LocalVideoBean;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractVideoActivityLocal;
import com.lhw.sion.mvp.presenter.PresenterVideoActivityLocal;
import com.lhw.sion.ui.adapter.VideoAdapter;
import com.lhw.sion.until.BuilderManager;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者： 梁浩文, 日期： 2019/10/17.
 * 让代码更加美观
 */
public class VideoActivityLoacalActivity extends MyActivity implements ContractVideoActivityLocal.View, BaseRecyclerViewAdapter.OnItemLongClickListener, BaseRecyclerViewAdapter.OnChildClickListener {
    ContractVideoActivityLocal.Presenter presenter;
    List<LocalVideoBean> localVideoList=new ArrayList<>();
    @BindView(R.id.rv_photo_list)
    RecyclerView recyclerView;
    @BindView(R.id.menu_more)
    BoomMenuButton menuButton;
    VideoAdapter localVideoAdapter;
    private BaseDialog dialog;
    private List<LocalVideoBean>  selectVideo=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_local_all;
    }

    @Override
    protected void initView() {
        assert menuButton != null;//取消默认
        menuButton.setButtonEnum(ButtonEnum.TextInsideCircle);
        menuButton.setPiecePlaceEnum(PiecePlaceEnum.DOT_3_1);
        menuButton.setButtonPlaceEnum(ButtonPlaceEnum.SC_3_2);
        for (int i=0; i < menuButton.getPiecePlaceEnum().pieceNumber(); i++) {
            addBuilder();
        }
        initAdapter();

    }


    @Override
    protected void initData() {
        presenter=new PresenterVideoActivityLocal(this);
        presenter.getLocalVideo();
    }


    private void initAdapter() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        localVideoAdapter=new VideoAdapter(getActivity(),localVideoList);
        localVideoAdapter.setOnItemLongClickListener(this);
        localVideoAdapter.setOnChildClickListener(R.id.iv_video_check,this);
        recyclerView.setAdapter(localVideoAdapter);


    }

//加载
    @Override
    public void Loading() {
        dialog = showWaitingLoading("视频加载中");


    }
//加载完成
    @Override
    public void hideLoading() {
        hideWaitinigLoading(dialog);
        localVideoAdapter.setData(localVideoList);
        recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_animation_from_right));
        recyclerView.scheduleLayoutAnimation();
    }

    @Override
    public void setvideoBeans(LocalVideoBean localVideoBean) {
            if(localVideoBean!=null){
                localVideoList.add(localVideoBean);
            }


    }

    @Override
    public FragmentActivity setActivity() {
        return this;
    }
    private void addBuilder() {
        menuButton.addBuilder(new TextInsideCircleButton.Builder()
                .normalImageRes(BuilderManager.getImageResource())
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        switch (index) {
                            case 0:
                                //发布
                                if(selectVideo.size()==1){
                                    Intent sendIntent=new Intent(getActivity(),SendVideoFileActivity.class);
                                    sendIntent.putExtra("fileUrl",selectVideo.get(0).getThumbPath());
                                    startActivityForResult(sendIntent,null);
                                }else{
                                    toast("请选择视频进行发布");
                                }

                                break;
                            case 1:
//录像
                            startActivity(VideoadmissionActivity.class);

                                break;
                            case 2:
//剪辑
                                if(selectVideo.size()==1){
                                    Intent intent=new Intent(getActivity(),ThumbVideoActivity.class);
                                    intent.putExtra("videoUrl",selectVideo.get(0));
                                    startActivityForResult(intent,null);
                                }else{
                                    toast("请选择视频进行剪辑");
                                }
                                break;

                        }
                    }
                }));
    }



    @Override
    public boolean onItemLongClick(RecyclerView recyclerView, View itemView, int position) {

return false;
    }

    @Override
    public void onChildClick(RecyclerView recyclerView, View childView, int position) {
        switch (childView.getId()){
            case R.id.iv_video_check:
                AppCompatCheckBox compatCheckBox= (AppCompatCheckBox) childView;
                if(compatCheckBox.isChecked()){
                    if (selectVideo.size() < 1) {
                        selectVideo.add(localVideoAdapter.getItem(position));
                    } else {
                        toast("只能發佈一個視頻");
                        compatCheckBox.setChecked(false);
                    }

                } else {
                    selectVideo.remove(localVideoAdapter.getItem(position));
                }

                break;
        }
    }
}
