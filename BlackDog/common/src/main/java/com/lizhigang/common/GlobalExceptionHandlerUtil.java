package com.lizhigang.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandlerUtil {
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(HttpServletRequest req, Exception e) {
        return "error/500";
    }
}
