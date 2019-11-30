package com.lhw.sion.bean;

/**
 * 作者： 梁浩文, 日期： 2019/9/28.
 * 让代码更加美观
 */
public class DatabingLearnAdapter {
    private Integer star;
    private Integer number;
    private Integer maxcount;

    public Integer getMaxcount() {
        return maxcount;
    }

    public void setMaxcount(Integer maxcount) {
        this.maxcount = maxcount;
    }

    public DatabingLearnAdapter() {

    }

    public DatabingLearnAdapter(Integer star, Integer number, Integer maxcount) {
        this.star = star;
        this.number = number;
        this.maxcount = maxcount;
    }

    public DatabingLearnAdapter(Integer star, Integer number) {
        this.star = star;
        this.number = number;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
