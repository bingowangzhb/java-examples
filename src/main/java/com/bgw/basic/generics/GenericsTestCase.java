package com.bgw.basic.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTestCase {

    public static void main(String[] args) {

        List<? extends Fruit> list1 = new ArrayList<>();
        list1.add(null);
        // 上限只能get不能add
        // list1.add(new Fruit()); 会报错
        Fruit f = list1.get(0);


        List<? super Apple> list2 = new ArrayList<>();
        list2.add(new Apple());
        list2.add(new Fuji());

        // 下限只能add 不能get
        final Object object = list2.get(0);
    }

}


class Fruit {}
class Apple extends Fruit {}
class Fuji extends Apple {}
class Banana extends Fruit {}
