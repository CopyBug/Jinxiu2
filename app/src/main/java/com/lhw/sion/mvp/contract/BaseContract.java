package com.lhw.sion.mvp.contract;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.hjq.base.BaseDialog;
import com.hjq.demo.R;
import com.lhw.sion.ui.dialog.ToastDialog;
import com.lhw.sion.ui.dialog.WaitDialog;
import com.lhw.sion.until.Until;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public class BaseContract {
    static public   Handler HANDLER=new Handler(Looper.myLooper());



    interface View {

        FragmentActivity setActivity();

        /**
         * 显示
         */
        default void showMLoading(){
            Until.showDialog(setActivity());
        }

        /**
         * 隐藏
         */
        default void hideMLoading(){
            Until.hideDialog();
        }
        default void toast(String msg){
            Toast.makeText(setActivity()!=null?setActivity():null,msg , Toast.LENGTH_SHORT).show();
        }
        default void ShowPromptDialog(Integer ID, ToastDialog.Type type){
            Until.ShowMsg(setActivity(),Until.GetRource(setActivity(),ID),type);


        }
        default void ShowPromptDialog(String ID,ToastDialog.Type type){
            Until.ShowMsg(setActivity(),ID,type);


        }
        default void Error(){
            new ToastDialog.Builder(setActivity())
                    .setType(ToastDialog.Type.ERROR)
                    .setMessage("错误")
                    .show();
        };

        default BaseDialog showWaitingLoading(String msg){
            final BaseDialog dialog = new WaitDialog.Builder(setActivity())
                    // 消息文本可以不用填写
                    .setMessage(msg)
                    .show();
            return dialog;
        }
        default void hideWaitinigLoading(BaseDialog baseDialog){
         if(baseDialog!=null){
             baseDialog.dismiss();
         }
        }
        default void successDialog(){
            new ToastDialog.Builder(setActivity())
                    .setType(ToastDialog.Type.FINISH)
                    .setMessage("完成")
                    .show();
        }

    }
    interface Model{
        default WindowLeangth getWindowLength(FragmentActivity activity){
            WindowLeangth windowLeangth=null;
            if(activity!=null){
                WindowManager windowManager = activity.getWindowManager();
                Display defaultDisplay = windowManager.getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                windowLeangth=new WindowLeangth(width,height);
            }

            return windowLeangth;
        }
    }
public static class WindowLeangth{
        private int width;
        private int height;

    public WindowLeangth(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
}
