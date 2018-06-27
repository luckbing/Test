package com.example.admin.mytestgit.brvahdemo.entity;

import java.io.Serializable;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public class ClassroomEntity implements Serializable {
    private String roomName;
    private String roomId;

    public ClassroomEntity(String roomName, String roomId) {
        this.roomName = roomName;
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
