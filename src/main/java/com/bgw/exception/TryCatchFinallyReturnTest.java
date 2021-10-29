package com.bgw.exception;

/**
 * TryCatchFinallyReturnIntTest
 *
 * @author zhibin.wang
 * @since 2020/09/07 13:22
 */
public class TryCatchFinallyReturnTest {


    public static void main(String[] args) {
        int result = returnInt1();
        System.out.println("returnInt1() = " + result);
        // System.out.println("returnInt2() = " + returnInt2());
        // System.out.println("returnObj = " + returnObject());
    }

    public static int returnInt1() {
        int a = 100;
        try {
            System.out.println(a / 0);
            a = 200;
        }
        catch (Exception e) {
            a = 300;
            return a;
        }
        finally {
            a = 400;
            System.out.println("a = " + a);
        }

        return a;
    }

    public static int returnInt2() {
        int a = 1;
        try {
            System.out.println(a / 0);
            a = 2;
        }
        catch (Exception e) {
            a = 3;
            return a;
        }
        finally {
            a = 4;
            System.out.println("a = " + a);
            return a;
        }
    }

    public static Killer returnObject() {
        Killer killer = new Killer("a", 10);
        try {
            System.out.println(1 / 0);
            killer.setAge(12);
        }
        catch (Exception e) {
            killer.setAge(13);
            return killer;
        }
        finally {
            killer.setAge(14);
        }

        return killer;
    }

    static class Killer {
        private String name;
        private Integer age;

        public Killer(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Killer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // 最终以finally的return为准
}
