package sion.my.jinxiu.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/19.
 * 让代码更加美观
 */
public class SendVideo {
    /**
     * uid : 1571470831872
     * name : http://lhw-base.oss-cn-beijing.aliyuncs.com/video/13018600506/2019/10/19/15714708227011245.mp4
     * statu : done
     * response : null
     * resultBean : {"rephone":"13018600506","code":200,"bean":true,"error":"Success"}
     */

    private String uid;
    private String name;
    private String statu;
    private Object response;
    private ResultBeanBean resultBean;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public ResultBeanBean getResultBean() {
        return resultBean;
    }

    public void setResultBean(ResultBeanBean resultBean) {
        this.resultBean = resultBean;
    }

    public static class ResultBeanBean {
        /**
         * rephone : 13018600506
         * code : 200
         * bean : true
         * error : Success
         */

        private String rephone;
        private int code;
        private boolean bean;
        private String error;

        public String getRephone() {
            return rephone;
        }

        public void setRephone(String rephone) {
            this.rephone = rephone;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public boolean isBean() {
            return bean;
        }

        public void setBean(boolean bean) {
            this.bean = bean;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
