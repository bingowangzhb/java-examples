package com.bgw.pinyin;

import java.util.Objects;

/**
 * Student
 *
 * @author zhibin.wang
 * @since 2020/10/28 17:29
 */
public class Student {

    private String name;
    private String zhName;
    private String gradeClass;
    private String from;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getGradeClass() {
        return gradeClass;
    }

    public void setGradeClass(String gradeClass) {
        this.gradeClass = gradeClass;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", zhName='" + zhName + '\'' +
                ", gradeClass='" + gradeClass + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
