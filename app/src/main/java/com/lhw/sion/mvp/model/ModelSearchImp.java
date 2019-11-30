package com.lhw.sion.mvp.model;

import com.lhw.sion.mvp.contract.ContractSearch;
import com.lhw.sion.until.Until;

import java.io.File;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.JinsanTransationcn;
import sion.my.jinxiu.bean.SpeakEnglish;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class ModelSearchImp implements ContractSearch.Model {


    @Override
    public void findWord_cn(String word, JinxiuListning<JinsanTransationcn> jinxiuListning) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               JinxiuImp.selectJinsanTransation(word,true,jinxiuListning);
           }
       }).start();
    }

    @Override
    public void findWord_en(String word, JinxiuListning<JinsanTransation> jinxiuListning) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                JinxiuImp.selectJinsanTransation(word,false,jinxiuListning);
            }
        }).start();

    }

    @Override
    public void saveWord(String phone, String word) {

    }

    @Override
    public void recognitionSpeech(File file, JinxiuListning<SpeakEnglish> speakEnglishJinxiuListning) {
        if(file!=null){
            JinxiuImp.speechRecognitionInquire(file,speakEnglishJinxiuListning);
        }
    }


}
