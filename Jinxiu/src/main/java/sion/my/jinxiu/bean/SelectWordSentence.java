package sion.my.jinxiu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/5.
 * 让代码更加美观
 */
public class SelectWordSentence implements Serializable {
    /**
     * rephone : null
     * code : 200
     * bean : [{"id":1,"word":"admire","network_cn":"戴维发誓要离开这个项目，我不得不对他表示钦佩。","network_en":"I had to admire David's vow that he would leave the programme.","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//3/9/7/397f2e9f6d0a713d425d21da88815795.mp3"},{"id":2,"word":"admire","network_cn":"我们敬佩她对人类事业的献身精神。","network_en":"We admire her dedication to the cause of humanity.","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//5/2/4/524308853e898bf3440238c2ccf2f4d7.mp3"},{"id":3,"word":"admire","network_cn":"我们特意驻足欣赏风景。","network_en":"We took time to stop and admire the view.","tts_mp3":"http://res-tts.iciba.com/tts_new_dj//7/b/7/7b7fcafc6aa7c66e94588c0b62ea6c46.mp3"}]
     * error : Success
     */

    private Object rephone;
    private int code;
    private String error;
    private List<BeanBean> bean;

    public Object getRephone() {
        return rephone;
    }

    public void setRephone(Object rephone) {
        this.rephone = rephone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<BeanBean> getBean() {
        return bean;
    }

    public void setBean(List<BeanBean> bean) {
        this.bean = bean;
    }

    public static class BeanBean implements Serializable {
        /**
         * id : 1
         * word : admire
         * network_cn : 戴维发誓要离开这个项目，我不得不对他表示钦佩。
         * network_en : I had to admire David's vow that he would leave the programme.
         * tts_mp3 : http://res-tts.iciba.com/tts_new_dj//3/9/7/397f2e9f6d0a713d425d21da88815795.mp3
         */

        private int id;
        private String word;
        private String network_cn;
        private String network_en;
        private String tts_mp3;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getNetwork_cn() {
            return network_cn;
        }

        public void setNetwork_cn(String network_cn) {
            this.network_cn = network_cn;
        }

        public String getNetwork_en() {
            return network_en;
        }

        public void setNetwork_en(String network_en) {
            this.network_en = network_en;
        }

        public String getTts_mp3() {
            return tts_mp3;
        }

        public void setTts_mp3(String tts_mp3) {
            this.tts_mp3 = tts_mp3;
        }
    }
}
