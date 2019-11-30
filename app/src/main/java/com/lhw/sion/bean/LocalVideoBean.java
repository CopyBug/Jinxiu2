package com.lhw.sion.bean;

import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.Serializable;

import sion.my.jinxiu.bean.SelectVideo;

/**
 * Created by ypk on 2019/2/23 0023  10:33
 * <p>
 * Description:
 */
public class LocalVideoBean implements Serializable {
    @Override
    public String toString() {
        return "LocalVideoBean{" +
                "path='" + path + '\'' +
                ", duration=" + duration +
                ", size=" + size +
                ", thumbPath='" + thumbPath + '\'' +
                ", bitmap=" + bitmap +
                '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        LocalVideoBean videoBean= (LocalVideoBean) obj;

        return videoBean.getThumbPath().equals(thumbPath);
    }

    @Override
    public int hashCode() {
        return thumbPath.hashCode();
    }

    private String path;
    private long duration;
    private long size;
    private String thumbPath;
    private Bitmap bitmap;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
