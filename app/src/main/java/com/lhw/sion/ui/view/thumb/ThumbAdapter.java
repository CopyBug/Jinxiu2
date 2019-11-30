package com.lhw.sion.ui.view.thumb;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjq.demo.R;

import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/18.
 * 让代码更加美观
 */
public class ThumbAdapter extends BaseQuickAdapter<Bitmap, BaseViewHolder> {
    public ThumbAdapter(@Nullable List<Bitmap> data) {
        super(R.layout.item_thumb_image,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bitmap item) {
       ImageView imageView= helper.getView(R.id.images);
        RequestOptions options=new RequestOptions();
        options.error(R.drawable.default_image)
                .placeholder(R.drawable.default_image);

        Glide.with(mContext).load(item).apply(options).into(imageView);
    }
}
