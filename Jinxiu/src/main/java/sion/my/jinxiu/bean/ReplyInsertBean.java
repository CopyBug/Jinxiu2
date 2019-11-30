package sion.my.jinxiu.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/16.
 * 让代码更加美观
 */
public class ReplyInsertBean {
    private String phone;
    private String content;
    private String reply_id;
    private String comment_id;
    private String from_uid;

    public ReplyInsertBean() {

    }

    public ReplyInsertBean(String phone, String content, String reply_id, String comment_id, String from_uid) {
        this.phone = phone;
        this.content = content;
        this.reply_id = reply_id;
        this.comment_id = comment_id;
        this.from_uid = from_uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply_id() {
        return reply_id;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
    }
}
