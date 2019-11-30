package com.lhw.sion.mvp.presenter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractSearch;
import com.lhw.sion.mvp.contract.ContractRecommentFragment;
import com.lhw.sion.mvp.model.ModelSearchImp;
import com.lhw.sion.ui.dialog.CommentDialog;
import com.lhw.sion.ui.dialog.ShareDialog;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.List;

import sion.my.jinxiu.Api.VideoImp;
import sion.my.jinxiu.bean.AddReply;
import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.WordStars;
import sion.my.jinxiu.listning.Jinxiu2Listining;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/16.
 * 让代码更加美观
 */
public class PresenterRecommentFragment implements ContractRecommentFragment.Presenter {
    ContractSearch.Model model;
    ContractRecommentFragment.View view;

    public PresenterRecommentFragment(ContractRecommentFragment.View view) {
        this.view = view;
        this.model= new ModelSearchImp();
    }

    @Override
    public void SearchWord(View mview,String word) {
        this.model.findWord_en(word, new JinxiuListning<JinsanTransation>() {
            @Override
            public void SuccessRequest(JinsanTransation jinsanTransation) {
                if(jinsanTransation!=null){
                    view.JumpSearchActivity(jinsanTransation);
                }else{
                    view.Error();
                }
            }

            @Override
            public void FailRequest(Throwable throwable) {
                view.Error();
            }

            @Override
            public void OtherError(String error) {
                view.Error();
            }
        });
    }

    @Override
    public void reflushView(int title_id) {
        VideoImp.updataVideo(title_id, new Jinxiu2Listining<SelectVideo>() {
            @Override
            public void SuccessRequest(SelectVideo selectVideo) {
                List<SelectVideo.BeanBean> bean = selectVideo.getBean();
                if(bean!=null){
                    if(bean.size()==1){
                        view.reflushView(selectVideo.getBean().get(0));
                    }else{
                        view.Error();
                    }
                }else{
                    view.Error();
                }

            }

            @Override
            public void FailRequest(String throwable) {
            view.toast(throwable);
            }
        });
    }

    @Override
    public void AddStar(View mview, int title_id) {
        ShineButton shineButton= (ShineButton) mview;
        WordStars wordStars=new WordStars();
        wordStars.setIslike(shineButton.isChecked());
        wordStars.setPhone(UserInfo.Phone);
        wordStars.setTitle_id(title_id);

        VideoImp.insertStar(wordStars, new Jinxiu2Listining<AddReply>() {
            @Override
            public void SuccessRequest(AddReply addReply) {
                reflushView(title_id);
            }

            @Override
            public void FailRequest(String throwable) {
                view.toast(throwable);
            }
        });
    }

    @Override
    public void showEnjoy(View mView,SelectVideo.BeanBean beanBean) {
        new ShareDialog.Builder(view.setActivity()).setShareUrl(beanBean.getLifeSource()).show();
    }

    @Override
    public void ShowCommentMsg(View mView, SelectVideo.BeanBean beanBean) {
        CommentDialog.Builder builder = new CommentDialog.Builder(view.setActivity(), beanBean, view.getviewGroup());
        builder.show();
        builder.setCommentChangeListning(new CommentDialog.CommentChangeListning() {
            @Override
            public void CommentChange(boolean add_delete) {

            }
        });
    }


}
