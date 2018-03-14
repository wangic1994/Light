package com.wangic.light;

import android.app.Application;

import org.xutils.x;

/**
 * Created by wangic on 2018/3/10.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
