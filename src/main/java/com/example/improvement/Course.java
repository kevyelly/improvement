package com.example.improvement;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
    StringProperty courseCode;
    StringProperty courseName;
    DoubleProperty grade;

    public Course(String courseCode, String courseName, double grade) {
        this.courseCode = new SimpleStringProperty(courseCode);
        this.grade = new SimpleDoubleProperty(grade);
        this.courseName = new SimpleStringProperty(courseName);
    }
}
