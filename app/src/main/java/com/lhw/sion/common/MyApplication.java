package com.lhw.sion.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import com.danikula.videocache.HttpProxyCacheServer;
import com.dueeeke.videoplayer.exo.ExoMediaPlayerFactory;
import com.dueeeke.videoplayer.ijk.IjkPlayerFactory;
import com.dueeeke.videoplayer.player.AndroidMediaPlayerFactory;
import com.dueeeke.videoplayer.player.VideoViewConfig;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.hjq.demo.BuildConfig;
import com.hjq.image.ImageLoader;

import com.hjq.toast.ToastInterceptor;
import com.hjq.toast.ToastUtils;

import com.lhw.sion.other.EventBusManager;
import com.lhw.sion.ui.activity.HomeActivity;
import com.lhw.sion.ui.shareHelper.Skin;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;


import cat.ereza.customactivityoncrash.config.CaocConfig;
import iknow.android.utils.BaseUtils;
import nl.bravobit.ffmpeg.FFmpeg;
import sion.my.netmanger2.NetworkManager;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2018/10/18
 *    desc   : 项目中的 Application 基类
 */
@SuppressWarnings("all")
public final class MyApplication extends Application {
    private static MyApplication instance;
    private HttpProxyCacheServer proxy;
    public static Context applicationContext;


    public static HttpProxyCacheServer getProxy(Context context) {

        MyApplication app = (MyApplication) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;

    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        instance=this;
        initprovider();
        initSDK(this);
        BaseUtils.init(this);
        Skin.activity=getApplicationContext();
        registerBroad();
    initIjkPlayer();
        //
        initFFmpegBinary(this);
    }
    private void initFFmpegBinary(Context context) {
        if (!FFmpeg.getInstance(context).isSupported()) {
            Log.e("InitApplication","Android cup arch not supported!");
        }
    }
    private void initIjkPlayer() {
        VideoViewManager.setConfig(VideoViewConfig.newBuilder()
                //使用使用IjkPlayer解码
                .setPlayerFactory(IjkPlayerFactory.create())
//                //使用ExoPlayer解码
//                .setPlayerFactory(ExoMediaPlayerFactory.create())
//                //使用MediaPlayer解码
//                .setPlayerFactory(AndroidMediaPlayerFactory.create())
                .build());
    }

    public static MyApplication getInstance(){
        return instance;
}
    /**
     * 注册广播
     */
    private void registerBroad() {
        NetworkManager.getDefault().init(this);
    }

    private void initprovider() {

//        AndPermission.with(this)
//                .runtime()
//                .permission(new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE, Permission.CAMERA})
//                .start();
    }

    /**
     * 初始化一些第三方框架
     */
    public static void initSDK(Application application) {
        // 这个过程专门用于堆分析的 leak 金丝雀
        // 你不应该在这个过程中初始化你的应用程序
        if (LeakCanary.isInAnalyzerProcess(application)) {
            return;
        }


//        // 内存泄漏检测
//        LeakCanary.install(application);

//        // 友盟统计、登录、分享 SDK
//        UmengClient.init(application);

        // 设置 Toast 拦截器
        ToastUtils.setToastInterceptor(new ToastInterceptor() {
            @Override
            public boolean intercept(Toast toast, CharSequence text) {
                boolean intercept = super.intercept(toast, text);
                if (intercept) {
                    Log.e("Toast", "空 Toast");
                } else {
                    Log.i("Toast", text.toString());
                }
                return intercept;
            }
        });
        // 吐司工具类
        ToastUtils.init(application);

        // 图片加载器
        ImageLoader.init(application);

        // EventBus 事件总线
        EventBusManager.init();

        // Bugly 异常捕捉
        CrashReport.initCrashReport(application, BuildConfig.BUGLY_ID, false);

        // Crash 捕捉界面
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM)
                .enabled(true)
                .trackActivities(true)
                .minTimeBetweenCrashesMs(2000)
                // 重启的 Activity
                .restartActivity(HomeActivity.class)
                // 错误的 Activity

                // 设置监听器
                //.eventListener(new YourCustomEventListener())
                .apply();

    }
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        // 使用 Dex分包
//        //MultiDex.install(this);
//    }
}