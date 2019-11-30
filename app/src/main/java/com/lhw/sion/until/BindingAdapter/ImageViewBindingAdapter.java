package com.lhw.sion.until.BindingAdapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.until.Until;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Lionel on 2019/5/5.
 */

public class ImageViewBindingAdapter {
public static Handler handler=new Handler(Looper.myLooper());
    @BindingAdapter("android:src")
    public static void setSrc(ImageView img, int resId) {
        img.setImageResource(resId);
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView img, Bitmap bitmap) {
        img.setImageBitmap(bitmap);
    }

    @BindingAdapter("glide_drawable")
    public static void loadDrawable(ImageView img, int drawableResId) {
        Glide.with(img.getContext())
                .load(drawableResId)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .into(img);
    }

    @BindingAdapter({"glide_url"})
    public static void loadDrawable(ImageView img, String url) {
        Glide.with(img.getContext())
                .load(url)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .into(img);
    }
    @BindingAdapter({"back_view"})
    public static void backDrawable(ImageView img, MyActivity activity) {
        if(activity!=null){
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });

        }
    }


    @BindingAdapter({"android:play_music"})
    public static void playmusic(ImageView img,String musicurl) {
        if(img!=null){
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int startPlay = Until.StartPlay(img.getContext(), musicurl);
                    Until.Startanim(img,startPlay);
                }
            });
        }
    }
    @BindingAdapter({"android:glide_url_circle"})
    public static void loadDrawableCircle(CircleImageView img, String url) {
        Glide.with(img.getContext())
                .load(url)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .into(img);
    }
    @BindingAdapter({"android:fileBackGround"})
    public static void fileBackGround(AppCompatImageView imageView,String filePath){
        if(imageView!=null){
            Until.setGlideImage(imageView,Until.getFirstView(filePath));
        }
    }

}
