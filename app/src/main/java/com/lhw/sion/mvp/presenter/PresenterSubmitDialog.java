package com.lhw.sion.mvp.presenter;

import sion.my.jinxiu.Api.VideoImp;
import sion.my.jinxiu.bean.AddReply;
import sion.my.jinxiu.bean.ReplyInsertBean;
import sion.my.jinxiu.bean.SendWordComment;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractSubmitDialog;
import com.lhw.sion.mvp.model.ModelSubmitDialog;

import java.io.UnsupportedEncodingException;
import java.util.List;

import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/15.
 * 让代码更加美观
 */
public class PresenterSubmitDialog implements ContractSubmitDialog.presenter {
    ContractSubmitDialog.model model;
   private PresenterSubmitDialog.View view;

    public PresenterSubmitDialog(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public PresenterSubmitDialog() {
        this.model = new ModelSubmitDialog();
    }

    @Override
    public void SendComment(SelectVideo.BeanBean bean,String context,String lifesource) {
        String source=lifesource; String fromPhone = bean.getWordWritings().getPhone();String mPhone= UserInfo.Phone;
        try {

        SendWordComment wordComment=new SendWordComment(source,context,fromPhone,mPhone);
        if("".equals(context)){
            if(view!=null){
                view.FailSend("请不要输入空内容");
            }
        }
         this.model.SendWordComment(wordComment, new Jinxiu2Listining<String>() {
             @Override
             public void SuccessRequest(String s) {
                 if(view!=null){
                     view.SuccessSend();
                 }
             }

             @Override
             public void FailRequest(String throwable) {
                 if(view!=null){
                     view.FailSend(throwable);
                 }
             }
         });
        } catch (Exception e) {
            e.printStackTrace();
            view.FailSend(e.getMessage());
        }

    }

    @Override
    public void updataComment(Integer title_id) {
        VideoImp.updataVideo(title_id, new Jinxiu2Listining<SelectVideo>() {
            @Override
            public void SuccessRequest(SelectVideo selectVideo) {
                List<SelectVideo.BeanBean> bean = selectVideo.getBean();
                if(bean!=null){
                    if(bean.size()==1){
                        List<SelectVideo.BeanBean.WordCommentsBean> wordComments = bean.get(0).getWordComments();
                        if(wordComments!=null){
                            view.LoadSuccess(wordComments);
                        }
                    }
                }
            }

            @Override
            public void FailRequest(String throwable) {

            }
        });
    }

    @Override
    public void SendReply(ReplyInsertBean bean,Integer title_id) {
        if(bean!=null){
            this.model.SendReply(bean, new Jinxiu2Listining<AddReply>() {
                @Override
                public void SuccessRequest(AddReply addReply) {
                    if(addReply.isBean()){
                        view.SuccessSend();

                    }
                }

                @Override
                public void FailRequest(String throwable) {
                view.FailSend(throwable);
                }
            });
        }
    }


    public interface View{
        void SuccessSend();
        void FailSend(String msg);
        void LoadSuccess( List<SelectVideo.BeanBean.WordCommentsBean> beans);
    }
}
