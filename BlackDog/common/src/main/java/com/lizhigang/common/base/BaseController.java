package com.lizhigang.common.base;


import javax.servlet.http.HttpServletRequest;

/**
 * Controller基类
 * @author lizhigang
 * @param <T>
 */
public interface BaseController<T> {

    /**
     * 跳转-添加
     * @return
     */
    String onAdd();

    /**
     * 执行-添加
     * @param request
     * @param object
     * @return
     */
    String doAdd(HttpServletRequest request, T object);

    /**
     * 跳转-修改
     * @param request
     * @return
     */
    String onEdit(HttpServletRequest request);

    /**
     * 执行-修改
     * @param request
     * @param object
     * @return
     */
    String doUpdata(HttpServletRequest request, T object);

    /**
     * 执行-删除
     * @param request
     * @return
     */
    String doDelete(HttpServletRequest request);

    /**
     * 执行-查询
     * @param request
     * @return
     */
    String onSelect(HttpServletRequest request);
}
