package org.lzh.framework.common.web.interceptor;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:设置web上线文路径
 * @author: lizhaohua
 * @date: 15/12/14 下午1:03
 * @version: V1.0
 */
public class BasePathInterceptor extends HandlerInterceptorAdapter {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(BasePathInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        logger.info(basePath);
        request.setAttribute("basePath", basePath);
        return true;
    }

}