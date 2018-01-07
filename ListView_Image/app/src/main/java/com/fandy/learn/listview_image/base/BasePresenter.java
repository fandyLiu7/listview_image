package com.fandy.learn.listview_image.base;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by lixiaoniu on 2018/1/2.
 *
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{
    private V mMvpView;
    protected CompositeSubscription mCompositeSubscription;
    @Override
    public void attachView(V view) {
        mMvpView = view;
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        mMvpView = null;
        mCompositeSubscription.clear();
        mCompositeSubscription = null;
    }


    protected V getMvpView() {
        return mMvpView;
    }
}
