package com.lhw.sion.mvp.model;

import com.lhw.sion.mvp.contract.ContractRecommend;

import sion.my.jinxiu.Api.VideoImp;
import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class ModelRecommendImp implements ContractRecommend.Model {

    @Override
    public void loadNextLoad(String phone, String nowtime, Jinxiu2Listining<SelectVideo> jinxiu2Listining) {
        if(phone!=null&&nowtime!=null){
            VideoImp.selectVideo(phone,nowtime,jinxiu2Listining);
        }else{
            jinxiu2Listining.FailRequest("空指针异常");
        }
    }
}
