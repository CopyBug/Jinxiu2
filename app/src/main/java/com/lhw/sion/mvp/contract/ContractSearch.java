package com.lhw.sion.mvp.contract;

import com.hjq.demo.databinding.ActivityLearnStartBinding;
import com.lhw.sion.bean.DataBingSearchAdapter;
import com.lhw.sion.until.recorderlib.RecordManager;

import java.io.File;

import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.JinsanTransationcn;
import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.SpeakEnglish;
import sion.my.jinxiu.bean.WordSpecificLearn;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public interface ContractSearch   {
    interface View extends BaseContract.View{
       void setDatabingSearch(DataBingSearchAdapter search);
        RecordManager getRecordManager();
        void IdentificationText(String text);
        void identificationFailure(String text);
        void cn_activity(JinsanTransationcn jinsanTransationcn);
        void en_activity(JinsanTransation jinsanTransationcn);

    }

    interface Model {

        void findWord_cn(String word, JinxiuListning<JinsanTransationcn> jinxiuListning);
        void findWord_en(String word, JinxiuListning<JinsanTransation> jinxiuListning);
        void saveWord(String phone, String word);
        void recognitionSpeech(File file, JinxiuListning<SpeakEnglish> speakEnglishJinxiuListning);

    }

    interface Presenter {
        void findWordTransation(String word);
        void startSpeak(boolean isstart);
        void stopSpeak(boolean isstart);
        void initRecord();
        void recognitionSpeech(File file);

        /**
         * @return true 中文 false 英文
         */
        boolean cn_en_activity();

    }
}
