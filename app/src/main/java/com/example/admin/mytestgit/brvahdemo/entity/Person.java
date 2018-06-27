package com.example.admin.mytestgit.brvahdemo.entity;


import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.admin.mytestgit.brvahdemo.adapter.ExpandableItemAdapter;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public class Person implements MultiItemEntity {
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String name;
    public int age;

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_PERSON;
    }
}