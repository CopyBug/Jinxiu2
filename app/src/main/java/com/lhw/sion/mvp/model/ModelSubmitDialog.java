package com.lhw.sion.mvp.model;

import sion.my.jinxiu.Api.VideoImp;
import sion.my.jinxiu.bean.AddReply;
import sion.my.jinxiu.bean.ReplyInsertBean;
import sion.my.jinxiu.bean.SendWordComment;
import sion.my.jinxiu.listning.Jinxiu2Listining;

import com.lhw.sion.mvp.contract.ContractSubmitDialog;

/**
 * 作者： 梁浩文, 日期： 2019/10/15.
 * 让代码更加美观
 */
public class ModelSubmitDialog implements ContractSubmitDialog.model {
    @Override
    public void SendWordComment(SendWordComment comment, Jinxiu2Listining<String> addCommentJinxiu2Listining) {
        VideoImp.insertComment(comment,addCommentJinxiu2Listining);
    }

    @Override
    public void SendReply(ReplyInsertBean bean, Jinxiu2Listining<AddReply> listining) {
        VideoImp.insertReply(bean,listining);
    }
}
