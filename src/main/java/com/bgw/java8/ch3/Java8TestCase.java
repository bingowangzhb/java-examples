package com.bgw.java8.ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/19 15:30
 */
public class Java8TestCase {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "C++", "Python");
        languages.sort((s1, s2) -> s1.length() - s2.length());

        languages.sort(Comparator.comparingInt(String::length));


        System.out.println(languages);
        // languages.sort(Comparator.naturalOrder());
        // languages.sort(String::compareTo);

        TriFunction<Integer, Integer, Integer, Color> colorFacotry = Color::new;


        TriFunction<Integer, Integer, Integer, Color> c2 = new TriFunction<Integer, Integer, Integer, Color>() {
            @Override
            public Color apply(Integer r, Integer g, Integer b) {
                return new Color(r, g, b);
            }
        };



        Color color = colorFacotry.apply(1, 1, 1);
        // Predicate

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();

        s.forEach(System.out::println);

    }
}
