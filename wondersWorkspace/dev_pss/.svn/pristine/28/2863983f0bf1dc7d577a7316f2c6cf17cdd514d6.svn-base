package com.wondersgroup.core.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public class BaseAspect {
    /**
     * 根据方法返回类型跳转页面
     * 
     * @param method
     * @param view
     * @return
     * @throws Throwable
     */
    protected Object forward(Method method, String view) throws Throwable {
        if (method.isAnnotationPresent(ResponseBody.class)) {
            throw new Exception();
        }

        Class<?> returnType = method.getReturnType();
        if (String.class.equals(returnType)) {
            return view;
        } else if (ModelAndView.class.equals(returnType)) {
            return new ModelAndView(view);
        } else {
            throw new Exception();
        }
    }

    /**
     * 根据切入点获取切入方法
     * 
     * @param point
     * @return
     */
    protected Method getMethod(JoinPoint point) {
        // 目标类
        Class<?> targetClass = point.getTarget().getClass();

        // 根据方法名和参数循环匹配目标方法
        String targetMethodName = point.getSignature().getName();
        Method targetMethod = null;
        for (Method m : targetClass.getMethods()) {
            if (m.getName().equals(targetMethodName) // 方法名相同
                    && m.getParameterTypes().length == point.getArgs().length // 方法参数长度一致
            ) {
                targetMethod = m;
                break;
            }
        }

        return targetMethod;
    }
}
