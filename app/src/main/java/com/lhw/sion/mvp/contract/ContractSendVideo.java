package com.lhw.sion.mvp.contract;

import android.graphics.Bitmap;

import com.hjq.base.BaseDialog;
import com.hjq.demo.databinding.ActivitySendVideoFileBinding;
import com.lhw.sion.bean.DataBingSendVideo;
import com.lhw.sion.ui.dialog.WaitDialog;
import com.lhw.sion.ui.view.ExpandComment;

import java.io.File;

import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.bean.SendVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/18.
 * 让代码更加美观
 */
public interface ContractSendVideo {
    interface View extends BaseContract.View{
/*       void setImageView(Bitmap bitmap);*/
       void SuccessSend();
       ActivitySendVideoFileBinding getBinding();
       void setWord(String word);

    }
    interface Model{
       void requestSendVideo(DataBingSendVideo dataBingSendVideo,  Jinxiu2Listining<SendVideo> sendVideoJinxiu2Listining);
    }
    interface Presenter{
        File getFile();
        void SendVideo();

        void showDialog_Word();
    }
}
