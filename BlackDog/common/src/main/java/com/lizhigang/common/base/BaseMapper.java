package com.lizhigang.common.base;

import com.lizhigang.common.Criteria;

import java.util.List;

/**
 * Mapper基类
 * @param <T>
 * @author lizhigang
 */
public interface BaseMapper<T> {
    /**
     * Mybatis逆向工程自动生成---start
     */
    Integer deleteByPrimaryKey(Integer id);

    Integer insertSelective(T t);

    Integer updateByPrimaryKeySelective(T t);
    /**
     * Mybatis逆向工程自动生成---end
     */

    /**
     * 自定义
     * @param criteria
     * @return
     */
    T getByCriteriaMapper(Criteria criteria);

    List<T> getByCriteriaListMapper(Criteria criteria);
}
