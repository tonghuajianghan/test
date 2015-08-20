package com.wondersgroup.core.aspect;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import com.wondersgroup.core.annotation.Token;
import com.wondersgroup.core.constant.ConfigConstants;
import com.wondersgroup.core.constant.GlobalConstants;
import com.wondersgroup.core.util.ext.WebContext;

@Repository
@Aspect
public class TokenAspect extends BaseAspect {

    private final Logger logger = Logger.getLogger(TokenAspect.class);

    @Pointcut("@annotation(com.wondersgroup.core.annotation.Token)")
    public void token() {
    }

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void controller() {
    }

    /**
     * 设置令牌
     */
    @Before("controller()")
    public void set() {
        // 当前会话
        HttpSession session = WebContext.getSession();
        // 令牌索引
        String key = GlobalConstants.SESSION_TOKEN;

        // 获取令牌
        Object token = session == null ? null : session.getAttribute(key);

        // 设置令牌
        if (token == null) {
            session.setAttribute(key, UUID.randomUUID().toString());
        } else {
            session.setAttribute(key, token.toString());
        }
    }

    /**
     * 校验令牌
     * 
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("token()")
    public Object verify(ProceedingJoinPoint point) throws Throwable {
        // 获取目标方法
        Method targetMethod = super.getMethod(point);

        if (targetMethod == null) {
            logger.error("找不到相匹配的函数");
            return GlobalConstants.FORWARD_ERROR;
        }

        HttpServletRequest request = WebContext.getRequest();
        HttpSession session = WebContext.getSession();

        // 令牌索引
        String key = GlobalConstants.SESSION_TOKEN;
        // 获取页面令牌
        Object attr = request.getAttribute(key);
        String pageToken = attr == null ? request.getParameter(key) : attr.toString();
        // 获取会话令牌
        attr = session.getAttribute(key);
        String sessionToken = attr == null ? "" : attr.toString();

        // 更新会话令牌
        if (targetMethod.getAnnotation(Token.class).renewal()) {
            session.setAttribute(key, UUID.randomUUID().toString());
        }

        if (StringUtils.equals(pageToken, sessionToken)) {
            // 令牌校验通过，请求成功
            return point.proceed();
        } else {
            // 令牌校验未通过，请求失败，将跳转至注解配置的跳转页面
            String redirect = targetMethod.getAnnotation(Token.class).redirect();

            // 默认跳转
            if (StringUtils.isBlank(redirect)) {
                redirect = ConfigConstants.getInstance().get("token.redirect.default");
            }

            // 重定向至跳转页面
            return super.forward(targetMethod, "redirect:" + redirect);
        }
    }
}
