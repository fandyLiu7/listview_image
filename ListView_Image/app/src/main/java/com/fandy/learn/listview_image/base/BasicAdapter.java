package com.fandy.learn.listview_image.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by lixiaoniu on 2018/1/3.
 *
 */

public abstract class BasicAdapter<T> extends BaseAdapter {
    private Context mContext;
    private List<T> mDatas;
    private int mItemLayoutId;
    public BasicAdapter(Context context,List<T> data,int itemLayoutId){
        mContext = context;
        mDatas = data;
        mItemLayoutId = itemLayoutId;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BasicViewHolder viewHolder = getViewHolder(position,convertView,parent);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();
    }

    protected abstract void convert(BasicViewHolder viewHolder, T item);

    private BasicViewHolder getViewHolder(int position,View convertView,ViewGroup parent){
        return BasicViewHolder.get(mContext,convertView,parent,mItemLayoutId,position);
    }
}
