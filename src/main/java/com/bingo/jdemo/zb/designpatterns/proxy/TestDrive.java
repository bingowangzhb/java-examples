package com.zb.designpatterns.proxy;

import com.zb.designpatterns.proxy.handler.OwnerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/8/6 10:02
 */
public class TestDrive {

    public static void main(String[] args) {
        TestDrive drive = new TestDrive();
        drive.drive();
    }

    public void drive() {
        PersonBean personBean = new PersonBeanImpl();
        personBean.setGender("male");
        personBean.setName("li");
        personBean.setInterests("swimming");

        PersonBean proxyPersonBean = getOwnerProxy(personBean);
        //proxyPersonBean.setHotOrNotRating(10);
        System.out.println(proxyPersonBean.getName());


        StringBuilder sb = new StringBuilder();
        String s = null;
        sb.append(s);
        System.out.println(sb.toString() == null);
    }

    private static PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
    }
}
