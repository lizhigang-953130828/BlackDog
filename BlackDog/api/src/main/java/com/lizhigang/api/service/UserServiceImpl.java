package com.lizhigang.api.service;

import com.lizhigang.api.dao.UserMapper;
import com.lizhigang.bean.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUserNameMapper(userName);
    }

    @Override
    public Object getById(Integer id) {
        return null;
    }

    @Override
    public int insert(Object obj) {
        return 0;
    }

    @Override
    public int updateById(Object obj) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
