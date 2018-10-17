package com.lizhigang.api.service.sys;

import com.lizhigang.bean.sys.User;
import com.lizhigang.common.base.BaseService;

public interface UserService extends BaseService<User> {
    /**
     * 指定数据是否已存在
     * @param userName
     * @param tel
     * @return true/false
     */
    boolean isExist(String userName,String tel);
}
