package com.bgw.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class IntrospectorTestCase {

    public static void main(String[] args) throws Exception {

        UserInfo userInfo = new UserInfo();
        setProperty(userInfo, "userName", "wang");
        Object value = getProperty(userInfo, "userName");
        System.out.println("get: " + value);
    }


    private static void setProperty(UserInfo userInfo, String propertyName, Object propertyValue) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        if (null != propertyDescriptors && propertyDescriptors.length > 0) {

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().equals(propertyName)) {
                    Method setMth = propertyDescriptor.getWriteMethod();
                    setMth.invoke(userInfo, propertyValue);
                }
            }
        }
    }

    private static Object getProperty(UserInfo userInfo, String propertyName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        if (null != propertyDescriptors && propertyDescriptors.length > 0) {

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().equals(propertyName)) {
                    Method getMth = propertyDescriptor.getReadMethod();
                    return getMth.invoke(userInfo);
                }
            }
        }

        return null;
    }
}
