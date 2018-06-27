package com.example.admin.mytestgit.bean;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState);

    public abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != setLayout()) {
            if (setLayout() instanceof Integer) {
                setContentView((int) setLayout());
            } else if (setLayout() instanceof View) {
                setContentView((View) setLayout());
            } else {
                //抛出异常

            }
            ButterKnife.bind(this);
            onBindView(savedInstanceState);
            initData();
        } else {
            //抛出异常
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
