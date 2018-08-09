package com.lizhigang.common.base;


import com.lizhigang.common.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller基类
 * @author lizhigang
 * @param <T>
 */
public interface BaseController<T> {


    /**
     * 执行-添加
     * @param request
     * @param t
     * @return
     */
    ResultUtil doAdd(HttpServletRequest request, T t);

    /**
     * 跳转-修改
     * @param request
     * @return
     */
    String onEdit(HttpServletRequest request);

    /**
     * 执行-修改
     * @param request
     * @param t
     * @return
     */
    ResultUtil doUpdata(HttpServletRequest request, T t);

    /**
     * 执行-删除
     * @param request
     * @return
     */
    ResultUtil doDelete(HttpServletRequest request);

    /**
     * 执行-查询
     * @param request
     * @return
     */
    String onSelect(HttpServletRequest request);
}
