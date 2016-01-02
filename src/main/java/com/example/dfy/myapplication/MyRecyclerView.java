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
 * Ϊ��ʵ����ָ�뿪������ʵ��ͼƬ����������ʵ����OnScrollListener
 * ������������дOnTouchEvent��������Ҫ��ӻ�����������onScroll�����ж�
 * ����һ��ͼƬ�����仯���ͷ����ص���
 */
public class MyRecyclerView extends RecyclerView {

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);


        //Ϊ���Ż�����������ӵĴ��룬��ʱ������ע����onTouchEvent����
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
     * ��¼��ǰ��һ��View
     */
    private View mCurrentView;

    /**
     * ����ʱ���õĽӿ�
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
         * ����֮����������һ�Σ��Ǳ����һ�μ���ʱ�����صĲ����б��е�һ��ͼƬ
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
