package com.lhw.sion.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hjq.demo.BR;
import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivityEnSearchBinding;
import com.hjq.demo.databinding.ActivitySearchBinding;
import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.bean.DatabingHotelentityAdapter;
import com.lhw.sion.common.MyActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectWordSentence;

public class EnSearchActivity extends MyActivity {

    JinsanTransation jinsanTransation;
    ActivityEnSearchBinding binding;
    List<SelectWordSentence.BeanBean> en_search_sentence_beanBeanList=new ArrayList<>();
    List<DatabingHotelentityAdapter> en_search_parts_beanBeanList=new ArrayList<>();
    @BindView(R.id.en_search_sentence)
    RecyclerView en_search_sentence;
    @BindView(R.id.en_search_parts)
    RecyclerView en_search_parts;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_en_search;
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager1=new LinearLayoutManager(this);
        LinearLayoutManager layoutManager2=new LinearLayoutManager(this);
        en_search_sentence.setLayoutManager(layoutManager1);
        en_search_parts.setLayoutManager(layoutManager2);
    }

    @Override
    protected void initData() {
        binding= (ActivityEnSearchBinding) super.viewDataBinding;
        jinsanTransation= (JinsanTransation) getIntent().getSerializableExtra("translation");
        if(jinsanTransation!=null){
        //绑定头部
        binding.setWORD(jinsanTransation);
          try {
              binding.setPnEn(jinsanTransation.getBaesInfo().getSymbols().get(0).getPh_en());
              binding.setPnEnMp(jinsanTransation.getBaesInfo().getSymbols().get(0).getPh_en_mp3());
          }catch (Exception e){

          }
        //初始化Sentence数据
        initSentenceData(jinsanTransation.getBaesInfo().getWord_name(),jinsanTransation.getSentence());
        //初始化tense数据
        initTenseData(jinsanTransation.getBaesInfo().getSymbols());
        //Sentence适配器
        DataBindingRecyclerAdapter en_search_sentence_adapter=new DataBindingRecyclerAdapter(en_search_sentence_beanBeanList,R.layout.layout_learninfo_adapter, com.hjq.demo.BR.infoword);
        //初始化适配器
        binding.setEnSearchSententAdapter(en_search_sentence_adapter);
        //Hotelentity适配器
        DataBindingRecyclerAdapter en_search_parts_adapter=new DataBindingRecyclerAdapter(en_search_parts_beanBeanList,R.layout.item_recy_tense, BR.tense);
        binding.setEnSearchTenseAdapter(en_search_parts_adapter);
        }
    }

    private void initTenseData(List<JinsanTransation.BaesInfoBean.SymbolsBean> symbols) {
        if(symbols!=null){
            if(symbols.size()>=1){
                List<JinsanTransation.BaesInfoBean.SymbolsBean.PartsBean> parts = symbols.get(0).getParts();
                if(parts!=null){
                    for (int i = 0; i < parts.size(); i++) {
                        DatabingHotelentityAdapter databingHotelentityAdapter=new DatabingHotelentityAdapter();
                        StringBuffer means=new StringBuffer();
                        JinsanTransation.BaesInfoBean.SymbolsBean.PartsBean partsBean = parts.get(i);
                        //意思
                        for (int j = 0; j < partsBean.getMeans().size(); j++) {
                            means.append(partsBean.getMeans().get(j)).append("\t");
                        }
                        databingHotelentityAdapter.setContext(means.toString());
                        //标题
                        databingHotelentityAdapter.setTitle(partsBean.getPart());
                        en_search_parts_beanBeanList.add(databingHotelentityAdapter);
                    }
                }
            }
        }
    }


    private void initSentenceData(String word,List<JinsanTransation.SentenceBeanXX> sentence) {
        if(sentence!=null){
            for (int i = 0; i < sentence.size(); i++) {
                JinsanTransation.SentenceBeanXX bean = sentence.get(i);
                SelectWordSentence.BeanBean selectSentence=new SelectWordSentence.BeanBean();
                selectSentence.setNetwork_cn(bean.getNetwork_cn());
                selectSentence.setNetwork_en(bean.getNetwork_en());
                selectSentence.setTts_mp3(bean.getTts_mp3());
                selectSentence.setWord(word);
                en_search_sentence_beanBeanList.add(selectSentence);
            }
        }

    }


}
