package com.lhw.sion.until.BindingAdapter;

import androidx.databinding.BindingAdapter;

import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videoplayer.player.VideoView;

import sion.my.jinxiu.bean.SelectVideo;

/**
 * 作者： 梁浩文, 日期： 2019/10/13.
 * 让代码更加美观
 */
public class IjkPlayerBindingAdapter {
    @BindingAdapter("android:player")
    public  static void playerSeturl(VideoView player, SelectVideo.BeanBean url){
        if(player!=null){


        }
    }
}
