package com.fandy.learn.listview_image.presenter.impl;


import com.fandy.learn.listview_image.base.BasePresenter;
import com.fandy.learn.listview_image.model.net.RetrofitWrapper;
import com.fandy.learn.listview_image.model.net.service.MovieService2;
import com.fandy.learn.listview_image.model.pojo.MovieInfo;
import com.fandy.learn.listview_image.presenter.IMoviePresenter;
import com.fandy.learn.listview_image.view.IMovieView;
import com.fandy.learn.listview_image.view.MainActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class MoviePresentImpl extends BasePresenter<IMovieView> implements IMoviePresenter {
    private IMovieView mMovieView;

    public MoviePresentImpl(MainActivity movieView) {
        super.attachView(movieView);
        this.mMovieView = movieView;
    }

    @Override
    public void getMovieInfo() {
        MovieService2 movieService = RetrofitWrapper.getInstence().create(MovieService2.class);
        mCompositeSubscription.add(movieService.getMovieInfo("c.login", "aaa", 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieInfo>() {
                    @Override
                    public void call(MovieInfo movieInfo) {
                        System.out.println(movieInfo.toString());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println(throwable.toString());
                    }
                }));
    }

}
