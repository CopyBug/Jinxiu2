package com.lhw.sion.until.BindingAdapter;

import android.net.Uri;
import android.widget.VideoView;

import androidx.databinding.BindingAdapter;

import java.net.URI;

/**
 * 作者： 梁浩文, 日期： 2019/10/10.
 * 让代码更加美观
 */
public class VideoViewBindingAadapter {
    @BindingAdapter("android:videourl")
    public static void showvide(VideoView videoView,String url){
        if(videoView!=null){
            if(url!=null){
                videoView.setVideoURI(Uri.parse(url));

            }


        }
    }
}
