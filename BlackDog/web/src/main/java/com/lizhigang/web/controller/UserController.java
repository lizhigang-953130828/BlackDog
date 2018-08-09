package com.lizhigang.web.controller;

import com.lizhigang.api.BaseInjection;
import com.lizhigang.bean.user.User;
import com.lizhigang.common.base.BaseController;
import com.lizhigang.common.utils.ParamUtil;
import com.lizhigang.common.utils.RequestUtil;
import com.lizhigang.common.utils.ResultUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.lizhigang.common.utils.VerifyCodeUtil.RANDOMCODEKEY;

@Controller
@RequestMapping("/user")
public class UserController extends BaseInjection implements BaseController<User> {

    /**
     * 用户登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "/doLogin.do",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil doLogin(HttpServletRequest request) throws Exception{
        String inVerify = request.getParameter("verify");
        if (inVerify.equals(request.getSession().getAttribute(RANDOMCODEKEY))) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            if (ParamUtil.isEmpty(userName,password)) {
                try {
                    UsernamePasswordToken token = new UsernamePasswordToken(userName, password, false);
                    SecurityUtils.getSubject().login(token);
                    return ResultUtil.resultUtilSuccess("success");
                } catch (UnknownAccountException | IncorrectCredentialsException account) {
                    return ResultUtil.resultUtilFail("401", "用户名或密码错误！");
                }
            }
            return ResultUtil.resultUtilFail("400","用户名或密码不能为空！");
        }
        return ResultUtil.resultUtilFail("400","验证码错误！");
    }

    /**
     * 用户注册
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResultUtil doAdd(HttpServletRequest request, User user) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (ParamUtil.isEmpty(userName,password,password2)) {
            if (password.equals(password2)) {
                user.setUserName(userName);
                user.setPassword(new SimpleHash("MD5", "20160224", password).toHex());
                userService.insert(user);
                return ResultUtil.resultUtilSuccess("success");
            }
            return ResultUtil.resultUtilFail("400","两次密码输入不一致！");
        }
        return ResultUtil.resultUtilFail("400","非法参数！");
    }

    @Override
    public String onEdit(HttpServletRequest request) {
        return null;
    }

    @Override
    public ResultUtil doUpdata(HttpServletRequest request, User user) {
        return null;
    }

    @Override
    public ResultUtil doDelete(HttpServletRequest request) {
        return null;
    }

    @Override
    public String onSelect(HttpServletRequest request) {
        return null;
    }
}
