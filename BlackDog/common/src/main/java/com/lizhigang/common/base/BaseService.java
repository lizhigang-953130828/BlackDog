package com.lizhigang.common.base;

public interface BaseService<T> {

    T getById(Integer id);

    int insert(T obj);

    int updateById(T obj);

    int deleteById(Integer id);
}
