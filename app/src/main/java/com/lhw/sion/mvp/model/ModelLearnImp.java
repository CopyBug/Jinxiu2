package com.lhw.sion.mvp.model;

import com.lhw.sion.bean.DatabingLearnAdapter;
import com.lhw.sion.mvp.contract.ContractLearn;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.JinxiuApi;
import sion.my.jinxiu.bean.Allwords;
import sion.my.jinxiu.bean.MaxNumber;
import sion.my.jinxiu.bean.SelectUserBean;
import sion.my.jinxiu.bean.SelectUserWord;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/28.
 * 让代码更加美观
 */
public class ModelLearnImp implements ContractLearn.Model {
public  Integer learnWord=0; //已经学习了的单词数量

    @Override
    public void SelectUserWord(String phone, JinxiuListning<  List<DatabingLearnAdapter>> jinxiuListning) {
        JinxiuImp.selectWordUserdata(phone, new JinxiuListning<SelectUserWord>() {
            @Override
            public void SuccessRequest(SelectUserWord selectUserWord) {
                List<DatabingLearnAdapter> adapterList=new ArrayList<>();
                //初始化maxCount个数据
                int maxCount = selectUserWord.getBean().getMaxCount();
                for (int i = 0; i <maxCount ; i++) {
                    DatabingLearnAdapter databingLearnAdapter = new DatabingLearnAdapter();
                    databingLearnAdapter.setNumber(i+1);
                    databingLearnAdapter.setStar(0);
                    adapterList.add(databingLearnAdapter);
                }
                List<SelectUserWord.BeanBean.WordsBean> bean = selectUserWord.getBean().getWords();
                Map<Integer,Integer> countstart=new TreeMap<>();
                //计算每关有多少个单词
                for (int i = 0; i < bean.size(); i++) {
                    int number = bean.get(i).getNumber();
                    learnWord+=1;
                    if(countstart.containsKey(number)){
                        countstart.put(number,countstart.get(number).intValue()+1);
                    }else {
                        countstart.put(number,1);
                    }
                }
                //计算星星
                Iterator<Map.Entry<Integer, Integer>> iterator = countstart.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Integer, Integer> next = iterator.next();
                    adapterList.set(next.getKey()-1,new DatabingLearnAdapter(countStart(next.getValue()),next.getKey(),selectUserWord.getBean().getMaxCount()));
                }
                jinxiuListning.SuccessRequest(adapterList);


            }

            @Override
            public void FailRequest(Throwable throwable) {
                jinxiuListning.FailRequest(throwable);
            }

            @Override
            public void OtherError(String error) {

            }
        });
    }

    @Override
    public String getWordCount() {
        return learnWord+"";
    }

    @Override
    public int countStart(int value) {
        //15  5 10   15
        if(value>=8){
            return 1;
        }else if(value>15){
            return 2;
        }else if(value==15){
            return 3;
        }
return 0;
    }
}
