package com.wondersgroup.pss.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.UUID;

import javassist.util.proxy.ProxyFactory;

import javax.persistence.Entity;

import org.hibernate.collection.PersistentCollection;

import com.wondersgroup.core.util.BeanUtil;

/**
 * 业务相关工具类
 * 
 * @author computeradd
 */
public class BusinessUtil {
    /**
     * 随机生成32位UUID
     * 
     * @return
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 清除一对多双向关联中的一方关联属性，防止JSON对象循环解析
     * 
     * @param obj
     * @return 返回处理后的对象
     */
    public static <T> T clearChain(T obj) {
        if (obj == null) {
            return obj;
        }

        if (obj instanceof Collection<?>) {
            // 循环处理集合
            for (Object o : (Collection<?>) obj) {
                clearChain(o);
            }
        } else {
            // 遍历非集合类属性
            Field[] fieldArr = obj.getClass().getDeclaredFields();
            if (fieldArr != null) {
                for (Field field : fieldArr) {
                    try {
                        String fieldName = field.getName();
                        Object fieldValue = BeanUtil.getFieldValue(obj, fieldName);

                        if (fieldValue != null && (ProxyFactory.isProxyClass(fieldValue.getClass()) || fieldValue.getClass().isAnnotationPresent(Entity.class))) {
                            // 清除关联属性（此处认为实体Bean即为一方关联属性）
                            BeanUtil.setFieldValue(obj, fieldName, null);
                        } else if (fieldValue instanceof PersistentCollection && !((PersistentCollection) fieldValue).wasInitialized()) {
                            // 清除未延迟加载的属性
                            BeanUtil.setFieldValue(obj, fieldName, null);
                        } else if (fieldValue instanceof Collection<?>) {
                            // 迭代处理
                            clearChain(fieldValue);
                        }
                    } catch (NoSuchFieldException e) {
                        continue;
                    }
                }
            }
        }

        return obj;
    }

}
