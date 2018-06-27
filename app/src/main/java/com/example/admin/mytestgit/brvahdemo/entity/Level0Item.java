package com.example.admin.mytestgit.brvahdemo.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.admin.mytestgit.brvahdemo.adapter.ExpandableItemAdapter;

import java.io.Serializable;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */
public class Level0Item extends AbstractExpandableItem<ClassroomsEntity> implements MultiItemEntity, Serializable {
    public String title;
    public String subTitle;

    public Level0Item(String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
