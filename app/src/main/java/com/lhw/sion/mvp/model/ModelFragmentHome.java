package com.lhw.sion.mvp.model;

import com.lhw.sion.bean.DatabingBeanUserInformation;
import com.lhw.sion.bean.HomeBean;
import com.lhw.sion.mvp.contract.ContractFragmentHome;
import com.lhw.sion.mvp.contract.ContractLogin;
import com.lhw.sion.until.Until;

import java.util.List;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectUserWord;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/25.
 * 让代码更加美观
 */
public class ModelFragmentHome extends ModelLoginImp implements ContractFragmentHome.Model {
    @Override
    public boolean judgeInputFormat(DatabingBeanUserInformation basicUserInformation) {
        return super.judgeInputFormat(basicUserInformation);
    }

    @Override
    public void judgeLoginStatus(DatabingBeanUserInformation basicUserInformation, JinxiuListning<SelectUserBean> jinxiuListning) {
        super.judgeLoginStatus(basicUserInformation, jinxiuListning);
    }

    @Override
    public void getFragmentBean(DatabingBeanUserInformation basicUserInformation, JinxiuListning<HomeBean> beanJinxiuListning){
        judgeLoginStatus(basicUserInformation, new JinxiuListning<SelectUserBean>() {
            @Override
            public void SuccessRequest(SelectUserBean selectUserBean) {
                SelectUserBean.BeanBean beanUser = selectUserBean.getBean();
                JinxiuImp.selectWordUserdata(basicUserInformation.getPhone(), new JinxiuListning<SelectUserWord>() {
                    @Override
                    public void SuccessRequest(SelectUserWord selectUserWord) {
                        List<SelectUserWord.BeanBean.WordsBean> bean = selectUserWord.getBean().getWords();

                        int todayalearn=0;
                        int todaywantreview=0;
                        int wantlearn=0;
                        for (int i = 0; i < bean.size(); i++) {
                            int wordcode = bean.get(i).getWordcode();
                           if(wordcode==1){
                               wantlearn+=1;
                           }
                            String dayTime = Until.getDayTime();
                            String worddate = bean.get(i).getWorddate();
                            if(dayTime.equals(worddate)){
                                if(wordcode!=0){
                                    todayalearn+=1;
                                }
                                if(wordcode==1){
                                    todaywantreview+=1;
                                }
                            }
                        }
                        HomeBean homeBean=new HomeBean();
                        homeBean.setHome_imageUrl(beanUser.getImghead());
                        homeBean.setHome_planCount(beanUser.getWordcount());
                        homeBean.setHome_learnedCount(wantlearn);
                        homeBean.setHome_dictionaryCount(beanUser.getAllwordcount());
                        homeBean.setHome_lastDay((beanUser.getWordcount()-bean.size())/beanUser.getWordcount());
                        //今日需要学习的单词 计划-今日已经学习的单词
                        homeBean.setHome_needLearnCount(beanUser.getWordcount()-todayalearn);
                        //今日需要复习 计划-需要复习
                        homeBean.setHome_needReviewCount(todaywantreview);
                        beanJinxiuListning.SuccessRequest(homeBean);
                    }

                    @Override
                    public void FailRequest(Throwable throwable) {
                        beanJinxiuListning.FailRequest(throwable);
                    }

                    @Override
                    public void OtherError(String error) {
                        beanJinxiuListning.OtherError(error);
                    }
                });
            }

            @Override
            public void FailRequest(Throwable throwable) {
                beanJinxiuListning.FailRequest(throwable);
            }

            @Override
            public void OtherError(String error) {
                beanJinxiuListning.OtherError(error);
            }
        });
    }

    @Override
    public int findTodayCount(List<SelectUserWord.BeanBean.WordsBean> bean, int code) {
        int alllearncount=0;
        int learncount=0;

        for (SelectUserWord.BeanBean.WordsBean  bs:bean) {
            String worddate = bs.getWorddate();
            String dayTime = Until.getDayTime();
            if(dayTime.equals(worddate)){
                if(code==0){
                    alllearncount+=1;
                }else if(code==1){
                    learncount+=1;
                }
            }else{
                continue;
            }
        }
        return code==0?alllearncount:learncount;
    }
}
