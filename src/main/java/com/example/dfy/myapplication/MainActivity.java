package com.example.dfy.myapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private MyRecyclerView mRecycleView;

    private GalleryAdapter mAdapter;

    private List<Integer> mDatas;

    private ImageView mImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        mImg = (ImageView) findViewById(R.id.id_content);
        mRecycleView = (MyRecyclerView) findViewById(R.id.id_recyclerView);
        //设置布局管理器（系统仅实现了LinearLayoutManager）
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(linearLayoutManager);
        //设置适配器
        mAdapter = new GalleryAdapter(this,mDatas);
        mAdapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                mImg.setImageResource(mDatas.get(position));

            }
        });
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setOnItemScrollChange(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int position) {
                mImg.setImageResource(mDatas.get(position));


            }
        });

    }

    private void initDatas() {


        mDatas = new ArrayList<Integer>(Arrays.asList(
                R.drawable.mainpage_tab_discovery_selected,R.drawable.mainpage_tab_message_selected,
                R.drawable.mainpage_tab_mycircle_selected,R.drawable.mainpage_tab_setting_selected,
                R.drawable.mainpage_tab_discovery_normal,R.drawable.mainpage_tab_mycircle_normal,
                R.drawable.mainpage_tab_message_normal,R.drawable.mainpage_tab_setting_normal,
                R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d

        ));
    }


}
