package com.fandy.learn.listview_image.common;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */
//程序中用到的一些接口地址常量
public interface Constant {
    String API_KEY = "643e503c35816202926457ad7d535052";
    String BASE_URL = "http://api.themoviedb.org/3/discover/movie/";
    String POP_LIST =
            "?sort_by=popularity.desc&api_key=";
    String IMAGE_URL = "http://image.tmdb.org/t/p/w185";
    String SCORE_LIST = "movie?sort_by=vote_average.desc&api_key=";
    //网络配置
    long DEFAULT_TIME_OUT = 60;
}
