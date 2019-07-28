package com.bgw.annotation;

/**
 * 说明：
 *
 * @author ab
 */
@MyAnnotation(getValue = "this is class annotation")
public class AnnotationDemo {

    /**
     * name
     */
    @MyAnnotation(getValue = "this is field annotation")
    public String name;

    /**
     * helloWorld
     */
    @MyAnnotation(getValue = "this is method annotation")
    public void helloWorld() {
    }

    /**
     * defaultMth
     */
    @MyAnnotation
    public void defaultMth() {
        System.out.println(111);
    }
}
