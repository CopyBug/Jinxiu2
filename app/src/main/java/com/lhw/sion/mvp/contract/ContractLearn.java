package com.lhw.sion.mvp.contract;

import com.lhw.sion.bean.DataBindingRecyclerAdapter;
import com.lhw.sion.bean.DatabingBeanUserInformation;
import com.lhw.sion.bean.DatabingLearnAdapter;

import java.util.List;
import java.util.Map;

import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectUserWord;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/28.
 * 让代码更加美观
 */
public interface ContractLearn {
    interface View extends BaseContract.View{
        void setstars(List<DatabingLearnAdapter> map);
        void setlearnword(String wordCount);
        void loadnextpage();
        void loadlastpage();
        void switchBackground();
        void recyclerviewanimation(boolean isright);
    }
    interface Presenter{
       void initView();

    }
    interface  Model extends BaseContract.Model{
        void SelectUserWord(String phone, JinxiuListning<List<DatabingLearnAdapter>> jinxiuListning);
        String getWordCount();
        int countStart(int value);
    }
}
