package com.example.admin.mytestgit.pagerslidingtabstrip.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.mytestgit.R;
import com.example.admin.mytestgit.pagerslidingtabstrip.adapter.MyPagerAdapter;
import com.gxz.PagerSlidingTabStrip;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerSlidingTabStripDemoActivity extends AppCompatActivity {
    @BindView(R.id.tabs)
    PagerSlidingTabStrip mTabStrip;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    public static Intent getInstance(Context context){
        Intent intent = new Intent(context, PagerSlidingTabStripDemoActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sliding_tab_strip_demo);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("TAB_TAB " + i);
        }
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), list));
        mTabStrip.setViewPager(mViewPager);
//        mViewPager.setCurrentItem(1);
    }
}
