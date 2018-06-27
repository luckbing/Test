package com.example.admin.mytestgit.brvahdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.admin.mytestgit.R;
import com.example.admin.mytestgit.brvahdemo.entity.ClassroomEntity;

import java.util.List;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public class ItemClassroomAdapter extends BaseQuickAdapter<ClassroomEntity, BaseViewHolder> {
    public ItemClassroomAdapter(int layoutResId, @Nullable List<ClassroomEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassroomEntity item) {
        helper.setText(R.id.tv_classroom_name, item.getRoomName());
    }
}
