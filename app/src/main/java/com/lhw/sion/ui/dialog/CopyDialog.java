package com.lhw.sion.ui.dialog;

import android.view.Gravity;

import androidx.fragment.app.FragmentActivity;

import com.hjq.base.BaseDialog;
import com.hjq.demo.R;
import com.lhw.sion.common.MyDialogFragment;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 可进行拷贝的副本
 */
public final class CopyDialog {

    public static final class Builder
            extends MyDialogFragment.Builder<Builder> {

        public Builder(FragmentActivity activity) {
            super(activity);

            setContentView(R.layout.dialog_copy);
            setAnimStyle(BaseDialog.AnimStyle.BOTTOM);
            setGravity(Gravity.BOTTOM);


        }
    }
}