package com.lhw.sion.ui.dialog;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.hjq.base.BaseDialog;
import com.hjq.base.BaseRecyclerViewAdapter;
import com.hjq.demo.R;
import com.hjq.demo.databinding.DialogCommentBinding;
import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.bean.DataBindingRecyclerHolder;
import com.lhw.sion.common.MyDialogFragment;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.presenter.PresenterSubmitDialog;
import com.lhw.sion.ui.view.ExpandComment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sion.my.jinxiu.bean.ReplyInsertBean;
import sion.my.jinxiu.bean.SelectVideo;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class CommentDialog {
    public static final class Builder
            extends MyDialogFragment.Builder<Builder>
            implements BaseRecyclerViewAdapter.OnItemClickListener {
        private final Context mContext;
        @BindView(R.id.dialog_recy)
        RecyclerView recyclerView;
        @BindView(R.id.showInput)
        LinearLayout showInput;
        @BindView(R.id.dialog_close)
        TitleBar titleBar_close;
        FragmentActivity activity;
        String lifeSource;//在线资源文件
        SelectVideo.BeanBean beanBeans;//数据
        CommentChangeListning commentChangeListning;

        public void setCommentChangeListning(CommentChangeListning commentChangeListning) {
            this.commentChangeListning = commentChangeListning;
        }

        public void setCommentBinding(DialogCommentBinding commentBinding) {
            this.commentBinding = commentBinding;
        }

        DataBindingRecyclerAdapter bindingRecyclerAdapter;//适配器
        ViewGroup viewGroup;
        DialogCommentBinding commentBinding;
        private List<SelectVideo.BeanBean.WordCommentsBean> wordComments;
        private CommentDataBindingRecyclerAdapter recyclerAdapter;

        public Builder(FragmentActivity activity, SelectVideo.BeanBean beanBeans,  ViewGroup viewGroup) {
            super(activity);
            setContentView(R.layout.dialog_comment);
            commentBinding = DataBindingUtil.bind(getContentView());
            ButterKnife.bind(getContentView());
            this.beanBeans = beanBeans;
            this.lifeSource = beanBeans.getLifeSource();
            this.activity = activity;
            mContext = getContext();
            this.viewGroup = viewGroup;
            initView();
            initData();
        }

        private void initView() {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            recyclerView.setLayoutManager(linearLayoutManager);
            titleBar_close.setOnTitleBarListener(new OnTitleBarListener() {
                @Override
                public void onLeftClick(View v) {

                }

                @Override
                public void onTitleClick(View v) {

                }

                @Override
                public void onRightClick(View v) {
                        dismiss();
                }
            });
        try{
            titleBar_close.setTitle("评论"+beanBeans.getWordComments().size()+"条");
        }catch (Exception e){

        }
        }

        private void initData() {

            //创建适配器
            wordComments = beanBeans.getWordComments();
            recyclerAdapter = new CommentDataBindingRecyclerAdapter(wordComments, R.layout.dialog_comment_center_item, BR.comment);
            recyclerAdapter.setListning(new ReplyListning() {
                @Override
                public void SendRepld(ReplyInsertBean bean) {
                    ShowSendDialog(false, bean);
                }
            });
            commentBinding.setMAdapter(recyclerAdapter);
        }


        @Override
        public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

        }

        @Override
        public BaseDialog show() {
            return super.show();
        }

        PresenterSubmitDialog presenterSubmitDialog;

        @OnClick(R.id.showInput)
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.showInput:
                    ShowSendDialog(true, null);
                    break;
            }
        }



        public void ShowSendDialog(boolean isComment, ReplyInsertBean replyInsertBean) {
            if (presenterSubmitDialog == null) {
                presenterSubmitDialog = new PresenterSubmitDialog();
            }


            BaseDialog show = new BaseDialog.Builder<>(getContext()).setContentView(R.layout.dialog_submit_comment).show();
            View dialogView = show.getContentView();
            ImageView send = dialogView.findViewById(R.id.dialog_send);
            EditText sendMsg = dialogView.findViewById(R.id.dialog_context);
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String msg = sendMsg.getText() + "".trim();
                    System.out.println("onClick"+msg);
                    if (!msg.equals("")) {
                        if (isComment) {
                            presenterSubmitDialog.SendComment(beanBeans, msg, lifeSource);
                            commentChangeListning.CommentChange(true);
                        } else {
                            replyInsertBean.setComment_id(lifeSource);
                            replyInsertBean.setContent(msg);
                            presenterSubmitDialog.SendReply(replyInsertBean, beanBeans.getWordWritings().getTitle_id());
                        }
                    }
                }
            });
            presenterSubmitDialog.setView(new PresenterSubmitDialog.View() {
                @Override
                public void SuccessSend() {
                    Toast.makeText(mContext, "发送成功", Toast.LENGTH_SHORT).show();
                    titleBar_close.setTitle("评论"+beanBeans.getWordComments().size()+1+"条");
                    presenterSubmitDialog.updataComment(beanBeans.getWordWritings().getTitle_id());
                    show.dismiss();

                }

                @Override
                public void FailSend(String msg) {
                    Toast.makeText(mContext, "错误：" + msg, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void LoadSuccess(List<SelectVideo.BeanBean.WordCommentsBean> beans) {
                    Toast.makeText(mContext, "刷新成功", Toast.LENGTH_SHORT).show();
                    if (beans != null) {
                        wordComments.clear();
                        wordComments.addAll(beans);
                        recyclerAdapter.notifyDataSetChanged();
                    }
                }
            });
        }


//頭部回復適配器

        public class CommentDataBindingRecyclerAdapter extends RecyclerView.Adapter {
            protected boolean isScrolling = false;

            public void setScrolling(boolean scrolling) {
                isScrolling = scrolling;
            }

            public List<SelectVideo.BeanBean.WordCommentsBean> getDatalist() {
                return datalist;
            }

            private List<SelectVideo.BeanBean.WordCommentsBean> datalist;
            private int layoutId;
            private int variableId;
            private ExpandComment expandComment;
            private RecyclerView item_reply;
            private LinearLayout textView;
            View view;


            public CommentDataBindingRecyclerAdapter(List<SelectVideo.BeanBean.WordCommentsBean> datalist, int layoutId, int variableId) {
                this.datalist = datalist;
                this.layoutId = layoutId;
                this.variableId = variableId;
//        this.setHasStableIds(true);
            }


            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                view = null;
                if (layoutId != -1) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
//                    expandComment=view.findViewById(R.id.expand);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup.getContext());
                    item_reply = view.findViewById(R.id.item_reply);
                    item_reply.setLayoutManager(linearLayoutManager);
                    textView = view.findViewById(R.id.text_reply);

                }

                return new DataBindingRecyclerHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                if (variableId != -1) {

                    DataBindingRecyclerHolder viewHolder = (DataBindingRecyclerHolder) holder;
                    CommentDialog.Builder.ReplyDataBindingRecyclerAdapter recyclerAdapter = new CommentDialog.Builder.ReplyDataBindingRecyclerAdapter(datalist.get(position).getReplies(), R.layout.dialog_comment_center_item_item, BR.reply);
                    viewHolder.dataBinding.setVariable(variableId, datalist.get(position));
                    viewHolder.dataBinding.setVariable(BR.replyAdapter, recyclerAdapter);
                    viewHolder.dataBinding.setVariable(BR.writer, beanBeans.getWordWritings().getPhone());
                    viewHolder.dataBinding.notifyChange();
                    recyclerAdapter.setListning(new ReplyListning() {
                        @Override
                        public void SendRepld(ReplyInsertBean bean) {
                            if (listning != null) {
                                listning.SendRepld(bean);
                            }
                        }
                    });
                    //頂部
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (listning != null) {

                                SelectVideo.BeanBean.WordCommentsBean commentsBean = datalist.get(position);
                                ReplyInsertBean replyInsertBean = new ReplyInsertBean(UserInfo.Phone, "", "0", "", commentsBean.getFrom_uid());
                                listning.SendRepld(replyInsertBean);
                            }
                        }
                    });
