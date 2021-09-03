package com.bgw.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ambow
 * @since 2021/6/9 10:13
 */
@EqualsAndHashCode(of = {"id", "age"})
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private Integer age;
    private Integer count;
}
