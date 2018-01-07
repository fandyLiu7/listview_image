package com.fandy.learn.listview_image.view.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.fandy.learn.listview_image.R;


/**
 * Created by lixiaoniu on 2018/1/3.
 * 固定宽高比的ImageView
 */

public class RationImageView extends ImageView {
    private float mRatio = 1.5f;
    public RationImageView(Context context) {
        this(context,null);
    }

    public RationImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RationImageView);
        mRatio = typedArray.getFloat(R.styleable.RationImageView_image_ration, 1.5f);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取宽度的模式和尺寸
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        //获取高度的模式和尺寸
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //根据宽或者高设置图片的比例
        if (widthMode == MeasureSpec.EXACTLY && heightMode != MeasureSpec.EXACTLY && mRatio != 0) {
            heightSize = (int) (widthSize * mRatio + 0.5f);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,MeasureSpec.EXACTLY);
        } else if (heightMode == MeasureSpec.EXACTLY && widthMode != MeasureSpec.EXACTLY  && mRatio !=0) {
            widthSize = (int) (heightSize/ mRatio + 0.5f);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize,MeasureSpec.EXACTLY);
        } else {
            throw new IllegalArgumentException("图片宽或者高至少要有一个是EXACTLY模式的");
        }
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }

    public void setRation(float ration) {
        this.mRatio = ration;
    }
}
