package com.bgw.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ambow
 * @since 2021/5/25 10:20
 */
public class ListCopyTest {

    public static void main(String[] args) {
        //t2();
        //System.out.println(" ------------------------------ ");
        //t3();

        //t4();
        t5();

    }

    private static void t4() {
        List<Integer> l = null;
        init4(l);
        l.add(1);
        System.out.println("l = " + l);

    }


    private static void init4(List<Integer> l) {
        if (l == null) {
            l = new ArrayList<>();
        }
    }



    private static void t2() {
        Ele ele = null;
        Ele e = init(ele);

        System.out.println("ele = " + ele);
        System.out.println("e = " + e);

    }
    private static void t3() {
        Ele ele = new Ele(1, "james");
        init2(ele);

        System.out.println("ele = " + ele);

    }

    private static void init2(Ele ele) {
        ele.setName("durant");
    }

    private static Ele init(Ele ele) {
        if (null == ele) {
            ele = new Ele(1, "abc");
            return ele;
        }
        return ele;
    }


    private static void t() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6, 7));
        List<Integer> list2 = new ArrayList<>(list);
        list.remove(3);
        list.set(0, 5);
        System.out.println("list = " + list);
        System.out.println("list2 = " + list2);


        List<Ele> eles = new ArrayList<>(Arrays.asList(new Ele(1, "1"), new Ele(2, "2")));
        List<Ele> eles2 = new ArrayList<>(eles);
        eles.get(0).setName("3");
        System.out.println("eles2 = " + eles2);
    }


    private static void t5() {
        List<String> sources = new ArrayList<>(Arrays.asList("A","B","C"));


        List<String> list1 = sources;

        List<String> list2 = Collections.unmodifiableList(sources);
        list2.add("D");

        System.out.println("list2 = " + list2);
        System.out.println("list1 = " + list1);


    }
}

@AllArgsConstructor
@Data
class Ele {
    private Integer id;
    private String name;
}
