package com.tanxin.jinxian;

import android.os.Bundle;
import android.view.KeyEvent;

import com.tanxin.jinxian.view.X5WebView;

public class MainActivity extends BaseActivity {
    X5WebView viewWeb;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        viewWeb = (X5WebView) findViewById(R.id.view_web);
        viewWeb.loadUrl("http://qc.linshexiaoqu.com/m/");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (viewWeb != null && viewWeb.canGoBack()) {
                viewWeb.goBack();
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
