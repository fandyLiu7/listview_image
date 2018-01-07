package com.fandy.learn.listview_image.base;

/**
 * Created by lixiaoniu on 2018/1/2.
 */
interface MvpPresenter<V extends MvpView>  {
    void attachView(V view);
    void  detachView();
}
