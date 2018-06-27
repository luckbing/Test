package com.example.admin.mytestgit.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by LgAdmin511 on 2018/6/25.
 */

public class ClassInfoEntity {

    /**
     * students : [{"name":"jadyli","gender":"male","age":18},{"name":"Juliet","gender":"female","age":20}]
     * class : A
     */

    @SerializedName("class")
    private String classX;
    private List<StudentsEntity> students;

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public List<StudentsEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsEntity> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classX='" + classX + '\'' +
                ", students=" + students.toString() +
                '}';
    }
}
