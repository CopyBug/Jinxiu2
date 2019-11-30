package sion.my.jinxiu.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/15.
 * 让代码更加美观
 */
public class SendWordComment {
    private String source;
    private String context;
    private String fromPhone;
    private String mPhone;

    public SendWordComment(String source, String context, String fromPhone, String mPhone) {
        this.source = source;
        this.context = context;
        this.fromPhone = fromPhone;
        this.mPhone = mPhone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
