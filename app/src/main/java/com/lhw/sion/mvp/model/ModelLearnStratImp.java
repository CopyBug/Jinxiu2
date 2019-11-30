package com.lhw.sion.mvp.model;

import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractStratLearn;

import retrofit2.Response;
import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.InsertWordUserdata;
import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.WordSentence;
import sion.my.jinxiu.bean.WordSpecificLearn;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/29.
 * 让代码更加美观
 */
public class ModelLearnStratImp implements ContractStratLearn.Model {

    /**
     * @param Jphone 电话号码
     * @param NumberWord 关数
     * @param learnJinxiuListning 监听返回数据
     */
    @Override
    public void getAllWord(String Jphone, Integer NumberWord, JinxiuListning<WordSpecificLearn> learnJinxiuListning) {
        JinxiuImp.selectnumber_Learn(Jphone,NumberWord,learnJinxiuListning);
    }

    @Override
    public void getWordSentence(String word,JinxiuListning<SelectWordSentence> wordSentenceJinxiuListning) {
        JinxiuImp.SelectWordSentence(UserInfo.Phone, word,wordSentenceJinxiuListning);
    }

    @Override
    public void submitword(String word, String phone, String code,JinxiuListning<Boolean> listning) {
        JinxiuImp.InsertWordUserdata(UserInfo.Phone, word, code,listning);
    }

}
