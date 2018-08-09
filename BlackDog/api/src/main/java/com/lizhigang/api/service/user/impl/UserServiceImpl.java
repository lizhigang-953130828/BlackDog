package com.lizhigang.api.service.user.impl;


import com.lizhigang.api.BaseInjection;
import com.lizhigang.api.service.user.UserService;
import com.lizhigang.bean.user.User;
import com.lizhigang.common.Criteria;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseInjection implements UserService {

    @Override
    public Integer insert(Object obj) {
        return 0;
    }

    @Override
    public Integer updateById(Object obj) {
        return 0;
    }

    @Override
    public Integer deleteById(Integer id) {
        return 0;
    }

    @Override
    public User getByCriteria(Criteria criteria) {
        return super.userMapper.getByCriteriaMapper(criteria);
    }
}
