package com.steam.ch2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/23 10:09
 */
public class Ch2TestCase {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        // menu.stream().map(Dish::getName).forEach(System.out::println);

//        List<String> names =
//                menu.stream()
//                        .filter(d -> {
//                            System.out.println("filtering" + d.getName());
//                            return d.getCalories() > 500;
//                        })
//                        .map(d -> {
//                            System.out.println("mapping" + d.getName());
//                            return d.getName();
//                        })
//                        .limit(3)
//                        .collect(toList());
//        System.out.println(getDishNameByNonStream(menu, 400));
        // System.out.println(getDishNameByStream(menu, 400));
//
//        Map<Dish.Type, List<Dish>> typeDishes =
//                menu.stream().collect(groupingBy(Dish::getType));
//        System.out.println(typeDishes);

    }


    public static List<String> getDishNameByNonStream(List<Dish> allDishes, int calories) {

        List<Dish> lowCarolryDishes = new ArrayList<>();
        // 添加低卡路里事务
        for (Dish dish : allDishes) {
            if (dish.getCalories() < 400) {
                lowCarolryDishes.add(dish);
            }
        }

        // 卡路里从高到低排序
        lowCarolryDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return d2.getCalories() - d1.getCalories();
            }
        });


        List<String> resultDishes = new ArrayList<>();
        for (Dish dish : lowCarolryDishes) {
            resultDishes.add(dish.getName());
        }

        return resultDishes;

    }

    public static List<String> getDishNameByStream(List<Dish> allDishes, int calories) {
        return allDishes.stream()
                .filter(d -> d.getCalories() < calories)
                .sorted(comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .collect(toList());
    }

    @Test
    public void test1() {

        List<Integer> numbers = Arrays.asList(1, 4, 2, 4, 3, 5, 9, 22, 9, 5);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::print);


    }

    @Test
    public void test2() {

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "zhangsan");
        obj1.put("age", 19);
        JSONObject obj2 = new JSONObject();
        obj2.put("name", "lisi");
        obj2.put("age", 20);
        JSONObject obj3 = new JSONObject();
        obj3.put("name", "wangwu");
        obj3.put("age", 21);

        List<JSONObject> list = Arrays.asList(obj1, obj2, obj3);


        list.stream()
                .filter(jsonObject -> jsonObject.getIntValue("age") > 19)
                .forEach(jsonObject -> System.out.println(jsonObject.getString("name")));


    }

    @Test
    public void test3() {
        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        streamOfWords.map(String::length).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList());
        System.out.println(squares);
    }

    @Test
    public void test4() {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(4, 5);

        number1.stream().flatMap(i -> number2.stream().map(j -> new int[]{i, j})).forEach(System.out::println);
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("5.6", "7.4", "4",
                "1", "2.3");

        // Using Stream flatMap(Function mapper)
        list.stream().flatMap(Stream::of).
                forEach(System.out::println);


        // Creating a List of Strings
        List<String> list2 = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");

        // Using Stream flatMap(Function mapper)
        list2.stream().flatMap(str ->
                Stream.of(str.charAt(2))).
                forEach(System.out::println);
    }

    @Test
    public void test6() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(numbers.stream().reduce(0, Math::addExact));

    }

}
