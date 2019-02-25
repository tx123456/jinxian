package com.test.tty;

import android.app.Application;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by TANXIN on 2017/7/30.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  null);
    }
}
