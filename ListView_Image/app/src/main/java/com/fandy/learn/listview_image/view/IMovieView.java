package com.fandy.learn.listview_image.view;


import com.fandy.learn.listview_image.base.MvpView;
import com.fandy.learn.listview_image.model.pojo.MovieInfo;

/**
 * Created by lixiaoniu on 2018/1/2.
 *
 */

public interface IMovieView extends MvpView {
    void showLoading();
    void hideLoading();
    void showError(Throwable e);
    void setMovieInfo(MovieInfo movieInfo);
}
