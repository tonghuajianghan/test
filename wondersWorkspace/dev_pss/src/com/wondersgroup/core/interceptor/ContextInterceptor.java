package com.wondersgroup.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wondersgroup.core.constant.ConfigConstants;
import com.wondersgroup.core.constant.GlobalConstants;
import com.wondersgroup.core.util.ext.WebContext;

public class ContextInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 用户会话信息
        HttpSession session = request.getSession();

        // 从会话中获取根路径
        String base = (String) session.getAttribute(GlobalConstants.SESSION_BASE);

        if (StringUtils.isBlank(base)) {
            // 服务器地址
            String host = request.getServerName();
            // 传送协议
            String schema = ConfigConstants.getInstance().get("scheme.default");
            schema = StringUtils.isBlank(schema) ? request.getScheme() : schema;
            schema = ConfigConstants.getInstance().get("scheme.special.http").contains(host) ? "http" : schema;
            schema = ConfigConstants.getInstance().get("scheme.special.https").contains(host) ? "https" : schema;
            // 服务器端口
            String port = ConfigConstants.getInstance().get("port.default");
            port = StringUtils.isBlank(port) ? String.valueOf(request.getServerPort()) : port;
            port = ConfigConstants.getInstance().get("port.special.empty").contains(host) ? "" : port;
            String ports = ConfigConstants.getInstance().get("port.special.list");
            if (StringUtils.isNotBlank(ports)) {
                for (String p : ports.split(",")) {
                    String hosts = ConfigConstants.getInstance().get("port.special." + p);
                    port = StringUtils.isNotBlank(hosts) && hosts.contains(host) ? p : port;
                }
            }
            port = StringUtils.equals("80", port) ? "" : ":" + port;
            // 资源路径
            String path = request.getContextPath();

            // 设置URL请求根路径
            base = schema + "://" + host + port + path + "/";

            // 将根路径保存至会话
            session.setAttribute(GlobalConstants.SESSION_BASE, base);
        }

        // 设置Web上下文信息
        WebContext.setRequest(request);
        WebContext.setResponse(response);

        // 结束拦截
        return true;
    }
}