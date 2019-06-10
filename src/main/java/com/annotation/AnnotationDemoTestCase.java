package com.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 说明：
 *
 * @author ab
 */
public class AnnotationDemoTestCase {

    public static void main(String[] args) throws Exception {
        Class<AnnotationDemo> clazz = AnnotationDemo.class;
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
