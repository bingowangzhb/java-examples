package com.bgw.java8.stream.example02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamMergeTestCase {


    public static void main(String[] args) {

        List<StudentScore> studentScores = Arrays.asList(
                new StudentScore("1", "张三", "1", "chinese", 75),
                new StudentScore("1", "张三", "2", "maths",  99),
                new StudentScore("1", "张三", "3", "english",  94),
                new StudentScore("2", "李四", "1", "chinese",  95),
                new StudentScore("2", "李四", "2", "maths",  99),
                new StudentScore("2", "李四", "3", "english",  93),
                new StudentScore("3", "王五", "1", "chinese",  92),
                new StudentScore("3", "王五", "2", "maths",  94),
                new StudentScore("3", "王五", "3", "english",  91));

        Map<String, Integer> scoreMap = new HashMap<>();
        studentScores.forEach(studentScore ->
                scoreMap.merge(studentScore.getStudentName(), studentScore.getScore(), Integer::sum));

        System.out.println(scoreMap);
    }
}
