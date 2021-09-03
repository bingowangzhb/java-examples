package com.bgw.reflection.clazz;

import com.bgw.reflection.Man;
import com.bgw.reflection.People;


/**
 * @author ambow
 * @since 2021/8/30 14:04
 */
public class ClazzApiTest {

    public static void main(String[] args) {

        // 确定此 Class 对象表示的类或接口是否与指定的 Class 参数表示的类或接口相同，或者是其超类或超接口。 如果是，则返回 true； 否则返回false。
        // 如果此 Class 对象表示原始类型，则如果指定的 Class 参数正是此 Class 对象，则此方法返回 true； 否则返回false。

        // true
        System.out.println("People.class.isAssignableFrom(Man.class) = " + People.class.isAssignableFrom(Man.class));
        // true
        System.out.println("People.class.isAssignableFrom(People.class) = " + People.class.isAssignableFrom(People.class));
        // false
        System.out.println("People.class.isAssignableFrom(String.class) = " + People.class.isAssignableFrom(String.class));

        // false
        System.out.println("int.class.isAssignableFrom(Integer.class) = " + int.class.isAssignableFrom(Integer.class));
        // true
        System.out.println("int.class.isAssignableFrom(int.class) = " + int.class.isAssignableFrom(int.class));

        System.out.println("Comparable.class.isAssignableFrom(Integer.class) = " + Comparable.class.isAssignableFrom(Integer.class));

        // A.class.isAssignableFrom(B.class)
        // A是B的父类 返回true
    }




}


