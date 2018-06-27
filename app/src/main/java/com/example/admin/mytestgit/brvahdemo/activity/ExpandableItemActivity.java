package com.example.admin.mytestgit.brvahdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListAdapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.admin.mytestgit.R;
import com.example.admin.mytestgit.bean.BaseActivity;
import com.example.admin.mytestgit.brvahdemo.adapter.ExpandableItemAdapter;
import com.example.admin.mytestgit.brvahdemo.entity.ClassroomEntity;
import com.example.admin.mytestgit.brvahdemo.entity.ClassroomsEntity;
import com.example.admin.mytestgit.brvahdemo.entity.Level0Item;
import com.example.admin.mytestgit.brvahdemo.entity.Person;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public class ExpandableItemActivity extends BaseActivity {
    @BindView(R.id.rv_expand)
    RecyclerView mRvExpand;
    ExpandableItemAdapter mAdapter;
    ArrayList<MultiItemEntity> mDataList = null;

    public static Intent getInstance(Context context) {
        Intent intent = new Intent(context, ExpandableItemActivity.class);
        return intent;
    }

    @Override
    public Object setLayout() {
        return R.layout.activity_expand_item;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState) {
        mDataList = generateData();
        mAdapter = new ExpandableItemAdapter(mDataList, this);
        mRvExpand.setAdapter(mAdapter);

        // important! setLayoutManager should be called after setAdapter
        mRvExpand.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mAdapter.expandAll();
        mAdapter.expand(0);
    }

    @Override
    public void initData() {
//        mDataList = generateData();
    }

    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 9;
        int classroomCount = 130;

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item(i + 1 + "号教学楼", "[共30间教室]" + i);
            ArrayList<ArrayList<ClassroomEntity>> pageNums = new ArrayList<>();
            int times = 0;
            if (classroomCount % 16 == 0) {
                times = classroomCount / 16;
            } else {
                times = classroomCount / 16 + 1;
            }
            for (int j = 0; j < times; j++) {
                ArrayList<ClassroomEntity> list = new ArrayList<>();
                int start = j * 16;
                int end = (j + 1) * 16 < classroomCount ? (j + 1) * 16 : classroomCount;
                for (int k = start; k < end; k++) {
                    list.add(new ClassroomEntity("教室11" + k, k + ""));
                }
                pageNums.add(list);
            }
            lv0.addSubItem(new ClassroomsEntity(pageNums));
            res.add(lv0);
        }
        res.add(new Level0Item(lv0Count + 1 + "号教学楼", "[共30间教室]" + lv0Count));
        return res;
    }
}
