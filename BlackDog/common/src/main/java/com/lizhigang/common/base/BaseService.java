package com.lizhigang.common.base;

import com.lizhigang.common.Criteria;

/**
 * Service基类
 * @param <T>
 * @author lizhigang
 */
public interface BaseService<T> {

    T getByCriteria(Criteria criteria);

    Integer insert(T obj);

    Integer updateById(T obj);

    Integer deleteById(Integer id);
}
