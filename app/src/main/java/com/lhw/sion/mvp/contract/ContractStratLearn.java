package com.lhw.sion.mvp.contract;

import com.hjq.demo.databinding.ActivityLearnStartBinding;
import com.lhw.sion.ui.view.AskLayout;

import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.WordSentence;
import sion.my.jinxiu.bean.WordSpecificLearn;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/28.
 * 让代码更加美观
 */
public interface ContractStratLearn {
    interface View extends BaseContract.View {
        int getNumber();
        ActivityLearnStartBinding setbind();
        void showFinishDialog(Integer stars);
        void initview();
        void resetprocess(String process);
        void playvideo();
        int getaskData();
    }

    interface Model {
        /**
         * 获取关数的所有单词
         */
        void getAllWord(String Jphone, Integer NumberWord, JinxiuListning<WordSpecificLearn> learnJinxiuListning);
        void getWordSentence(String word,JinxiuListning<SelectWordSentence> wordSentenceJinxiuListning);
        void submitword(String word,String phone,String code,JinxiuListning<Boolean>  listning );
    }

    interface Presenter {


        /**
         * 初始的界面
         */
        void initview();


        void subumitLearnWord( String word,boolean issuccess);
        void showworddpagenext();
        void showwordpagelast();
        void jumLearnInfoActivity(  WordSpecificLearn.BeanBean.WordSpecificBean bean);
        void showfinishview();
    }
}
