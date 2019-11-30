package com.lhw.sion.ui.activity;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.demo.BR;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivityLearnWordInfoBinding;
import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractLearnInfo;
import com.lhw.sion.mvp.presenter.PresenterLearnInfoimp;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.WordSpecificLearn;

/**
 * @author Sion
 */
public class LearnWordInfoActivity extends MyActivity implements ContractLearnInfo.View    {

    ActivityLearnWordInfoBinding binding;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    ContractLearnInfo.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_learn_word_info;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        binding = (ActivityLearnWordInfoBinding) super.viewDataBinding;
        //初始化数据
        presenter=new PresenterLearnInfoimp(this);
        SelectWordSentence intentWordSentence = getIntentWordSentence();
        List<SelectWordSentence.BeanBean> bean = intentWordSentence.getBean();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        DataBindingRecyclerAdapter<SelectWordSentence.BeanBean> adapter=new DataBindingRecyclerAdapter<SelectWordSentence.BeanBean>(bean,R.layout.layout_learninfo_adapter, BR.infoword);
        binding.setMadapter(adapter);
        binding.setMWord(getIntentWordSpecific());
    }


    @Override
    public WordSpecificLearn.BeanBean.WordSpecificBean getIntentWordSpecific() {
        return (WordSpecificLearn.BeanBean.WordSpecificBean)getIntent().getSerializableExtra("top");
    }

    @Override
    public SelectWordSentence getIntentWordSentence() {
        return (SelectWordSentence) getIntent().getSerializableExtra("botton");
    }

    @Override
    public FragmentActivity setActivity() {
        return this;
    }
    @OnClick(R.id.learninfo_black)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.learninfo_black:
                setResult(RESULT_OK);
                finish();
                break;
        }
    }


}


