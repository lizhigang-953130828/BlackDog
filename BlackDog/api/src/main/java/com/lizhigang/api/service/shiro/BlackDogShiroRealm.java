package com.lizhigang.api.service.shiro;

import com.lizhigang.api.dao.user.JurisdictionMapper;
import com.lizhigang.api.dao.user.UserMapper;
import com.lizhigang.bean.user.User;
import com.lizhigang.common.Criteria;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class BlackDogShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JurisdictionMapper jurisdictionMapper;

    /**
     * 授权用户权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //获取用户角色
        String jurisdiction = jurisdictionMapper.getByCriteriaMapper(new Criteria().put("id",user.getJurisdictionIdw())).getJurisdictionname();
        Set<String> players = new HashSet(Arrays.asList(jurisdiction.split(",")));
        Set<String> permissionSet = new HashSet();
        players.forEach((player) -> permissionSet.add(player));
        info.setStringPermissions(permissionSet);
        return info;
    }

    /**
     * 验证用户身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = (User) userMapper.getByCriteriaMapper(new Criteria().put("userName",token.getUsername()));
        //密码进行加密处理
        //String encryptionPwd = new SimpleHash("MD5", user.getPassword(), "2016", 1).toString();      // 加密方式、需加密值、盐值、加密次数
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
