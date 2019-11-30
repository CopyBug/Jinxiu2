package com.lhw.sion.mvp.presenter;

import android.util.Log;
import android.view.View;

import com.danikula.videocache.HttpProxyCacheServer;
import com.lhw.sion.common.MyApplication;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.BaseContract;
import com.lhw.sion.mvp.contract.ContractRecommend;
import com.lhw.sion.mvp.model.ModelRecommendImp;

import java.util.List;

import sion.my.jinxiu.bean.SelectVideo;
import sion.my.jinxiu.listning.Jinxiu2Listining;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public class PresenterRecommendImp implements ContractRecommend.Presenter {
    ContractRecommend.View view;
    ContractRecommend.Model model;
    private String nowtime;
    private boolean isFirst = true;


    public PresenterRecommendImp(ContractRecommend.View view) {
        this.view = view;
        model = new ModelRecommendImp();
        this.nowtime = System.currentTimeMillis() + "";
    }

    //先加載 然後發送消息给View数据已经好了  然后在后台继续加载 当用户滑到最下面的时候赋值  异步继续加载
    @Override
    public void loadNextLoad(boolean isreflush,boolean isReflush) {
        if (isreflush) {
            this.nowtime = System.currentTimeMillis() + "";
        }
        this.model.loadNextLoad(UserInfo.Phone, this.nowtime, new Jinxiu2Listining<SelectVideo>() {
            @Override
            public void SuccessRequest(SelectVideo selectVideo) {

                List<SelectVideo.BeanBean> bean = selectVideo.getBean();
                if (bean != null) {
                    if (bean.size() > 0) {


                        nowtime = bean.get(bean.size() - 1).getWordWritings().getCtime();
                        HttpProxyCacheServer proxy = MyApplication.getProxy(view.setActivity());
                        for (int i = 0; i < bean.size(); i++) {
                            SelectVideo.BeanBean beanBean = bean.get(i);
                            String source = beanBean.getWordWritings().getSource();
                            beanBean.setLifeSource(source);
                            beanBean.getWordWritings().setSource(proxy.getProxyUrl(source));
                            bean.set(i, beanBean);
                        }
                    if(isReflush){
                        view.relushVideo(bean);
                    }else{
                        view.setSelectVideo(bean);
                    }
                    } else {
                        //空数据
                        view.setSelectVideo(null);
                    }

                }
            }

            @Override
            public void FailRequest(String throwable) {
                Log.i("FailRequest", throwable);
                view.setSelectVideo(null);

            }
        });
    }


    @Override
    public void jumpVidePerson(View view, SelectVideo.BeanBean.WordWritingsBean writingsBean) {

    }


    @Override
    public BaseContract.WindowLeangth getWindow() {
        return model.getWindowLength(this.view.setActivity());
    }
}
