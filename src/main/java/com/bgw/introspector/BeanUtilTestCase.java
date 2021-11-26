package com.bgw.introspector;

public class BeanUtilTestCase {


    public static void main(String[] args) {

        UserInfo userInfo = UserInfo.builder()
                .userId(1L)
                .userName("zhang")
                .age(12)
                .email("azhang@amb.com")
                .build();

        //BeanUtils.setProperty(userInfo, "age", 23);
        System.out.println(userInfo);
    }
}
