package com.lizhigang.common.utils;

import org.apache.commons.lang.StringUtils;

public class ParamUtil {

    /**
     * 判断传入值是否为空
     * @param param
     * @return 为空则返回false
     */
    public static boolean isEmpty(String... param){
        boolean falg = true;
        for (int i=0;i<param.length;i++) {
            if(StringUtils.isBlank(param[i])) {
                falg=false;
            }
        }
        return falg;
    }
}
