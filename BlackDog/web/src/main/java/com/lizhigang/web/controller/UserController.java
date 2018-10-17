package com.lizhigang.web.controller;

import com.aliyuncs.exceptions.ClientException;
import com.lizhigang.api.BaseInjection;
import com.lizhigang.api.aliyun.SmsApi;
import com.lizhigang.bean.sys.User;
import com.lizhigang.common.base.BaseController;
import com.lizhigang.common.utils.DateUtil;
import com.lizhigang.common.utils.ParamUtil;
import com.lizhigang.common.utils.ResultUtil;
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
    public ResultUtil doLogin(HttpServletRequest request) {
        String inVerify = request.getParameter("verify");
        if (inVerify.equals(request.getSession().getAttribute(RANDOMCODEKEY))) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            if (ParamUtil.isEmpty(userName,password)) {
                try {
                    UsernamePasswordToken token = new UsernamePasswordToken(userName, password, false);
                    SecurityUtils.getSubject().login(token);
                    return ResultUtil.resultSuccess("success");
                } catch (UnknownAccountException | IncorrectCredentialsException account) {
                    return ResultUtil.resultFail("4011", "用户名或密码错误！");
                }
            }
            return ResultUtil.resultFail("4003","用户名或密码不能为空！");
        }
        return ResultUtil.resultFail("4001","验证码错误！");
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
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String veriCode = request.getParameter("veriCode");
        String userName = request.getParameter("userName");
        if (ParamUtil.isEmpty(tel,password,password2,veriCode,userName)) {
            try {
                String sessionCode = request.getSession().getAttribute(tel).toString();
                if (sessionCode.equals(veriCode)) {
                    if (password.equals(password2)) {
                        if (userService.isExist(userName, tel)) {
                            user.setUserName(userName);
                            user.setTel(tel);
                            user.setRegisterTime(DateUtil.getYearSecond());
                            user.setPassword(new SimpleHash("MD5", "20160224", password).toHex());
                            userService.insert(user);
                            return ResultUtil.resultSuccess("success");
                        }

                    }
                    return ResultUtil.resultFail("4002", "两次密码输入不一致！");
                }
            }catch (NullPointerException n) {
                return ResultUtil.resultFail("4001", "验证码错误！");
            }
        }
        return ResultUtil.resultFail("400","非法参数！");
    }

    /**
     * 发送验证码
     * @param request
     * @return
     * @throws ClientException
     */
    @RequestMapping("/sendSms.do")
    @ResponseBody
    public ResultUtil sendSms(HttpServletRequest request) throws ClientException {
        String tel = request.getParameter("tel");
        if (ParamUtil.isEmpty(tel)) {
            /*String code = SmsApi.sendSms(tel);
            if (code.equals("403") || code.equals("400")) {
                return ResultUtil.resultFail("403","发送验证码发生异常！请联系管理员QQ：953130828");
            }*/
            request.getSession().setAttribute(tel,"123456");
            return ResultUtil.resultSuccess("success");
        }
        return ResultUtil.resultFail("400","非法参数！");
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
