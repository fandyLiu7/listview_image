package com.fandy.learn.listview_image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by fan on 2018/1/6.
 */

public class MyAdapter extends BaseAdapter {
    private boolean isIdeal = true;
    private Context context;
    private String[] imageUrls;

    public MyAdapter(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public Object getItem(int position) {
        return imageUrls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageView imageView = holder.imageView;

        String url = (String) imageView.getTag(R.id.glide_uri);
        String item = (String) getItem(position);

        if (!item.equals(url)) {
            holder.imageView.setImageResource(0);
        }

        // holder.imageView.setTag(R.id.glide_uri, item);
        Glide.with(context)
                .load(imageUrls[position])
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false)
                .into(holder.imageView);

        return convertView;
    }

    public void changeState() {
        isIdeal = true;
        // notifyDataSetChanged();
    }

    public void stopLoad() {
        isIdeal = false;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}



