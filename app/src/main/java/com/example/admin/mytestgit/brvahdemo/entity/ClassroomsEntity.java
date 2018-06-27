package com.example.admin.mytestgit.brvahdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.admin.mytestgit.brvahdemo.adapter.ExpandableItemAdapter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public class ClassroomsEntity implements MultiItemEntity, Serializable {

    private ArrayList<ArrayList<ClassroomEntity>> onePageClassroom;

    public ClassroomsEntity(ArrayList<ArrayList<ClassroomEntity>> onePageClassroom) {
        this.onePageClassroom = onePageClassroom;
    }

    public ArrayList<ArrayList<ClassroomEntity>> getOnePageClassroom() {
        return onePageClassroom;
    }

    public void setOnePageClassroom(ArrayList<ArrayList<ClassroomEntity>> onePageClassroom) {
        this.onePageClassroom = onePageClassroom;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_PERSON;
    }
}
