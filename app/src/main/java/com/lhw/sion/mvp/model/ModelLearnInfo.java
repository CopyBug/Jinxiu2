package com.lhw.sion.mvp.model;

import com.lhw.sion.bean.DataBindingLearnInfoAdapter;
import com.lhw.sion.mvp.contract.ContractLearnInfo;
import com.lhw.sion.until.Until;

import java.util.ArrayList;
import java.util.List;

import sion.my.jinxiu.bean.WordSpecificLearn;

/**
 * 作者： 梁浩文, 日期： 2019/10/1.
 * 让代码更加美观
 */
//[S]界限,范围 an area or range of interest, activity
//Now we begin to draw a circle with compasses.现在我们开始用圆规画一个圆。
//I need a compass to draw a circle.我需要一支圆规画圆。
//A compass needle points to the north.罗盘的指针永远指向北方。
//The compass was invented by the Chinese, as is well known.众所周知,指南针是中国人发明的。
//Finance is not within the compass of our department.财政不在我们这个部门的管辖范围之内。
//Her action go beyond the compass of proper social behavior.她的举动越出了正当的社交行为的范围。
//In order to compass our object we must work hard.为了达到我们的目标，我们必须努力工作。
//He tried his best to compass his purpose.他尽力去实现他的目标。
//The sailboat compassed the island.帆船绕岛航行
//Suddenly we compassed the enemies on all sides.我们突然从四面八方将敌人包围了。
public class ModelLearnInfo implements ContractLearnInfo.Model {
    @Override
    public List<DataBindingLearnInfoAdapter> getDataBingBean(WordSpecificLearn.BeanBean.WordSpecificBean beanBean) {
        List<DataBindingLearnInfoAdapter> infoAdapterList = new ArrayList<>();
        if (beanBean != null) {
            String transaction = beanBean.getSentence();
            String[] split = transaction.split("\n");
            if (split != null) {
                if (split.length >= 1) {
                    for (int i = 0; i < (split.length - 1); i++) {
                        String All = new String(split[i]);//列句+翻译
                        if (All != null) {
                            for (int j = 0; j < All.length(); j++) {
                                boolean chinese = Until.isChinese(All.charAt(j));
                                if (chinese) {//中文开始分割
                                    if(j>=1){
                                        String[] split1 = All.split(All.substring(j -1, j));
                                        if (split1 != null) {
                                            if (split1.length == 2) {
                                                String menglish = split1[0];
                                                String mchinese = split1[1];
                                                DataBindingLearnInfoAdapter bindingLearnInfoAdapter = new DataBindingLearnInfoAdapter(menglish, mchinese, beanBean.getWord());
                                                infoAdapterList.add(bindingLearnInfoAdapter);
                                                break;
                                            }
                                        }
                                    }


                                }
                            }
                        }

                    }
                }
            }


        }
        return infoAdapterList;

    }
}
