package com.hong.widgetstyle.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hong.widgetstyle.R;
import com.hong.widgetstyle.ui.widget.CycleProgress;

/**
 * Created by root on 2018/9/12.
 */

public class ProgressActivity extends AppCompatActivity{

    private CycleProgress cycleProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        initView();
    }

    private void initView() {
        cycleProgress = (CycleProgress) findViewById(R.id.cycle_progress);
        cycleProgress.setAnimator(100    );
        cycleProgress.startAnimator();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cycleProgress.stopAnimator();
    }
}
