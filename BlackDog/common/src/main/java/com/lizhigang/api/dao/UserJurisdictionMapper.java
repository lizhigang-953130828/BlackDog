package com.lizhigang.api.dao;

import com.lizhigang.bean.UserJurisdiction;

public interface UserJurisdictionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserJurisdiction record);

    int insertSelective(UserJurisdiction record);

    UserJurisdiction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserJurisdiction record);

    int updateByPrimaryKey(UserJurisdiction record);
}