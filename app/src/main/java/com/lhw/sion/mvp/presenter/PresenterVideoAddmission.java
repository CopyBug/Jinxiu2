package com.lhw.sion.mvp.presenter;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.widget.Toast;

import com.hjq.demo.R;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.lhw.sion.mvp.contract.ContractVideoAddmission;
import com.lhw.sion.ui.activity.PhotoActivity;

import java.util.List;

/**
 * 作者： 梁浩文, 日期： 2019/10/21.
 * 让代码更加美观
 */
public class PresenterVideoAddmission implements ContractVideoAddmission.Presenter {
    ContractVideoAddmission.View view;

    public PresenterVideoAddmission(ContractVideoAddmission.View view) {
        this.view = view;
    }

    @Override
    public boolean isSupportOpenGL() {
        ActivityManager activityManager= (ActivityManager) this.view.setActivity().getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo  = activityManager.getDeviceConfigurationInfo();//获取设备
        final boolean supportsEs2 =
                configurationInfo.reqGlEsVersion >= 0x20000
                        || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
                        && (Build.FINGERPRINT.startsWith("generic")
                        || Build.FINGERPRINT.startsWith("unknown")
                        || Build.MODEL.contains("google_sdk")
                        || Build.MODEL.contains("Emulator")
                        || Build.MODEL.contains("Android SDK built for x86")));

        return supportsEs2;
    }

    @Override
    public void setcompetence() {
        // 申请存储权限

    }
}
