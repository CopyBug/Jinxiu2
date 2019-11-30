package com.lhw.sion.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.demo.R;
import com.hjq.image.ImageLoader;
import com.lhw.sion.bean.LocalVideoBean;
import com.lhw.sion.common.MyRecyclerViewAdapter;
import com.lhw.sion.until.TimeUtils;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import retrofit2.http.Url;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/07/24
 *    desc   : 图片选择适配器
 */
public final class VideoAdapter extends MyRecyclerViewAdapter<LocalVideoBean> {

    private final List<LocalVideoBean> mSelectPhoto;

    public VideoAdapter(Context context, List<LocalVideoBean> data) {
        super(context);
        mSelectPhoto = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    final class ViewHolder extends MyRecyclerViewAdapter.ViewHolder {

        @BindView(R.id.iv_video_image)
        ImageView mImageView;
        @BindView(R.id.iv_video_check)
        CheckBox mCheckBox;
        @BindView(R.id.iv_video_text)
        TextView mTextView;
        ViewHolder() {
            super(R.layout.item_video);
        }

        @Override
        public void onBindView(int position) {

            ImageLoader.with(getContext())
                    .load(new File(mSelectPhoto.get(position).getThumbPath()))
                    .into(mImageView);

            mTextView.setText( TimeUtils.convertSecondsToTime(mSelectPhoto.get(position).getDuration() / 1000));

        }
    }

    @Override
    protected RecyclerView.LayoutManager getDefaultLayoutManager(Context context) {
        return new GridLayoutManager(context, 3);
    }
}