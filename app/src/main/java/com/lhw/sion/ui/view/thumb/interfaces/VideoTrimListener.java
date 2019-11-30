package com.lhw.sion.ui.view.thumb.interfaces;

/**
 * Author：J.Chou
 * Date：  2016.08.01 2:23 PM
 * Email： who_know_me@163.com
 * Describe:
 */
public interface VideoTrimListener {
    void onStartTrim();
    void onFinishTrim(String url);
    void onCancel();
    void errorCut(String msg);
    void onLoad();
}
