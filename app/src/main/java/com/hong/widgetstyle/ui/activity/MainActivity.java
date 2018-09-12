package com.hong.widgetstyle.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hong.widgetstyle.R;
import com.hong.widgetstyle.bean.TypleBean;
import com.hong.widgetstyle.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch ((int)msg.obj) {
                case 0:
                    startActivity(new Intent(MainActivity.this, BubbleActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, ProgressActivity.class));
                    break;
                default:
                    break;
            }
        }
    };


    List<TypleBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        MainAdapter adapter = new MainAdapter(this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(adapter);
        adapter.setHandler(handler);
    }

    private void initData() {
        list.add(new TypleBean("悬浮欢迎界面", 0));
        list.add(new TypleBean("进度条", 1));
        list.add(new TypleBean("悬浮欢迎界面3", 2));
    }
}
