package com.lizhigang.web.controller;

import com.lizhigang.bean.user.User;
import com.lizhigang.bean.user.UserJurisdiction;
import com.lizhigang.common.base.BaseController;
import com.lizhigang.common.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController implements BaseController<UserController> {


    /**
     * 用户登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "/doLogin.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil doLogin(HttpServletRequest request){
        System.out.println("登陆运行中..."+request.getParameter("userName"));
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("userName"), request.getParameter("password"),false);
        SecurityUtils.getSubject().login(token);
        return ResultUtil.resultUtilSuccess("success");
    }


    @Override
    public String onAdd() {
        return null;
    }

    @Override
    public String doAdd(HttpServletRequest request, UserController object) {
        return null;
    }

    @Override
    public String onEdit(HttpServletRequest request) {
        return null;
    }

    @Override
    public String doUpdata(HttpServletRequest request, UserController object) {
        return null;
    }

    @Override
    public String doDelete(HttpServletRequest request) {
        return null;
    }

    @Override
    public String onSelect(HttpServletRequest request) {
        return null;
    }
}
