package com.bgw.annotation;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;

/**
 * @author ambow
 * @since 2021/9/9 10:45
 */
public class SpringAnnotationTestCase {

    public static void main(String[] args) {
        // Declared 只获取自己的 不管继承
        MyAnnotation myAnn = AnnotationDemo.class.getAnnotation(MyAnnotation.class);
        System.out.println("myAnn = " + myAnn);
        // 相当于交给spring处理，被代理
        MyAnnotation proxyAnn = AnnotationUtils.getAnnotation(myAnn, MyAnnotation.class);
        System.out.println("proxyAnn = " + proxyAnn);
        System.out.println("proxyAnn == myAnn : " + (proxyAnn == myAnn));

        proxyAnn.annotationType();

        // 可以拿到注解上的注解
        Inherited inherited = AnnotationUtils.getAnnotation(myAnn, Inherited.class);
        System.out.println("inherited = " + inherited);

        RequestMapping requestMapping1 = MyAnnotation.class.getAnnotation(RequestMapping.class);
        System.out.println("requestMapping1 = " + requestMapping1);

        RequestMapping requestMapping2 = AnnotationUtils.getAnnotation(myAnn, RequestMapping.class);
        System.out.println("requestMapping2 = " + requestMapping2);

        Annotation[] anns = AnnotationUtils.getAnnotations(AnnotationDemo.class);


    }
}
