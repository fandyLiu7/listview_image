package com.fandy.learn.listview_image.model.net.service;




import com.fandy.learn.listview_image.common.Constant;
import com.fandy.learn.listview_image.model.pojo.MovieInfo;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public interface MovieService {
    //此处的完整路径为http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=643e503c35816202926457ad7d535052
    @GET(Constant.POP_LIST+ Constant.API_KEY)//拼接在BASE_URL后面的路径
    Observable<MovieInfo> getMovieInfo();
}
