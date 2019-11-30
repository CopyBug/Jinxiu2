package com.lhw.sion.bean;

import com.lhw.sion.common.UserInfo;

/**
 * 作者： 梁浩文, 日期： 2019/10/19.
 * 让代码更加美观
 */
public class DataBingSendVideo {
    private String comment="";
    private String title="";
    private String videoFile;
    private String position="";
    private String yb="";
    private String phone= UserInfo.Phone;

    @Override
    public String toString() {
        return "DataBingSendVideo{" +
                "comment='" + comment + '\'' +
                ", title='" + title + '\'' +
                ", videoFile='" + videoFile + '\'' +
                ", position='" + position + '\'' +
                ", yb='" + yb + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
