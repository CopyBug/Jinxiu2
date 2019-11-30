package com.lhw.sion.bean;


/**
 * HomeFragment的bean
 */
public class HomeBean {
    private String Home_imageUrl; //头像 √
    private int Home_planCount;//学习计划 √
    private int Home_learnedCount;//已经学习的单词 √
    private int Home_dictionaryCount;//单词总数 √
    private int Home_lastDay;//剩余多少天√
    private int Home_needLearnCount;//今日需要学习的单词√
    private int Home_needReviewCount;//今日需要复习√


    public String getHome_imageUrl() {
        return Home_imageUrl;
    }

    public void setHome_imageUrl(String home_imageUrl) {
        Home_imageUrl = home_imageUrl;
    }

    public int getHome_planCount() {
        return Home_planCount;
    }

    public void setHome_planCount(int home_planCount) {
        Home_planCount = home_planCount;
    }

    public int getHome_learnedCount() {
        return Home_learnedCount;
    }

    public void setHome_learnedCount(int home_learnedCount) {
        Home_learnedCount = home_learnedCount;
    }

    public int getHome_dictionaryCount() {
        return Home_dictionaryCount;
    }

    public void setHome_dictionaryCount(int home_dictionaryCount) {
        Home_dictionaryCount = home_dictionaryCount;
    }

    public int getHome_lastDay() {
        return Home_lastDay;
    }

    public void setHome_lastDay(int home_lastDay) {
        Home_lastDay = home_lastDay;
    }

    public int getHome_needLearnCount() {
        return Home_needLearnCount;
    }

    public void setHome_needLearnCount(int home_needLearnCount) {
        Home_needLearnCount = home_needLearnCount;
    }

    public int getHome_needReviewCount() {
        return Home_needReviewCount;
    }

    public void setHome_needReviewCount(int home_needReviewCount) {
        Home_needReviewCount = home_needReviewCount;
    }


}
