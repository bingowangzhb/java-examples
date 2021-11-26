package com.bgw.introspector;

import lombok.Builder;
import lombok.Data;

/**
 * @author ambow
 * @since 2021/11/24 9:53
 */
@Data
@Builder
public class Student {

    private String name;

    private Integer age;
}
