package com.bgw.lombok;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ambow
 * @since 2021/6/9 10:16
 */
public class Test {

    public static void main(String[] args) {

        Set<User> users = new HashSet<>();

        User u1 = new User(1,1,1);
        User u2 = new User(1,1,2);

        users.add(u1);
        users.add(u2);

        System.out.println("u1.hashCode() = " + u1.hashCode());
        System.out.println("u2.hashCode() = " + u2.hashCode());
        System.out.println(u1.equals(u2));


        System.out.println("users = " + users);







    }
}
