package com.lhw.sion.mvp.model;

import com.lhw.sion.bean.DataBingSendVideo;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractSendVideo;

import java.io.File;

import sion.my.jinxiu.Api.VideoImp;
import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.SendVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/19.
 * 让代码更加美观
 */
public class ModelSendVideo implements ContractSendVideo.Model {
 
    @Override
    public void requestSendVideo(DataBingSendVideo dataBingSendVideo, Jinxiu2Listining<SendVideo> sendVideoJinxiu2Listining) {
        SelectVideo.BeanBean.WordWritingsBean wordWritingsBean=new SelectVideo.BeanBean.WordWritingsBean();
        wordWritingsBean.setPosition(dataBingSendVideo.getPosition());
        wordWritingsBean.setTitle(dataBingSendVideo.getTitle());
        wordWritingsBean.setSource(dataBingSendVideo.getVideoFile());
        wordWritingsBean.setContext(dataBingSendVideo.getComment());
        wordWritingsBean.setPhone(UserInfo.Phone);
        wordWritingsBean.setYb("");
        VideoImp.sendVideo(wordWritingsBean,new File(dataBingSendVideo.getVideoFile()),sendVideoJinxiu2Listining);
    }
}
