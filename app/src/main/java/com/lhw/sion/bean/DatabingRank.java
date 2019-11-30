package com.lhw.sion.bean;

/**
 * 作者： 梁浩文, 日期： 2019/10/10.
 * 让代码更加美观
 */
public class DatabingRank {
    private int numRank;
    private String imgUrl;
    private String username;
    private String likeCount;
    private boolean islike;

    public int getNumRank() {
        return numRank;
    }

    public void setNumRank(int numRank) {
        this.numRank = numRank;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isIslike() {
        return islike;
    }

    public void setIslike(boolean islike) {
        this.islike = islike;
    }
}
