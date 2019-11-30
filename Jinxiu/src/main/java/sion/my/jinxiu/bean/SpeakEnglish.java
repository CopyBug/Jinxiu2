package sion.my.jinxiu.bean;

import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/9.
 * 让代码更加美观
 */
public class SpeakEnglish {
    /**
     * rephone : null
     * code : 200
     * bean : {"err_msg":"success.","sn":"307041175691570610778","corpus_no":"6745721927574123946","err_no":0,"result":["I don't think so"]}
     * error : Success
     */

    private Object rephone;
    private int code;
    private BeanBean bean;
    private String error;

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

    public BeanBean getBean() {
        return bean;
    }

    public void setBean(BeanBean bean) {
        this.bean = bean;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static class BeanBean {
        /**
         * err_msg : success.
         * sn : 307041175691570610778
         * corpus_no : 6745721927574123946
         * err_no : 0
         * result : ["I don't think so"]
         */

        private String err_msg;
        private String sn;
        private String corpus_no;
        private int err_no;
        private List<String> result;

        public String getErr_msg() {
            return err_msg;
        }

        public void setErr_msg(String err_msg) {
            this.err_msg = err_msg;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getCorpus_no() {
            return corpus_no;
        }

        public void setCorpus_no(String corpus_no) {
            this.corpus_no = corpus_no;
        }

        public int getErr_no() {
            return err_no;
        }

        public void setErr_no(int err_no) {
            this.err_no = err_no;
        }

        public List<String> getResult() {
            return result;
        }

        public void setResult(List<String> result) {
            this.result = result;
        }
    }
}
