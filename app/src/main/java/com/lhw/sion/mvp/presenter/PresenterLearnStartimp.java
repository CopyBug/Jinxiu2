package com.lhw.sion.mvp.presenter;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import androidx.fragment.app.FragmentActivity;

import com.hjq.demo.R;
import com.hjq.demo.databinding.ActivityLearnStartBinding;
import com.lhw.sion.common.UserInfo;
import com.lhw.sion.mvp.contract.ContractStratLearn;
import com.lhw.sion.mvp.model.ModelLearnStratImp;
import com.lhw.sion.ui.activity.LearnWordInfoActivity;
import com.lhw.sion.until.ResultCode;

import org.w3c.dom.Comment;

import java.util.List;

import sion.my.jinxiu.bean.SelectWordSentence;
import sion.my.jinxiu.bean.WordSpecificLearn;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/9/29.
 * 让代码更加美观
 */
public class PresenterLearnStartimp implements ContractStratLearn.Presenter {
    Handler handler = new Handler(Looper.myLooper());
    private final int SUCCESSCODE=1;
    private final int DEFALUT=0;
    private  int page = 0;
    private ContractStratLearn.View view;
    private ContractStratLearn.Model model;
    private List<WordSpecificLearn.BeanBean> bean;
    public PresenterLearnStartimp(ContractStratLearn.View view) {
        this.view = view;
        this.model = new ModelLearnStratImp();
    }


    @Override
    public void initview() {
        this.view.showMLoading();
        this.model.getAllWord(UserInfo.Phone, this.view.getNumber(), new JinxiuListning<WordSpecificLearn>() {
            @Override
            public void SuccessRequest(WordSpecificLearn wordSpecificLearn) {
                bean = wordSpecificLearn.getBean();//全部数据已经准备好了  →分发器
                showworddpagenext();
                view.hideMLoading();
            }

            @Override
            public void FailRequest(Throwable throwable) {

            }

            @Override
            public void OtherError(String error) {

            }
        });
    }

    @Override
    public void subumitLearnWord(String word, boolean issuccess) {
        int code=0;
        if(issuccess){
            code=SUCCESSCODE;
        }else {
            code=DEFALUT;
        }
        this.model.submitword(word, UserInfo.Phone, code+"", new JinxiuListning<Boolean>() {
            @Override
            public void SuccessRequest(Boolean aBoolean) {
                //请求成功
            }

            @Override
            public void FailRequest(Throwable throwable) {

            }

            @Override
            public void OtherError(String error) {

            }
        });
    }


    @Override
    public synchronized void showworddpagenext() {
        if (bean != null) {
            page += 1;
            if (page < bean.size()) {
                ActivityLearnStartBinding setbind = view.setbind();
                WordSpecificLearn.BeanBean beanBean = bean.get(page);
                setbind.setWord(beanBean);
                ChangeProcess();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view.playvideo();
                    }
                }, 400);


            } else {
//                this.view.showFinishDialog();
                page -= 1;
                showfinishview();
                return;
            }


        }
    }

    @Override
    public void showwordpagelast() {
        page -= 1;
        if (page >= 0) {
            ActivityLearnStartBinding setbind = view.setbind();
            WordSpecificLearn.BeanBean beanBean = bean.get(page);
            setbind.setWord(beanBean);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.playvideo();
                }
            }, 400);
        } else {
            this.view.toast("尽头了");
            page = 0;
        }
        ChangeProcess();
    }

    @Override
    public void jumLearnInfoActivity(WordSpecificLearn.BeanBean.WordSpecificBean bean) {
        String word = bean.getWord();
        this.model.getWordSentence(word, new JinxiuListning<SelectWordSentence>() {
            @Override
            public void SuccessRequest(SelectWordSentence wordSentence) {
                FragmentActivity fragmentActivity = view.setActivity();
                Intent intent = new Intent(fragmentActivity, LearnWordInfoActivity.class);
                intent.putExtra("top", bean);
                intent.putExtra("botton", wordSentence);
                fragmentActivity.startActivityForResult(intent, ResultCode.NextPage);
//                fragmentActivity.overridePendingTransition(R.anim.activity_botton,R.anim.activity_botton_out);
            }

            @Override
            public void FailRequest(Throwable throwable) {

            }

            @Override
            public void OtherError(String error) {

            }
        });
    }

    @Override
    public void showfinishview() {
        int value  = this.view.getaskData();
        int star=0;
            if(value>=5&&value<=10){
                star=1;
            }else if(value>10&&value<=15){
                star=2;
            }else if(value==16){
                star=3;
            }
        this.view.showFinishDialog(star);

    }

    public void ChangeProcess() {
        String process = page + "/" + (bean.size() );
        this.view.resetprocess(process);
    }
}
