package com.lhw.sion.ui.adapter;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjq.demo.R;
import com.hjq.widget.view.ScaleImageView;
import com.lhw.sion.bean.LocalVideoBean;
import com.lhw.sion.until.TimeUtils;

import java.io.File;
import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/17.
 * 让代码更加美观
 */
public class LocalVideoAdapter  extends BaseQuickAdapter<LocalVideoBean, BaseViewHolder> {
    public LocalVideoAdapter(@Nullable List<LocalVideoBean> data) {
        super(R.layout.item_video,data);
    }

    @Override
    public boolean setOnItemLongClick(View v, int position) {
        return super.setOnItemLongClick(v, position);
    }

    @Override
    protected void convert(BaseViewHolder helper, LocalVideoBean item) {
        ScaleImageView scaleImageView=helper.getView(R.id.iv_video_image);

        RequestOptions options = new RequestOptions();
        options.error(R.drawable.default_image)
                .placeholder(R.drawable.default_image)
                .override(130, 130);
        Glide.with(mContext).load(Uri.fromFile(new File(item.getThumbPath()))).apply(options).into(scaleImageView);
        helper.setText(R.id.iv_video_text, TimeUtils.convertSecondsToTime(item.getDuration() / 1000));
        //点击查看视频
    }
}
