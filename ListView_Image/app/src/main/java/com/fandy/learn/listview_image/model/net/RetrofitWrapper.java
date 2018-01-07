package com.fandy.learn.listview_image.model.net;


import com.fandy.learn.listview_image.common.Constant;
import com.fandy.learn.listview_image.model.net.interceptor.BasicParamsInterceptor;
import com.fandy.learn.listview_image.model.net.interceptor.CacheInterceptor;
import com.fandy.learn.listview_image.model.net.interceptor.LogginInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class RetrofitWrapper {
    private Retrofit mRetrofit;

    private RetrofitWrapper() {
        //创建OkhttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Constant.DEFAULT_TIME_OUT, TimeUnit.SECONDS);


//        //添加公共参数拦截器，此处不需要，所以注释掉
        BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder()
                .addParam("token", "123456")
                .addParam("os", "android")
                .addHeaderParam("header", "tag")
                .build();


        Interceptor interceptor = new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request authorised = originalRequest.newBuilder()
                        .header("header", "hellow")
                        .build();
                return chain.proceed(authorised);
            }
        };

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("name", "小牛")
                        .addQueryParameter("age", "18")
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });




        //添加日志拦截器
        builder.addInterceptor(interceptor)
                .addInterceptor(new LogginInterceptor())
                //添加缓存拦截器
                .addInterceptor(new CacheInterceptor());


        //======================================配置Retrofit
        mRetrofit = new Retrofit.Builder().client(builder.build()).
                baseUrl("http://aaaaaa/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static RetrofitWrapper getInstence() {
        return RetrofitHolder.instance;
    }

    //静态内部类实现单例
    private static class RetrofitHolder {
        private static RetrofitWrapper instance = new RetrofitWrapper();
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }
}
