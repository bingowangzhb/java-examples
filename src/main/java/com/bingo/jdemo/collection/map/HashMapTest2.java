package com.collection.map;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 说明：HashMapTest2
 *
 * @author ShujuboDev
 */
public class HashMapTest2 {
    public static void main(String[] args) {
        testMap();
    }

    private static void testMap() {
        Set<Student> set = new HashSet<>();
        Student s1 = new Student("zs", 15);
        Student s2 = new Student("zs", 15);

        set.add(s1);
        set.add(s2);

        System.out.println(set);

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
