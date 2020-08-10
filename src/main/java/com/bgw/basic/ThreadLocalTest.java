package com.bgw.basic;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocalTest
 *
 * @author wang
 * @since 2020/7/25 12:53
 **/
public class ThreadLocalTest {


    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<User>() {
        @Override
        protected User initialValue() {
            return new User();
        }
    };


    public static void main(String[] args) {

        User user = USER_THREAD_LOCAL.get();
        user.setId(1);
        user.setName("james");


        System.out.println(USER_THREAD_LOCAL.get());


        Map<String, BigDecimal> map = new HashMap<>();
        map.put("1", BigDecimal.ONE);


        Map<String, BigDecimal> map2 = new HashMap<>(map);

        map.computeIfPresent("1", (k, v) -> v.add(BigDecimal.TEN));

        System.out.println(map2);


    }

    @Data
    private static class User {
        private Integer id;
        private String name;
    }
}
