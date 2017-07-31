package com.tanxin.jinxian;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.tanxin.jinxian.utils.SystemBarTintManager;

/**
 * Created by TANXIN on 2017/7/31.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected int stateBarColor = R.color.white;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸是状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(stateBarColor);//通知栏所需颜色
        }
        setContentView(LayoutInflater.from(this).inflate(setLayout(), null));

        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }
        initView(savedInstanceState);
    }


    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    protected abstract int setLayout();


    /**
     * Bundle  传递数据
     *
     * @param extras Bundle
     */
    protected abstract void getBundleExtras(Bundle extras);

    protected abstract void initView(Bundle savedInstanceState);


    public Context getContext(){
        return this;
    }
}
