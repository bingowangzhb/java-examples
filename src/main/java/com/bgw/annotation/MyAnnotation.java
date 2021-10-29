package com.bgw.annotation;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：
 *
 * @author ab
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping
@Inherited // 表示该注解可以被继承
public @interface MyAnnotation {
    String getValue() default "getValue";
}


// @Inherited继承只能发生在类上，而不能发生在接口上（也就是说标注在接口上仍然是不能被继承的）