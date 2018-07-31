package com.lizhigang.common.utils;

import java.util.HashMap;
import java.util.List;

/**
 * 自定义返回结果集
 * @author lizhigang
 */
public class ResultUtil extends HashMap<String, Object> {

    public ResultUtil put(String key, String value){
        super.put(key, value);
        return this;
    }

    /**
     * 成功返回
     */
    public ResultUtil(){
        put("code", 200);
    }

    public static ResultUtil resultUtilSuccess(String message){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("message",message);
        return resultUtil;
    }

    public static ResultUtil resultUtilSuccess(List<Object> list){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("resultList",list);
        return resultUtil;
    }

    public static ResultUtil resultUtilSuccess(String key, Object value){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put(key,value);
        return resultUtil;
    }

    /**
     * 错误返回
     */
    public static ResultUtil resultUtilError(String message){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", 500);
        resultUtil.put("message",message);
        return resultUtil;
    }

    public static ResultUtil resultUtilError(){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.put("code", 500);
        resultUtil.put("message","未知错误！请稍后再试");
        return resultUtil;
    }
}
