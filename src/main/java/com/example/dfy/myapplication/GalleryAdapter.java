package com.example.dfy.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>  {


    private LayoutInflater mInflater;
    private List<Integer> mDatas;

    public GalleryAdapter(Context context, List<Integer> mDatas) {
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    /**
     * 自定义ItemClick的回调接口
     */
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnClickLIstener;

    public void setOnItemClickListener(OnItemClickListener mOnClickLIstener) {
        this.mOnClickLIstener = mOnClickLIstener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mImg = (ImageView) view.findViewById(R.id.id_item_image);
        viewHolder.mText = (TextView) view.findViewById(R.id.id_item_text);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mImg.setImageResource(mDatas.get(position));

        //如果设置了ItemClick接口，就设置监听点击事件
        if(mOnClickLIstener!=null) {

            //这里的itemView就是上面ViewHolder构造函数传进去的view
            holder.itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    mOnClickLIstener.onItemClick(view,position);
                }


            });
        }
    }



    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    public  static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView mImg;
        TextView mText;
    }


}
