package com.bgw.collection.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 说明：HashSetTest
 *
 * @author ShujuboDev
 */
public class HashSetTest {
    public static void main(String[] args) {
        // test();
        // testTreeSetOrder2();

        float a = 0.5f;
        System.out.println("a == 5 = " + (a == 0.5));
    }

    private static void test() {
        Set<String> set = new HashSet<>();
        set.add("a");
        System.out.println(set);
        Map<String, Object> table = new Hashtable<>();
        table.put(null, 1);
        table.put(null, null);
    }


    public static void testTreeSetOrder1() {
        String a = "A", b = "B", c = "C", d = "D;";


        Set<String> ss = new TreeSet<>();
        ss.add(a);
        ss.add(b);
        ss.add(c);
        ss.add(d);

        ss.forEach(System.out::println);


    }


    public static void testTreeSetOrder2() {
        Obj o1 = new Obj("asd", "ass");
        Obj o2 = new Obj("ydg", "ddsg");
        Obj o3 = new Obj("sdg", "sdge");

        Set<Obj> ss = new TreeSet<>(Obj.getOrder());
        ss.add(o1);
        ss.add(o2);
        ss.add(o3);

        ss.forEach(System.out::println);




    }

}

class Obj {
    private String id;
    private String name;


    public Obj(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }



    public static Comparator<Obj> getOrder() {
        return new Comparator<Obj>() {
            public int compare(Obj o1, Obj o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
    }

}

