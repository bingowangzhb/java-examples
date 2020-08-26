package com.bgw.reflection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Person
 *
 * @author zhibin.wang
 * @since 2020/08/21 16:03
 */
@Getter
@Setter
@Data
public class Person {
    private Integer id;
    private String name;
}
