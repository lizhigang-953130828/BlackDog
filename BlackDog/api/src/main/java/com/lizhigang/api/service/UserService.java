package com.lizhigang.api.service;

import com.lizhigang.bean.user.User;
import com.lizhigang.common.base.BaseService;

public interface UserService extends BaseService {
    User getByUserName(String userName);
}
