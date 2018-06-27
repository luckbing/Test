package com.example.admin.mytestgit.brvahdemo.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.convenientbanner.holder.Holder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.admin.mytestgit.R;
import com.example.admin.mytestgit.bean.MyApplication;
import com.example.admin.mytestgit.brvahdemo.entity.ClassroomEntity;

import java.util.ArrayList;

/**
 * 校园巡视页教学楼对应的教室列表
 * Created by LgAdmin511 on 2018/6/26.
 */

public class LocalClassroomHolderView extends Holder<ArrayList<ClassroomEntity>> {

    private RecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private BaseQuickAdapter mAdapter;
    private final Context mContext;

    public LocalClassroomHolderView(View itemView, Context context) {
        super(itemView);
        mContext = context;
    }

    @Override
    protected void initView(View itemView) {
        mRecyclerView = itemView.findViewById(R.id.rv_classroom);
        mLayoutManager = new GridLayoutManager(MyApplication.getMyBaseContext(), 4);
    }

    @Override
    public void updateUI(ArrayList<ClassroomEntity> data) {
        mAdapter = new ItemClassroomAdapter(R.layout.item_expandable_lv3, data);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ClassroomEntity entity = (ClassroomEntity) adapter.getData().get(position);
                Toast.makeText(mContext, "点击了教室" + entity.getRoomId(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
