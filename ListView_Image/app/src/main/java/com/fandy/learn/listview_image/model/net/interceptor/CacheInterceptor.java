package com.fandy.learn.listview_image.model.net.interceptor;



import com.fandy.learn.listview_image.common.MovieApplication;
import com.fandy.learn.listview_image.util.NetWorkUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class CacheInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetWorkUtil.IsNetWorkEnable(MovieApplication.getInstance())) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE).build();
        }
        Response response = chain.proceed(request);
        Response latestResponse;
        if (NetWorkUtil.IsNetWorkEnable(MovieApplication.getInstance())) {
            int maxAge = 60;
            latestResponse = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control","public,max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 6; // 没网失效6小时
            latestResponse = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return latestResponse;
    }
}
