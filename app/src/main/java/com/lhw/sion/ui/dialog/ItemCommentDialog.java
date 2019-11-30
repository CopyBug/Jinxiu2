package com.lhw.sion.ui.dialog;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.base.BaseRecyclerViewAdapter;
import com.lhw.sion.common.MyDialogFragment;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class ItemCommentDialog {
    public static final class Builder
            extends MyDialogFragment.Builder<Builder>
            implements BaseRecyclerViewAdapter.OnItemClickListener {

        public Builder(FragmentActivity activity) {
            super(activity);
     
        }

        @Override
        public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

        }
    }
}
