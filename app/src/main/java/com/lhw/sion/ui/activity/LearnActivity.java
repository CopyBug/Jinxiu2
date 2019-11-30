package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.demo.BR;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivityLearnBinding;
import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.bean.DatabingLearnAdapter;
import com.lhw.sion.common.BindingListining;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractLearn;
import com.lhw.sion.mvp.presenter.PresenterLearnImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class LearnActivity extends MyActivity implements BindingListining, ContractLearn.View, View.OnTouchListener {

    @BindView(R.id.learn_recy)
    RecyclerView learn_recy;
    @BindView(R.id.learn_scroll)
    NestedScrollView scrollView;

    ActivityLearnBinding binding;
    ContractLearn.Presenter presenter;
    List<DatabingLearnAdapter> map;
    List<DatabingLearnAdapter> learnAdapterList;
    DataBindingRecyclerAdapter<String> adapter;
    private int page = 0;
    private int mback = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_learn;
    }

    @Override
    protected void initView() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        learn_recy.setLayoutManager(manager);
        getContentView().setOnTouchListener(this);
    }

    @Override
    protected void initData() {
        learnAdapterList = new ArrayList<>();
        presenter = new PresenterLearnImp(this);
        presenter.initView();//初始化数据
        binding = (ActivityLearnBinding) super.viewDataBinding;
        //返回键
        binding.setActivity(this);
        //设置悬浮按钮子元素的数量
        adapter = new DataBindingRecyclerAdapter(learnAdapterList, R.layout.layout_learn_adapter, BR.bean);
        adapter.setBindingListining(this);
        binding.setMadapter(adapter);
        learn_recy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    //正在滚动
                    adapter.setScrolling(false);
                    adapter.notifyDataSetChanged();

                }else{
        //正在被外部拖拽,一般为用户正在用手指滚动 自动滚动开始
                    adapter.setScrolling(true);
                }
            }
        });
//
    }

    @Override
    public void click(int position) {
        Intent intent = new Intent(this, LearnStartActivity.class);
        intent.putExtra("NumberWord", page * (position + 1));
        startActivityForResult(intent, null);
    }


    @Override
    public FragmentActivity setActivity() {
        return this;
    }


    @Override
    public void setstars(List<DatabingLearnAdapter> map) {
        this.map = map;
        //加载第一页
        if (this.map != null) {
            page += 1;
            int starpage = (page - 1) * 10;
            int endpage = page * 10;
            if (endpage < map.size()) {
                learnAdapterList.clear();
                for (int i = starpage; i < endpage; i++) {
                    learnAdapterList.add(map.get(i));
                }
                adapter.notifyDataSetChanged();
            } else {
                //最后一页
            }
        }

    }


    @Override
    public void setlearnword(String wordCount) {
        binding.setCount(wordCount);
    }

    @Override
    public void loadnextpage() {
        if (map != null) {
            page += 1;
            int starpage = (page - 1) * 10;
            int endpage = page * 10;
            if (starpage >= 0 && endpage < map.size()) {
                learnAdapterList.clear();
                for (int i = starpage; i < endpage; i++) {
                    learnAdapterList.add(map.get(i));
                }
                switchBackground();
                recyclerviewanimation(true);
                adapter.notifyDataSetChanged();

            } else {
                //最后一页
                page -= 1;
            }
        }
    }

    @Override
    public void loadlastpage() {
        if (map != null) {
            page -= 1;
            int starpage = (page - 1) * 10;
            int endpage = page * 10;
            if (starpage >= 0 && endpage < map.size()) {
                learnAdapterList.clear();
                for (int i = starpage; i < endpage; i++) {
                    learnAdapterList.add(map.get(i));
                }
                switchBackground();
                recyclerviewanimation(false);
                adapter.notifyDataSetChanged();
            } else {
                //最后一页
                page += 1;
            }
        }
    }

    @Override
    public void switchBackground() {
        int[] backGround = {R.drawable.bg_learnstart_one, R.drawable.bg_learnstart_two, R.drawable.bg_learnstart_three};
        while (true) {
            int randomint = randomint(3);
            int bg = backGround[randomint];
            if (bg != mback) {
                mback = backGround[randomint];
                break;
            }
        }
        scrollView.setBackgroundResource(mback);
//        learn_recy.setBackgroundResource(mback);

    }

    public int randomint(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    @Override
    public void recyclerviewanimation(boolean isright) {
        int anim = 0;
        if (isright) {
            anim = R.anim.activity_right_in;
        } else {
            anim = R.anim.activity_left_in;
        }
        Animation animation = AnimationUtils.loadAnimation(this, anim);
        learn_recy.setAnimation(animation);
        animation.start();


    }

    @OnClick({R.id.learn_next, R.id.learn_last})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.learn_next:
                loadnextpage();

                break;
            case R.id.learn_last:
                loadlastpage();
                break;
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }
}
