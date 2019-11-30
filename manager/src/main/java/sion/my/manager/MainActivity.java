package sion.my.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import sion.my.jinxiu.Api.JinxiuImp;
import sion.my.jinxiu.bean.Allwords;
import sion.my.jinxiu.bean.JinsanTransation;
import sion.my.jinxiu.bean.WordSentence;
import sion.my.jinxiu.listning.JinxiuListning;

public class MainActivity extends AppCompatActivity {
String TAG="JJJinxiu";
private Thread thread;
boolean isfinish=false;
    private List<String> bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                selectAllWords();
            }}).start();



    }
    public  void setA(){
        if(bean!=null){

                 for (int i = 0; i < bean.size(); i++) {
                     selectJinsan(bean.get(i));
                     try {
                         Thread.sleep(500);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     Log.i(TAG, "setA: ");
                 }
             }

        }

    public void selectJinsan(final String word){

        JinxiuImp.selectJinsanTransation(word, new JinxiuListning<JinsanTransation>() {
            @Override
            public void SuccessRequest(JinsanTransation jinsanTransation) {
                List<JinsanTransation.SentenceBean> sentence = jinsanTransation.getSentence();
                if(sentence!=null){
                    for (int i = 0; i < sentence.size(); i++) {
                        JinsanTransation.SentenceBean sentenceBean = sentence.get(i);
                        if(sentenceBean!=null){
                            WordSentence wordSentence=new WordSentence();
                            wordSentence.setWord(word);
                            wordSentence.setNetwork_cn(sentenceBean.getNetwork_cn());
                            wordSentence.setNetwork_en(sentenceBean.getNetwork_en());
                            wordSentence.setTts_mp3(sentenceBean.getTts_mp3());
                            insertsentence(wordSentence);
                        }
                    }
                }




            }

            @Override
            public void FailRequest(Throwable throwable) {
                Log.i("Jinxiu", throwable.getMessage());
            }

            @Override
            public void OtherError(String error) {

            }
        });
    }
    public void selectAllWords(){
        JinxiuImp.selelctAllword(new JinxiuListning<Allwords>() {
            @Override
            public void SuccessRequest(Allwords allwords) {
                bean = allwords.getBean();
                setA();


            }

            @Override
            public void FailRequest(Throwable throwable) {

            }

            @Override
            public void OtherError(String error) {

            }
        });
    }
    public  void insertsentence(WordSentence wordSentence){
        if(wordSentence!=null){

            JinxiuImp.insertSentece(wordSentence);
    }}
}
