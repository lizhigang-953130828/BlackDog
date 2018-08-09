package com.lizhigang.common.utils;



import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RequestUtil {

    public static JSONObject getRequestJson(HttpServletRequest request) throws Exception {
        JSONObject json = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
        String tempStr = null;
        StringBuilder sb = new StringBuilder();
        tempStr = reader.readLine();
        while (tempStr != null) {
            sb.append(tempStr);
        }
        json = JSONObject.fromObject(sb);
        return json;
    }
}
