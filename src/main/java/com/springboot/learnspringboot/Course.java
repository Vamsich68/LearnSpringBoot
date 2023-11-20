package com.springboot.learnspringboot;

import org.springframework.stereotype.Component;


public class Course {
    private int id;
    private String coursename;
    private String platform;

    public Course() {
    }

    public Course(int id, String coursename, String platform) {
        super();
        this.id = id;
        this.coursename = coursename;
        this.platform = platform;
    }



    public int getId() {
        return id;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", coursename=" + coursename + ", author=" + platform + "]";
    }
}
