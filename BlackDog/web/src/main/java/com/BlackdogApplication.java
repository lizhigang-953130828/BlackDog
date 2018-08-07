package com;

import com.lizhigang.common.utils.VerifyCodeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SpringBootApplication
public class BlackdogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlackdogApplication.class, args);
    }

    @RequestMapping("/getVerify")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response){
        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        // 输出验证码图片方法
        verifyCodeUtil.getRandcode(request, response);
    }
}