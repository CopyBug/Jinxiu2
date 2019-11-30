package com.lhw.sion.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/1.
 * 让代码更加美观
 */
public class DataBindingLearnInfoAdapter {
    private String clause;//英語句子
    private String transation;//翻译
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public DataBindingLearnInfoAdapter(String clause, String transation, String word) {
        this.clause = clause;
        this.transation = transation;
        this.word = word;
    }

    public String getClause() {
        return clause;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }

    public String getTransation() {
        return transation;
    }

    public void setTransation(String transation) {
        this.transation = transation;
    }
}
