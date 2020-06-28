package com.bgw.generic;

import java.util.List;

/**
 * BaseServiceImpl
 *
 * @author wang
 * @since 2020/4/12 22:55
 **/
public class BaseServiceImpl <T extends BaseEntity<T, PK>, PK extends Number> implements BaseService<T, PK> {



    private BaseDao<T, PK> baseDao;

    @Override
    public T findById(PK id) {
        return null;
    }

    @Override
    public List<T> findList(T t) {
        return null;
    }
}
