package com.example.improvement;

import java.util.List;

public class Student extends User{
    List<Course> courses;

    public Student(int UID, String u, String p, int role) {
        super(UID, u, p, role);
    }
}
