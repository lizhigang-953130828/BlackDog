package com.lizhigang.api.dao;


import com.lizhigang.bean.user.User;

/**
 * 用户dao
 * @author lizhigang
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查询对象
     * @param userName
     * @return 对象
     */
    User getByUserNameMapper(String userName);
}