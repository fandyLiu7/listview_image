package com.fandy.learn.listview_image.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public class BasicViewHolder {
    private View mConvertView;
    private int mPosition;
    private SparseArray<View> mViews;
    private Context mContext;

    private BasicViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mContext = context;
        mPosition = position;
        mViews = new SparseArray<>();
        mConvertView.setTag(this);
    }

    static BasicViewHolder get(Context context, View converView, ViewGroup parent, int layoutId, int position) {
        if (converView == null) {
            return new BasicViewHolder(context, parent, layoutId, position);
        } else {
            return (BasicViewHolder) converView.getTag();
        }
    }

    View getConvertView() {
        return mConvertView;
    }

    private <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }
    public BasicViewHolder setText(int viewId,String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public BasicViewHolder setImageResource(int viewId,int resId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    public BasicViewHolder setImageBitmap(int viewId, Bitmap bitmap){
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public BasicViewHolder setImageUri(int viewId, String uri) {
        ImageView imageView = getView(viewId);
        Picasso.with(mContext).load(uri).into(imageView);
        return this;
    }

    public int getPosition() {
        return mPosition;
    }
}