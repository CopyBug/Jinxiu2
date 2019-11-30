package com.lhw.sion.mvp.contract;

import sion.my.jinxiu.bean.AddReply;
import sion.my.jinxiu.bean.ReplyInsertBean;
import sion.my.jinxiu.bean.SendWordComment;

import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/15.
 * 让代码更加美观
 */
public interface ContractSubmitDialog {
    interface View{

    }
    interface model{
        void SendWordComment(SendWordComment comment, Jinxiu2Listining<String> addCommentJinxiu2Listining);
        void SendReply(ReplyInsertBean bean, Jinxiu2Listining<AddReply> listining);
    }
    interface presenter{
        void SendComment(SelectVideo.BeanBean bean,String context,String lifeSource);
        void updataComment(Integer title_id);
        void SendReply(ReplyInsertBean bean,Integer title_id);
    }

}
