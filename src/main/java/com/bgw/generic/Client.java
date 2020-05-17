package com.bgw.generic;

/**
 * Client
 *
 * @author wang
 * @since 2020/4/12 23:44
 **/
public class Client {

    public static void main(String[] args) {





        UserServiceImpl userService = new UserServiceImpl();
        userService.findById(1L);
    }
}
