package com.lizhigang.api.service.sys.impl;


import com.lizhigang.api.BaseInjection;
import com.lizhigang.api.service.sys.UserService;
import com.lizhigang.bean.sys.User;
import com.lizhigang.common.Criteria;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseInjection implements UserService {

    @Override
    public User getByCriteria(Criteria criteria) {
        return super.userMapper.getByCriteriaMapper(criteria);
    }

    @Override
    public Integer insert(User obj) {
        return super.userMapper.insertSelective(obj);
    }

    @Override
    public Integer updateById(User obj) {
        return null;
    }

    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public boolean isExist(String userName, String tel) {
        return false;
    }
}
