package com.bgw.generic;

import java.util.List;

/**
 * BaseService
 *
 * @author wang
 * @since 2020/4/12 22:55
 **/
public interface BaseService<T extends BaseEntity<T, PK>, PK extends Number> {

    T findById(PK id);

    List<T> findList(T t);


}
