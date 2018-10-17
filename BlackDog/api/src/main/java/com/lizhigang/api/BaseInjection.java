package com.lizhigang.api;

import com.lizhigang.api.dao.UserMapper;
import com.lizhigang.api.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 统一注入类（service、mapper）
 */
public class BaseInjection {

    /* service_start */
    @Autowired
    protected UserService userService;
    /* service_end */

    /* mapper_start */
    @Autowired
    protected UserMapper userMapper;
    /* mapper_end */
}
