package com.lhw.sion.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivitySearchBinding;
import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.bean.DataBingSearchAdapter;
import com.lhw.sion.common.BindingListining;
import com.lhw.sion.common.MyActivity;
import com.lhw.sion.mvp.contract.ContractSearch;
import com.lhw.sion.mvp.listning.SearchListining;
import com.lhw.sion.mvp.presenter.PresenterSearchimp;
import com.lhw.sion.ui.view.AudioView;
import com.lhw.sion.ui.view.SearchLayout;
import com.lhw.sion.until.recorderlib.RecordManager;
import com.lhw.sion.until.recorderlib.recorder.RecordHelper;
import com.lhw.sion.until.recorderlib.recorder.listener.RecordFftDataListener;
import com.lhw.sion.until.recorderlib.recorder.listener.RecordResultListener;
import com.lhw.sion.until.recorderlib.recorder.listener.RecordStateListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.JinsanTransationcn;

public class SearchActivity extends MyActivity implements ContractSearch.View,
        SearchListining,
        RecordFftDataListener,
        RecordResultListener,
        RecordStateListener,
        BindingListining {

    private static final String TAG = "ASDADSSADA";
    ContractSearch.Presenter presenter;
    ActivitySearchBinding binding;
    List<DataBingSearchAdapter> dataBingSearchAdapters = new ArrayList<>();
    DataBindingRecyclerAdapter dataBindingRecyclerAdapter;
    @BindView(R.id.search_recy)
    RecyclerView recyclerView;
    @BindView(R.id.search_top)
    SearchLayout searchLayout;
    @BindView(R.id.audioView)
    AudioView audioView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    public final RecordManager recordManager = RecordManager.getInstance();

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        audioView.setStyle(AudioView.ShowStyle.getStyle("STYLE_WAVE"), audioView.getDownStyle());

    }

    @Override
    protected void initData() {
        binding = (ActivitySearchBinding) super.viewDataBinding;
        //存入监听器
        searchLayout.setSearchListining(this);
        //逻辑层
        presenter = new PresenterSearchimp(this);
        //搜索适配器
        dataBindingRecyclerAdapter = new DataBindingRecyclerAdapter(dataBingSearchAdapters, R.layout.item_recy_search, BR.Msearchword);
        binding.setAdapter(dataBindingRecyclerAdapter);
        //流量大小的监听器
        recordManager.setRecordFftDataListener(this);
        //录音状态
        recordManager.setRecordStateListener(this);
        //录音结束
        recordManager.setRecordResultListener(this);
        //初始化录音
        presenter.initRecord();
        dataBindingRecyclerAdapter.setBindingListining(this);
    }


    @Override
    public FragmentActivity setActivity() {
        return this;
    }

    @Override
    public void inputText(String text) {
        searchLayout.setinputtext(text);
        presenter.findWordTransation(text);
    }

    @Override
    public void speakClick(boolean ispress) {
        presenter.startSpeak(ispress);
        presenter.stopSpeak(ispress);
    }


    @Override
    public void nulltext() {
        dataBingSearchAdapters.clear();
        dataBindingRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDatabingSearch(DataBingSearchAdapter search) {
        dataBingSearchAdapters.clear();
        dataBingSearchAdapters.add(search);
        dataBindingRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public RecordManager getRecordManager() {
        return recordManager;
    }

    @Override
    public void IdentificationText(String text) {
        searchLayout.setinputtext(text);
        presenter.findWordTransation(text);

    }

    @Override
    public void identificationFailure(String text) {

    }

    JinsanTransationcn jinsanTransationcn;

    @Override
    public void cn_activity(JinsanTransationcn jinsanTransationcn) {
        this.jinsanTransationcn = jinsanTransationcn;
    }

    JinsanTransation jinsanTransation;

    @Override
    public void en_activity(JinsanTransation jinsanTransationcn) {
        this.jinsanTransation = jinsanTransationcn;
    }

    @Override
    public void onFftData(byte[] data) {
        //声音的大小传输数据
        Log.i(TAG, data.length + "");
        audioView.setWaveData(data);
    }

    @Override
    public void onResult(File result) {
        presenter.recognitionSpeech(result);
    }

    @Override
    public void onStateChange(RecordHelper.RecordState state) {
        switch (state) {
            case PAUSE:
                Log.i(TAG, "暂停中");
                break;
            case IDLE:
                Log.i(TAG, "空闲中");
                break;
            case RECORDING:
                Log.i(TAG, "录音中");
                audioView.setVisibility(View.VISIBLE);
                break;
            case STOP:
                Log.i(TAG, "停止");
                break;
            case FINISH:
                Log.i(TAG, "录音结束");
                audioView.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void click(int position) {
        boolean cn_en_activity = presenter.cn_en_activity();
        if (cn_en_activity) {
            //中文
            if(jinsanTransationcn!=null){
                Intent intent=new Intent(this,CnSearchActivity.class);
                intent.putExtra("translation",jinsanTransationcn);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_right_in,R.anim.activity_left_out);
            }
        } else {
            //英文
            if(jinsanTransation!=null){
                Intent intent=new Intent(this,EnSearchActivity.class);
                intent.putExtra("translation",jinsanTransation);
               startActivityForResult(intent,null);
//                overridePendingTransition(R.anim.activity_right_in,R.anim.activity_left_out);
            }
        }
    }
}
