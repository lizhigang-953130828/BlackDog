package com.lizhigang.common.utils;



import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 日志输出工具类
 * @author lizhigang
 */
public class LogUtil {

    /**
     * 日志错误信息输出
     * @param messageLog
     */
    public static void outputLog(String className, String messageLog) throws IOException {
        FileWriter fw = new FileWriter("./log/"+DateUtil.getYearDay()+".txt", true);
        String logContent = "异常时间："+DateUtil.getYearSecond()+"、异常发生类："+className+"、异常发生原因："+messageLog+"\n";
        fw.write(logContent);
        fw.flush();
        fw.close();
    }

}
