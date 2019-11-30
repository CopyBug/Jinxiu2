package sion.my.jinxiu.bean;

import java.io.Serializable;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class SelectUserBean implements Serializable {
    /**
     * rephone : 13018600506
     * code : 200
     * bean : {"rephone":null,"code":200,"bean":null,"id":2,"phone":"13018600506","username":"123132","password":"123456","wordcount":30,"position":"萨达","imgbackground":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg","imghead":"https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/icon_user.png","allwordcount":3200,"error":"Success"}
     * error : 登录成功
     */

    private String rephone;
    private int code;
    private BeanBean bean;
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

    public static class BeanBean implements Serializable {
        /**
         * rephone : null
         * code : 200
         * bean : null
         * id : 2
         * phone : 13018600506
         * username : 123132
         * password : 123456
         * wordcount : 30
         * position : 萨达
         * imgbackground : https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/backgroundimgag.jpg
         * imghead : https://lhw-base.oss-cn-beijing.aliyuncs.com/images/default/icon_user.png
         * allwordcount : 3200
         * error : Success
         */

        private Object rephone;
        private int code;
        private Object bean;
        private int id;
        private String phone;
        public String username;
        private String password;
        private int wordcount;
        private String position;
        private String imgbackground;
        private String imghead;
        private int allwordcount;
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

        public Object getBean() {
            return bean;
        }

        public void setBean(Object bean) {
            this.bean = bean;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getWordcount() {
            return wordcount;
        }

        public void setWordcount(int wordcount) {
            this.wordcount = wordcount;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getImgbackground() {
            return imgbackground;
        }

        public void setImgbackground(String imgbackground) {
            this.imgbackground = imgbackground;
        }

        public String getImghead() {
            return imghead;
        }

        public void setImghead(String imghead) {
            this.imghead = imghead;
        }

        public int getAllwordcount() {
            return allwordcount;
        }

        public void setAllwordcount(int allwordcount) {
            this.allwordcount = allwordcount;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
