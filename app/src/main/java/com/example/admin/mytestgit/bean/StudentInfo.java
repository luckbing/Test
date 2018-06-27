package com.example.admin.mytestgit.bean;

import java.util.List;

/**
 * Created by LgAdmin511 on 2018/6/25.
 */

public class StudentInfo {

    private List<StudentsEntity> students;

    public List<StudentsEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsEntity> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "students=" + students.toString() +
                '}';
    }
}
