package com.bgw.java8.ch4;

import com.google.common.collect.Lists;
import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
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
        List<String> asLists = Arrays.asList("a", "b", "c");
        asLists.add("d");
        //List<Student> list = Lists.newArrayList(Arrays.asList(new Student("zs", 23), new Student("ls", 34), new Student("ww", 26)));

        //List<Student> sortedList = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        // System.out.println(sortedList);

    }


}


@Data
@ToString
@AllArgsConstructor
class Student {
    private String name;
    private Integer sex;
    private Integer age;
    private Integer height;
}
