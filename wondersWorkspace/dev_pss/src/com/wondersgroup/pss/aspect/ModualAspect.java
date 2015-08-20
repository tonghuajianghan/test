package com.wondersgroup.pss.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import com.wondersgroup.core.aspect.BaseAspect;
import com.wondersgroup.core.constant.GlobalConstants;
import com.wondersgroup.core.util.ext.WebContext;
import com.wondersgroup.pss.annotation.Modual;
import com.wondersgroup.pss.constant.BusinessConstants;

@Repository
@Aspect
public class ModualAspect extends BaseAspect {

    private final Logger logger = Logger.getLogger(ModualAspect.class);

    // 作用于以Modual注解标注的任意方法
    @Pointcut("@annotation(com.wondersgroup.pss.annotation.Modual)")
    public void pointcut() {
    }

    // 设置当前操作所属功能模块，保存至会话
    @Around("pointcut()")
    public Object setModual(ProceedingJoinPoint point) throws Throwable {
        HttpSession session = WebContext.getSession();

        // 获取目标方法
        Method targetMethod = this.getMethod(point);

        if (targetMethod == null) {
            logger.error("找不到相匹配的函数");
            return GlobalConstants.FORWARD_ERROR;
        }

        // 将当前操作所属功能模块更新至当前会话
        session.setAttribute(BusinessConstants.SESSION_MODUAL, targetMethod.getAnnotation(Modual.class).value());

        return point.proceed();
    }
}
