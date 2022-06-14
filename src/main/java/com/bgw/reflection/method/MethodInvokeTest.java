package com.bgw.reflection.method;

import com.bgw.reflection.beans.Father;
import com.bgw.reflection.beans.Son;

import java.lang.reflect.Method;

/**
 * @author ambow
 * @since 2021/11/29 18:23
 */
public class MethodInvokeTest {

    public static final String F_PATH = "com.bgw.reflection.beans.Father";
    public static final String S_PATH = "com.bgw.reflection.beans.Son";


    public static void main(String[] args) throws Exception {

        Class<?> fatherClass = Class.forName(F_PATH);
        Class<?> sonClass = Class.forName(S_PATH);

        Father father = (Father) fatherClass.newInstance();
        Son son = (Son) sonClass.newInstance();

        // 1.反射调用子类父类的重载方法
        // 多态+动态绑定
        Method fatherMethod = father.getClass().getDeclaredMethod("publicFatherMethod");
        // print "publicFatherMethod"
        fatherMethod.invoke(father);
        // print "Son Override publicFatherMethod"
        fatherMethod.invoke(son);

        Method sonMethod = son.getClass().getDeclaredMethod("publicFatherMethod");

        sonMethod.invoke(son);
        // sonMethod.invoke(father); // 抛出IllegalArgumentException: object is not an instance of declaring class
    }

}
