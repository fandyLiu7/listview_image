package com.fandy.learn.listview_image.common;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.fandy.learn.listview_image.util.LogUtil;


/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class MovieApplication  extends Application {
    private static MovieApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initComponent();
    }
    public void initComponent(){
        LogUtil.initLog(this);
    }
    public static MovieApplication getInstance() {
        return mInstance;
    }

    public boolean isDebug(){
        return getApplicationInfo() != null && (getApplicationInfo().flags
                & ApplicationInfo.FLAG_DEBUGGABLE) == ApplicationInfo.FLAG_DEBUGGABLE;
    }
}

/*
* Application中方法的执行顺序：
* 构造方法
* attachBaseContext
* onCreate
*
* */