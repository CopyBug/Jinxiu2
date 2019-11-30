package com.lhw.sion.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/7.
 * 让代码更加美观
 */
public class PostionBean {
    private String province;
    private String city;
    private  String town;

    @Override
    public String toString() {
        return province+city+town;
    }

    public PostionBean(String position) {
       try{
           String[] split = position.split("-");
           if(split.length>2){
               province=split[0];
               city=split[1];
               town=split[2];
           }
       }catch (Exception e){

       }
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
