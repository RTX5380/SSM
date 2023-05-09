package com.ssm.domain;

import java.util.Objects;

public class Course {

    private Integer id;
    private Integer hours;
    private String name;
    private String coursePic;
    private Integer sid;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", hours=" + hours +
                ", name='" + name + '\'' +
                ", coursePic='" + coursePic + '\'' +
                ", sid=" + sid +
                '}';
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
