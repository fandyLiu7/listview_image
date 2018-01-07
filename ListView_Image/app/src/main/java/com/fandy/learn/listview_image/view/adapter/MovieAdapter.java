package com.fandy.learn.listview_image.view.adapter;

import android.content.Context;


import com.fandy.learn.listview_image.R;
import com.fandy.learn.listview_image.base.BasicAdapter;
import com.fandy.learn.listview_image.base.BasicViewHolder;
import com.fandy.learn.listview_image.common.Constant;
import com.fandy.learn.listview_image.model.pojo.MovieBean;

import java.util.List;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public class MovieAdapter extends BasicAdapter<MovieBean> {
    public MovieAdapter(Context context, List<MovieBean> movieBeanList, int itemLayoutId) {
        super(context, movieBeanList, itemLayoutId);
    }

    @Override
    protected void convert(BasicViewHolder viewHolder, MovieBean item) {
        viewHolder.setImageUri(R.id.iv_movie_item, Constant.IMAGE_URL+item.poster_path);
    }
}
