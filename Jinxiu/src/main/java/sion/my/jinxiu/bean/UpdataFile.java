package sion.my.jinxiu.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class UpdataFile {

    /**
     * uid : 1570432799357
     * name : http://lhw-base.oss-cn-beijing.aliyuncs.com/images/2019/10/07/15704327992909531.png
     * statu : done
     * response : null
     * resultBean : {"rephone":null,"code":200,"bean":"上传成功","error":"Success"}
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
         * rephone : null
         * code : 200
         * bean : 上传成功
         * error : Success
         */

        private Object rephone;
        private int code;
        private String bean;
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

        public String getBean() {
            return bean;
        }

        public void setBean(String bean) {
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
