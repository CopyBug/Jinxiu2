package com.lhw.sion.mvp.presenter;

import android.media.AudioFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;

import com.hjq.demo.BuildConfig;
import com.hjq.demo.R;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.lhw.sion.bean.DataBingSearchAdapter;
import com.lhw.sion.common.MyApplication;
import com.lhw.sion.mvp.contract.ContractSearch;
import com.lhw.sion.mvp.model.ModelSearchImp;
import com.lhw.sion.ui.activity.PhotoActivity;
import com.lhw.sion.ui.view.AudioView;
import com.lhw.sion.until.Until;
import com.lhw.sion.until.recorderlib.recorder.RecordConfig;

import java.io.File;
import java.util.List;
import java.util.Locale;

import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.JinsanTransationcn;
import sion.my.jinxiu.bean.SpeakEnglish;
import sion.my.jinxiu.listning.JinxiuListning;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class PresenterSearchimp implements ContractSearch.Presenter {
    Handler handler = new Handler(Looper.myLooper());
    ContractSearch.View view;
    ContractSearch.Model model;
    public boolean iscn_en=false;
    public PresenterSearchimp(ContractSearch.View view) {
        this.view = view;
        this.model = new ModelSearchImp();
    }

    @Override
    public void findWordTransation(String word) {
        int englishorChinese = Until.isEnglishorChinese(word);
        DataBingSearchAdapter searchAdapter = new DataBingSearchAdapter();
        StringBuffer pronunciation = new StringBuffer();
        StringBuffer translation = new StringBuffer();
        if (englishorChinese == Until.CHART_ONLY_CN) {
            this.model.findWord_cn(word, new JinxiuListning<JinsanTransationcn>() {
                @Override
                public void SuccessRequest(JinsanTransationcn jinsanTransationcn) {
                    List<JinsanTransationcn.BaesInfoBean.SymbolsBean> symbols = jinsanTransationcn.getBaesInfo().getSymbols();
                    if(symbols!=null){
                        if(symbols.size()>=1){
                            JinsanTransationcn.BaesInfoBean.SymbolsBean symbolsBean = symbols.get(0);
                            String word_symbol = symbolsBean.getWord_symbol();//读音
                           if(word_symbol!=null){
                               pronunciation.append("[读音]:").append(word_symbol);
                           }
                            List<JinsanTransationcn.BaesInfoBean.SymbolsBean.PartsBean> parts = symbolsBean.getParts();
                            if(parts!=null){
                                if(parts.size()>=1){
                                    List<String> means = parts.get(0).getMeans();
                                    if(means!=null){
                                        for (int i = 0; i < means.size(); i++) {
                                            String s = means.get(i);
                                            translation.append(s).append("\t");
                                        }
                                    }
                                }
                            }
                        }

                        searchAdapter.setWord(word);
                        searchAdapter.setBritishStandard(pronunciation.toString());
                        searchAdapter.setTransaction(translation.toString());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                view.setDatabingSearch(searchAdapter);
                                view.cn_activity(jinsanTransationcn);
                                iscn_en=true;
                            }
                        });
                    }
                }

                @Override
                public void FailRequest(Throwable throwable) {

                }

                @Override
                public void OtherError(String error) {

                }
            });
        } else if (englishorChinese == Until.CHART_ONLY_EN) {
            this.model.findWord_en(word, new JinxiuListning<JinsanTransation>() {
                @Override
                public void SuccessRequest(JinsanTransation jinsanTransation) {

                    List<JinsanTransation.BaesInfoBean.SymbolsBean> symbols = jinsanTransation.getBaesInfo().getSymbols();
                    if (symbols != null) {
                        if (symbols.size() >= 1) {
                            JinsanTransation.BaesInfoBean.SymbolsBean symbolsBean = symbols.get(0);
                            String ph_en = symbolsBean.getPh_en() + "";
                            String ph_am = symbolsBean.getPh_am() + "";
                            if (!ph_en.equals("")) {
                                pronunciation.append("[美]:").append(ph_en);
                            }
                            if (!ph_am.equals("")) {
                                pronunciation.append("[英]:").append(ph_am);
                            }
                            List<JinsanTransation.BaesInfoBean.SymbolsBean.PartsBean> parts = symbolsBean.getParts();
                            if (parts != null) {
                                if (parts.size() >= 1) {
                                    JinsanTransation.BaesInfoBean.SymbolsBean.PartsBean partsBean = parts.get(0);
                                    String part = partsBean.getPart();
                                    translation.append(part);
                                    List<String> means = partsBean.getMeans();
                                    for (int i = 0; i < means.size(); i++) {
                                        translation.append(means.get(i));
                                    }
                                }
                            }
                        }

                        searchAdapter.setWord(word);
                        searchAdapter.setBritishStandard(pronunciation.toString());
                        searchAdapter.setTransaction(translation.toString());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                view.setDatabingSearch(searchAdapter);
                                view.en_activity(jinsanTransation);
                                iscn_en=false;
                            }
                        });
                    }


                }

                @Override
                public void FailRequest(Throwable throwable) {

                }

                @Override
                public void OtherError(String error) {

                }
            });
        }

    }

    @Override
    public void startSpeak(boolean isstart) {
        if (isstart) {
            this.view.getRecordManager().start();
        }
    }

    @Override
    public void stopSpeak(boolean isstart) {
        if (!isstart) {
            this.view.getRecordManager().stop();
        }
    }

    @Override
    public void initRecord() {

        XXPermissions.with(this.view.setActivity())
                .permission(Permission.RECORD_AUDIO,Permission.Group.STORAGE[0],Permission.Group.STORAGE[1])
                .constantRequest()
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {

                    }
                });
//        //保存为WAV文件
        this.view.getRecordManager().changeFormat(RecordConfig.RecordFormat.WAV);
//        //保存为16Bit
        this.view.getRecordManager().changeRecordConfig(this.view.getRecordManager().getRecordConfig().setEncodingConfig(AudioFormat.ENCODING_PCM_16BIT));
        this.view.getRecordManager().init(MyApplication.getInstance(), BuildConfig.DEBUG);
        String recordDir = String.format(Locale.getDefault(), "%s/Record/",
                Environment.getExternalStorageDirectory().getAbsolutePath());
        this.view.getRecordManager().changeRecordDir(recordDir);

    }

    @Override
    public void recognitionSpeech(File file) {
            this.model.recognitionSpeech(file, new JinxiuListning<SpeakEnglish>() {
                @Override
                public void SuccessRequest(SpeakEnglish speakEnglish) {
                    if("success.".equals(speakEnglish.getBean().getErr_msg())){
                        List<String> result = speakEnglish.getBean().getResult();
                        if(result!=null){
                            view.IdentificationText(result.size()>=1?result.get(0):null);
                        }else{
                            view.identificationFailure("识别失败");
                        }

                    }

                }

                @Override
                public void FailRequest(Throwable throwable) {
                    view.identificationFailure(throwable.getMessage());

                }

                @Override
                public void OtherError(String error) {
                view.identificationFailure(error);

                }
            });
    }

    @Override
    public boolean cn_en_activity() {
        return  iscn_en;
    }

}
