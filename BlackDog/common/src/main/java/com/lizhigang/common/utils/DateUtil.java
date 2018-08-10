package com.lizhigang.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取/格式时间工具类
 * @author lizhigang
 */
public class DateUtil {

	public static final String formatYearSecond="yyyy-MM-dd hh:mm:ss";
    public static final String formatYearDay="yyyy-MM-dd";

	/**
	 * 获取详细时间年到秒级
	 * @return
	 */
	public static String getYearSecond(){
		SimpleDateFormat sf = new SimpleDateFormat(formatYearSecond);
		return sf.format(new Date());
	}

    /**
     * 获取详细时间年到天级
     * @return
     */
    public static String getYearDay(){
        SimpleDateFormat sf = new SimpleDateFormat(formatYearDay);
        return sf.format(new Date());
    }

    /**
     * 获取当前时间毫秒数
     * @return
     */
    public static String getMillisecond(){
        return String.valueOf(System.currentTimeMillis());
    }
}
