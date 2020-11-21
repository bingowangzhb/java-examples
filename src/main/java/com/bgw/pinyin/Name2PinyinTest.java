package com.bgw.pinyin;

import com.alibaba.fastjson.JSON;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Name2Pinyin
 *
 * @author zhibin.wang
 * @since 2020/10/20 11:03
 */
public class Name2PinyinTest {

    public static void main(String[] args) throws Exception {

        toJson(parseText("sy-chu11.txt"));


        //exportNames();
    }

    private static void exportNames() {
        // List<String> fileNames = Arrays.asList("chu1.txt", "chu3.txt", "gao1.txt", "gao3li.txt", "gao3wen.txt", "lifu.txt", "wenfu.txt");
        // List<String> fileNames = Arrays.asList("xy-gao1.txt", "xy-gao3.txt");
        List<String> fileNames = Arrays.asList("sy-chu1.txt");
        List<Student> students =  fileNames.stream()
                .flatMap(f -> parseText(f).stream()
                        .map(str -> {

                            String[] strs = str.split("\t");
                            String s1 = strs[0].trim();
                            String s2 = strs[1].trim();
                            String s3 = strs[2].trim();

                            Student s = new Student();
                            s.setFrom(f);
                            s.setZhName(s1);
                            s.setName("sy-" + convert2Pinyin2(s1));
                            s.setGradeClass(s3);
                            return s;
                        })
                ).collect(Collectors.toList());

        System.out.println("students = " + students.size());

        Set<Student> distinctStudents = new HashSet<>(students);
        System.out.println("distinctStudents = " + distinctStudents.size());


        Map<String, List<Student>> studentMap = students.stream().
                collect(Collectors.groupingBy(Student::getName));

        List<Student> duplicatedStudents = new ArrayList<>();

        studentMap.forEach((k, v) -> {
            if (v.size() > 1) {
                duplicatedStudents.addAll(v);
            }
        });

        duplicatedStudents.forEach(System.out::println);
        System.out.println("duplicatedStudents = " + duplicatedStudents.size());
        students.removeAll(duplicatedStudents);


        System.out.println("students = " + students.size());
        Map<String, List<Student>> duplicatedStudentMap = duplicatedStudents.stream()
                .collect(Collectors.groupingBy(Student::getName));

        duplicatedStudentMap.forEach((k, v) -> {

            for (int i = 0; i < v.size(); i++) {
                String name = v.get(i).getName();
                v.get(i).setName(name + (i + 1));
            }
        });


        duplicatedStudents.forEach(System.out::println);
        students.addAll(duplicatedStudents);

        System.out.println("students = " + students.size());

        Map<String, List<Student>> handledStudentMap = students.stream()
                .collect(Collectors.groupingBy(Student::getFrom));


        handledStudentMap.forEach((k, v) -> {
            System.out.println(" ==============" + k + "================= ");
            List<Student> sortedStudents = v.stream()
                    .sorted(Comparator.comparing(Student::getGradeClass))
                    .collect(Collectors.toList());

            write2Txt(k, sortedStudents);

//            sortedStudents.forEach(s -> {
//                System.out.println(s.getGradeClass() + "\t" + s.getZhName() + "\t" + s.getName());
//            });
            System.out.println(" ======================================== ");
        });
    }


    private static void write2Txt(String fileName, List<Student> students) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("sy-" + fileName));

            for (Student s : students) {
                //把学生对象的数据拼接成指定格式的字符串
                StringBuilder sb = new StringBuilder();
                sb.append(s.getGradeClass()).append("\t").append(s.getZhName()).append("\t").append(s.getName());

                //调用字符缓冲输出流对象的方法写数据
                bw.write(sb.toString());
                bw.newLine();
                bw.flush();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void test1(List<String> fileNames) {
        List<String> zhNames =  fileNames.stream()
                .flatMap(f -> parseText(f).stream())
                .collect(Collectors.toList());

        System.out.println("zhNames = " + zhNames);

        List<String> allNames = fileNames.stream()
                .flatMap(f -> parseText(f).stream()
                        .filter(n -> !"".equals(n))
                        .map(Name2PinyinTest::convert2Pinyin2))
                .collect(Collectors.toList());

        System.out.println("allNames = " + allNames);
        System.out.println("allNames = " + allNames.size());

        Set<String> distinctNames = new HashSet<>(allNames);
        System.out.println("distinctNames = " + distinctNames.size());


        Map<String, Long> zhNameMap = zhNames.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        zhNameMap.forEach((k, v) -> {
            if (v > 1) {
                System.out.println("zhName = " + k);
            }
        });


        Map<String, Long> namesCountMap = allNames.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        AtomicInteger c = new AtomicInteger();
        namesCountMap.forEach((k, v) -> {
            if (v > 1) {
                System.out.println("name = " + k);
                c.incrementAndGet();
            }
        });

        System.out.println("c.get() = " + c.get());


        System.out.println("namesCountMap = " + namesCountMap);
        System.out.println("namesCountMap = " + namesCountMap.size());
        // toJson(convertNames);
    }


    private static List<String> parseText(String fileName) {
        List<String> names = null;
        try {
            names = Files.lines(Paths.get(fileName), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            names = new ArrayList<>(0);
            e.printStackTrace();
        }

        return names;
    }

    private static String convert2Pinyin(String input) {
        // 创建汉语拼音处理类
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出设置，大小写，音标方式
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // HanyuPinyinToneType.WITHOUT_TONE//无声调表示
        // HanyuPinyinToneType.WITH_TONE_MARK//声调符号表示
        // HanyuPinyinToneType.WITH_TONE_NUMBER//声调数字表示
        char[] input_char = input.toCharArray();
        String[] pinyingStr = null;
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            try {
                pinyingStr = PinyinHelper.toHanyuPinyinStringArray(input_char[i], defaultFormat);
                // System.out.println("pinyingStr = " + Arrays.toString(pinyingStr));
                out.append(pinyingStr[0]);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }

    private static String convert2Pinyin2(String input) {
        // 创建汉语拼音处理类
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出设置，大小写，音标方式
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // HanyuPinyinToneType.WITHOUT_TONE//无声调表示
        // HanyuPinyinToneType.WITH_TONE_MARK//声调符号表示
        // HanyuPinyinToneType.WITH_TONE_NUMBER//声调数字表示

        String result;
        try {
            result = PinyinHelper.toHanYuPinyinString(input, defaultFormat, "", false);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }



    private static void exportJson() {




    }




    private static void toJson(List<String> names) throws Exception {
        List<Map<String, String>> list = names.stream()
                .map(n -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("loginName", n);
                    return m;
                }).collect(Collectors.toList());

        String file = "jsonNames.json";
        Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        write.write(JSON.toJSONString(list));
        write.flush();
        write.close();
    }



}
