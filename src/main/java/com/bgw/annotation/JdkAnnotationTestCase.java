package com.bgw.annotation;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 说明：
 *
 * @author ab
 */
public class JdkAnnotationTestCase {

    public static void main(String[] args) throws Exception {
        jdkAnnotation();
    }
    private static void jdkAnnotation() throws NoSuchFieldException, NoSuchMethodException {
        // 获取到类对应的Class的实例
        Class<AnnotationDemo> clazz = AnnotationDemo.class;

        // 根据class实例获取
        MyAnnotation clazzAnnotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(clazzAnnotation.getValue());

        Field nameField = clazz.getField("name");
        MyAnnotation filedAnnotation = nameField.getAnnotation(MyAnnotation.class);
        System.out.println(filedAnnotation.getValue());
        System.out.println(filedAnnotation.getValue());

        Method helloWorldMethod = clazz.getMethod("helloWorld");
        MyAnnotation helloWorldAnnotation = helloWorldMethod.getAnnotation(MyAnnotation.class);
        System.out.println(helloWorldAnnotation.getValue());

        Method defaultMethod = clazz.getMethod("defaultMth");
        MyAnnotation defaultMethodAnnotation = defaultMethod.getAnnotation(MyAnnotation.class);
        System.out.println(defaultMethodAnnotation.getValue());
    }


}
