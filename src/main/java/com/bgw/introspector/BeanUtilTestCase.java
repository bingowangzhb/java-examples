package com.bgw.introspector;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilTestCase {


    public static void main(String[] args) throws Exception {

        UserInfo userInfo = new UserInfo();

        BeanUtils.setProperty(userInfo, "age", 23);
        System.out.println(userInfo.getAge());
    }
}
