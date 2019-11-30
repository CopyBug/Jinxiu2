package com.lhw.sion.mvp.presenter;

import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.hjq.demo.R;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.lhw.sion.bean.LocalVideoBean;
import com.lhw.sion.mvp.contract.ContractVideoActivityLocal;
import com.lhw.sion.ui.activity.PhotoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/17.
 * 让代码更加美观
 */
public class PresenterVideoActivityLocal implements ContractVideoActivityLocal.Presenter,Runnable {

    ContractVideoActivityLocal.View view;
    ContractVideoActivityLocal.Model model;
    public PresenterVideoActivityLocal(ContractVideoActivityLocal.View view) {
        this.view = view;

    }

    @Override
    public void getLocalVideo() {
        view.Loading();
      new Thread(PresenterVideoActivityLocal.this).start();

    }

    @Override
    public void getauthorize() {

        // 申请存储权限
        XXPermissions.with(view.setActivity())
                .permission(Permission.Group.STORAGE)
                .constantRequest()
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        Log.i("hasPermission", isAll+"");
                       if(isAll){
//                          new Thread(PresenterVideoActivityLocal.this).start();
                       }else{
                           Toast.makeText(view.setActivity(), "请打开可读授权的权限", Toast.LENGTH_SHORT).show();
                       }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        Toast.makeText(view.setActivity(), "授權失敗", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void run() {
        view.setActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.showMLoading();
            }
        });
        // 视频其他信息的查询条件
        String[] mediaColumns = {MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DATA, MediaStore.Video.Media.DURATION, MediaStore.Video.Media.SIZE, MediaStore.Video.Thumbnails.DATA};
        Cursor cursor =this.view.setActivity().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                mediaColumns, null, null, MediaStore.Video.VideoColumns.DATE_ADDED + " DESC");
        Log.i("cursor", "getLocalVideo: ");
        if(cursor==null){
            this.view.setvideoBeans(null);
            return;
        }
        if(cursor.moveToFirst()){
            do{
                //加载视频
                LocalVideoBean info = new LocalVideoBean();
                info.setPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)));
                info.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)));
                info.setSize(cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE)));
                info.setThumbPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Thumbnails.DATA)));

                view.setActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        view.setvideoBeans(info);
                    }
                });
            }while (cursor.moveToNext());
        }
        cursor.close();
        view.setActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.hideLoading();
            }
        });

    }
}
