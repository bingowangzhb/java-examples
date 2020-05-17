package com.bgw.introspector;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class PropertyDescriptorTestCase {


    public static void main(String[] args) throws Exception {
        UserInfo userInfo = new UserInfo();
        setProperty(userInfo);
        getProperty(userInfo);
    }


    private static void setProperty(UserInfo userInfo) throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("userName", UserInfo.class);
        Method setUserNameMtd = propertyDescriptor.getWriteMethod();
        setUserNameMtd.invoke(userInfo, "wang");
        System.out.println("setUserName: " + userInfo.getUserName());
    }


    private static void getProperty(UserInfo userInfo) throws Exception {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("userName", UserInfo.class);
        Method getUserNameMtd = propertyDescriptor.getReadMethod();
        Object name = getUserNameMtd.invoke(userInfo);
        System.out.println("getUserName: " + name);
    }
}
