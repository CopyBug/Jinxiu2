package com.lhw.sion.ui.fragment;

import android.util.Log;
import android.view.View;

import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.VideoView;
import com.hjq.base.BaseLazyFragment;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ItemRecyRecommendBinding;
import com.lhw.sion.common.MyLazyFragment;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractRecommentFragment;
import com.lhw.sion.mvp.presenter.PresenterRecommentFragment;
import com.lhw.sion.ui.dialog.CommentDialog;
import com.lhw.sion.ui.dialog.ShareDialog;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.WordStars;

/**
 * 作者： 梁浩文, 日期： 2019/10/13.
 * 让代码更加美观
 */
public class VideoFragment/* extends MyLazyFragment implements ContractRecommentFragment.View*/ {
   /* @BindView(R.id.player)
    VideoView player;
    @BindView(R.id.item_love)
    ShineButton shineButton;
    ContractRecommentFragment.Presenter presenter;
    SelectVideo.BeanBean videoData;
    private ItemRecyRecommendBinding dataBing;
    private String source;
    public VideoFragment(SelectVideo.BeanBean videoData,String source) {
        this.videoData = videoData;
        this.source = source;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_recy_recommend;
    }


    @Override
    protected void initView() {

    }
    public static VideoFragment newInstance( SelectVideo.BeanBean videoData,String source) {
        return new VideoFragment(videoData,source);
    }

    @Override
    protected void initData() {
        dataBing = (ItemRecyRecommendBinding) getDataBing(ItemRecyRecommendBinding.class);
        presenter=new PresenterRecommentFragment(this);
        initPlayer();
        dataBing.setRecommendVideo(videoData);
     *//*   dataBing.setMsg(videoData.getWordComments().size()+"");
        dataBing.setLikes(videoData.getWordWritings().getStar());*//*
       initShineButton();

    }

    private void initShineButton() {
        List<SelectVideo.BeanBean.WordWritingsBean.WordStarsBean> stars = videoData.getWordWritings().getWordStars();
        for (int i = 0; i < stars.size(); i++) {
            if(stars.get(i).getPhone().equals(UserInfo.Phone)){
                shineButton.setChecked(true);
                break;
            }
        }
        WordStars wordStars=new WordStars();
        wordStars.setPhone(UserInfo.Phone);
        wordStars.setTitle_id(videoData.getWordWritings().getTitle_id());
        shineButton.setOnCheckStateChangeListener(new ShineButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View view, boolean checked) {
                wordStars.setTo_id("0");wordStars.setFrom_id("0"); wordStars.setIslike(checked);
                presenter.AddStar(wordStars);
//                Integer star = Integer.valueOf(dataBing.getLikes());
//                if(checked){
//                    star+=1;
//                }else{
//                    star=star-1;
//                }
//
//                dataBing.setLikes(star+"");
            }
        });

    }

    private void initPlayer() {
        Log.i("initPlayer", (videoData.getWordWritings().getSource()));
        player.setUrl(videoData.getWordWritings().getSource()); //设置视频地址
        StandardVideoController controller = new StandardVideoController(getContext());
        controller.setTitle(videoData.getWordWritings().getTitle()); //设置视频标题
        player.setVideoController(controller); //设置控制器，如需定制可继承BaseVideoController
        player.setLooping(true);
        player.release();
        player.start();

    }

    @OnClick({R.id.item_comment,R.id.item_share,R.id.searchWord})
public void onClick(View view){
        switch (view.getId()){
            case R.id.item_comment:
                CommentDialog.Builder builder = new CommentDialog.Builder(getActivity(), videoData, source, getContainer());
                //评论删除的监听器
                builder.setCommentChangeListning(new CommentDialog.CommentChangeListning() {
                    @Override
                    public void CommentChange(boolean add_delete) {
//                        int msg = Integer.valueOf(dataBing.getMsg()) ;
//                        if(add_delete){
//                            msg+=1;
//                        }else{
//                            msg-=1;
//                        }
//                        dataBing.setMsg(msg+"");
                    }
                });
                builder.show();

                break;
            case R.id.item_share:
                new ShareDialog.Builder(getActivity()).show();
                break;
            case R.id.searchWord:
                presenter.SearchWord(videoData.getWordWritings().getTitle());
                break;
        }
}
public void restartVideo(){
        if(player!=null){
            boolean playing = player.isPlaying();
            if(playing){

            }else{
                player.release();
                player.start();
            }


        }
}
    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public BaseLazyFragment getFragmentActivity() {
        return this;
    }

    @Override
    public String getStras() {
        return videoData!=null?videoData.getWordWritings().getStar():"0";
    }*/
}
