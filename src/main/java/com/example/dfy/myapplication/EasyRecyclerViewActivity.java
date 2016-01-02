package com.example.dfy.myapplication;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/1/2.
 */
public class EasyRecyclerViewActivity extends Activity {


        private RecyclerView mRecycleView;

        private GalleryAdapter mAdapter;

        private List<Integer> mDatas;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_easy_item);
            initDatas();
            mRecycleView = (RecyclerView) findViewById(R.id.id_recyclerView);
            //设置布局管理器（系统仅实现了LinearLayoutManager）
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecycleView.setLayoutManager(linearLayoutManager);
            //设置适配器
            mAdapter = new GalleryAdapter(this,mDatas);
            mRecycleView.setAdapter(mAdapter);

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
