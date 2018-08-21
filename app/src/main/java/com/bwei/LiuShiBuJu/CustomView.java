package com.bwei.LiuShiBuJu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by  on 2018/8/21.
 */
public class CustomView extends ViewGroup{

    private int mleftMArgin=20;
    private int mtopMargin = 20;

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        int leftMargin = mleftMArgin;
        int topMargin = mtopMargin;

        int viewHeight = 0;
        int viewWidth = 0;

        //父控件传进来的宽度和高度以及对应的测量模式
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        switch (modeHeight){
            case MeasureSpec.AT_MOST:
                int measuredHeight = 0;
                for (int j=0; j<getChildCount(); j++){
                    int measuredWidth = getChildAt(j).getMeasuredWidth();
                        measuredHeight = getChildAt(j).getMeasuredHeight();
                    if (leftMargin + measuredWidth + mleftMArgin > getWidth()){
                        leftMargin = mleftMArgin;
                        topMargin += measuredHeight + mtopMargin;
                    }
                    leftMargin += measuredWidth+mleftMArgin;
                }
                topMargin += measuredHeight + mtopMargin;
                break;
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int leftMargin = mleftMArgin;
        int topMargin = mtopMargin;

        for (int j=0; j<getChildCount(); j++){
            //子view占据的宽度
            int measuredwidth = getChildAt(j).getMeasuredWidth();
            //子view占据的高度
            int measuredHeight = getChildAt(j).getMeasuredHeight();
            //换行的时候
            if (leftMargin + measuredwidth + mleftMArgin > getWidth()){
                leftMargin = mleftMArgin;
                topMargin += measuredHeight + mtopMargin;

                getChildAt(j).layout(leftMargin,topMargin,
                        leftMargin+measuredwidth,
                        topMargin+measuredHeight
                );

            }else {
                getChildAt(j).layout(leftMargin,topMargin,
                        leftMargin+measuredwidth,topMargin+measuredHeight);
            }
            leftMargin += measuredwidth+mleftMArgin;
        }
    }
}
