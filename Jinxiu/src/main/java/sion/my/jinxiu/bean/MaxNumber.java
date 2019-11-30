package sion.my.jinxiu.bean;

/**
 * 作者： 梁浩文, 日期： 2019/9/28.
 * 让代码更加美观
 */
public class MaxNumber {

    /**
     * rephone : null
     * code : 200
     * bean : 189
     * error : Success
     */

    private Object rephone;
    private int code;
    private int bean;
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

    public int getBean() {
        return bean;
    }

    public void setBean(int bean) {
        this.bean = bean;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
