package com.lhw.sion.bean;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class DatabingBeanRegisterUser {
    //手机号码
    private String phone;
    //验证码
    private String verificationCode;
    //密码
    private String passwordOne;
    //密码
    private String passwordTwo;

    public String getPhone() {
        return phone;
    }

    public DatabingBeanRegisterUser(String phone, String passwordOne) {
        this.phone = phone;
        this.passwordOne = passwordOne;
    }

    public DatabingBeanRegisterUser() {

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getPasswordOne() {
        return passwordOne;
    }

    public void setPasswordOne(String passwordOne) {
        this.passwordOne = passwordOne;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }
}
