package sion.my.jinxiu.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/16.
 * 让代码更加美观
 */
public class AddReply {
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
