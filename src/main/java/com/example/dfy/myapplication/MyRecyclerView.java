package com.example.dfy.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/1/2.
 *
 * 为了实现手指离开，仍能实现图片联动，我又实现了OnScrollListener
 * 这样不需再重写OnTouchEvent方法，但要添加滑动监听，在onScroll里面判断
 * 当第一张图片发生变化，就发生回调。
 */
public class MyRecyclerView extends RecyclerView {

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);


        //为了优化联动，额外加的代码，此时，可以注销掉onTouchEvent方法
        this.setOnScrollListener(new OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                View newView = getChildAt(0);
                if(newView!=null&& newView !=mCurrentView) {
                    mCurrentView = newView;
                    mItemScrollChange.onScrollChange(mCurrentView, getChildPosition(mCurrentView));

                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    /**
     * 记录当前第一个View
     */
    private View mCurrentView;

    /**
     * 滚动时调用的接口
     */
    public interface OnItemScrollChangeListener {
        void onScrollChange(View view, int position);
    }
    private OnItemScrollChangeListener mItemScrollChange;

    public void setOnItemScrollChange(OnItemScrollChangeListener mItemScrollChange) {
        this.mItemScrollChange = mItemScrollChange;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        super.onLayout(changed, l, t, r, b);

        /**
         * 这里之所以再设置一次，是避免第一次加载时，加载的不是列表中第一张图片
         */
        mCurrentView = getChildAt(0);

        if (mItemScrollChange != null) {
            mItemScrollChange.onScrollChange(mCurrentView,
                    getChildPosition(mCurrentView));

        }
    }

   /* @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(e.getAction()==MotionEvent.ACTION_MOVE) {
            mCurrentView = getChildAt(0);
            if (mItemScrollChange != null) {
                mItemScrollChange.onScrollChange(mCurrentView,
                        getChildPosition(mCurrentView));
            }

        }
        return super.onTouchEvent(e);
    }*/
}