//回復


                }

            }
            //当用户滑动一半的话加载第二页的数据


            @Override
            public int getItemCount() {
                return datalist != null ? datalist.size() : 0;
            }


            public ReplyListning listning;

            public void setListning(ReplyListning listning) {
                this.listning = listning;
            }


        }


        //item適配器
        public class ReplyDataBindingRecyclerAdapter extends RecyclerView.Adapter {

            protected boolean isScrolling = false;

            public void setScrolling(boolean scrolling) {
                isScrolling = scrolling;
            }

            public List<SelectVideo.BeanBean.WordCommentsBean.RepliesBean> getDatalist() {
                return datalist;
            }

            private ReplyListning listning;

            public void setListning(ReplyListning listning) {
                this.listning = listning;
            }

            private List<SelectVideo.BeanBean.WordCommentsBean.RepliesBean> datalist;
            private int layoutId;
            private int variableId;
            View view;


            public ReplyDataBindingRecyclerAdapter(List<SelectVideo.BeanBean.WordCommentsBean.RepliesBean> datalist, int layoutId, int variableId) {
                this.datalist = datalist;
                this.layoutId = layoutId;
                this.variableId = variableId;
//        this.setHasStableIds(true);
            }


            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                view = null;
                if (layoutId != -1) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
                }

                return new DataBindingRecyclerHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                if (variableId != -1) {
                    DataBindingRecyclerHolder viewHolder = (DataBindingRecyclerHolder) holder;

                    SelectVideo.BeanBean.WordCommentsBean.RepliesBean t = (SelectVideo.BeanBean.WordCommentsBean.RepliesBean) datalist.get(position);
                    viewHolder.dataBinding.setVariable(variableId, t);
                    viewHolder.dataBinding.setVariable(BR.writer, beanBeans.getWordWritings().getPhone());

                    viewHolder.dataBinding.notifyChange();
                    view.findViewById(R.id.item_item_text).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (listning != null) {
                                SelectVideo.BeanBean.WordCommentsBean.RepliesBean repliesBean = datalist.get(position);
                                Log.i("TASASA", repliesBean.getReply_id() + "");
                                ReplyInsertBean replyInsertBean = new ReplyInsertBean(UserInfo.Phone, "", repliesBean.getTo_uid(), "", repliesBean.getFrom_uid());
                                listning.SendRepld(replyInsertBean);
                            }
                        }
                    });


                }

            }
            //当用户滑动一半的话加载第二页的数据


            @Override
            public int getItemCount() {
                return datalist != null ? datalist.size() : 0;
            }


        }


    }


    public interface LoadDataListning {
        List<SelectVideo.BeanBean.WordCommentsBean> LoadData(String lifesource, String phone);
    }

    public interface CommentChangeListning{
        void CommentChange(boolean add_delete);
    }
    public interface ReplyListning {
        void SendRepld(ReplyInsertBean bean);
    }

}
