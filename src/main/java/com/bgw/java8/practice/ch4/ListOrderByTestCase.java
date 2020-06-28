package com.bgw.java8.practice.ch4;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ListOrderByTestCase
 *
 * @author zhibin.wang
 * <p>
 * 2019-10-16 15:47
 **/
public class ListOrderByTestCase {

    public static void main(String[] args) {
        List<Student> list = Lists.newArrayList(
                Arrays.asList(new Student("zs", 8, 30),
                        new Student("ls", 8, 100),
                        new Student("ww", null, 150),
                        new Student("lk", 4, null),
                        new Student("sk", 4, 130)));

        List<Student> sortedList = list.stream()
                .sorted(Comparator.comparing(Student::getAge, Comparator.nullsFirst(Integer::compareTo)).reversed()
                        .thenComparing(Student::getHeight, Comparator.nullsFirst(Integer::compareTo).reversed()))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }


}


@Data
@ToString
@AllArgsConstructor
class Student {
    private String name;
    private Integer age;
    private Integer height;
}
