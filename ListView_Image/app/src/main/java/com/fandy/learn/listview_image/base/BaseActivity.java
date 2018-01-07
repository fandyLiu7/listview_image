package com.fandy.learn.listview_image.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
    }
    public abstract void initPresenter();
    public abstract void detachView();
}
