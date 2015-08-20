package com.wondersgroup.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import org.apache.commons.lang.StringUtils;

import com.wondersgroup.core.constant.GlobalConstants;

public class FormUtil {
    /**
     * 判断对象是否为空，即判断对象是否为空或其属性是否均为空(null或空字符串)
     * 
     * @param obj
     * @return
     */
    public static boolean isObjectEmpty(Object obj) {
        return isObjectEmpty(obj, null);
    }

    /**
     * 判断对象是否为空，即判断对象是否为空或其属性是否均为空(null或空字符串)
     * 
     * @param obj
     * @param fieldFilter 忽略字段名
     * @return
     */
    public static boolean isObjectEmpty(Object obj, List<String> fieldFilter) {
        if (obj == null) {
            return true;
        }

        Field[] fieldArr = obj.getClass().getDeclaredFields();
        if (fieldArr != null) {
            for (Field field : fieldArr) {
                try {
                    String fieldName = field.getName();
                    Object fieldValue = BeanUtil.getFieldValue(obj, fieldName);

                    if (fieldFilter != null && fieldFilter.contains(fieldName)) {
                        continue;
                    } else if (fieldValue == null || StringUtils.isBlank(fieldValue.toString()) || Modifier.isFinal(field.getModifiers())
                            || fieldValue.getClass().isAnnotationPresent(Entity.class)) {
                        continue;
                    } else if (fieldValue instanceof Collection<?> && ((Collection<?>) fieldValue).isEmpty()) {
                        continue;
                    } else {
                        return false;
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    /**
     * 判断用户是否录入空值<br>
     * 对于页面中的字符类型对象，如果录入值为空字符串，则数据对象对应属性设为null<br>
     * 对于页面中的非字符类型对象，如果录入值为空，则对该项设置特殊值<br>
     * 如果Form Bean中某属性为对应类型的特殊值，则判断该项用户录入空值，并设置数据对象对应属性为null<br>
     * 
     * @param value
     * @return
     */
    public static boolean isInputNull(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof Integer && GlobalConstants.FORM_INTEGER_NULL.equals(value)) {
            return true;
        } else if (value instanceof Short && GlobalConstants.FORM_SHORT_NULL.equals(value)) {
            return true;
        } else if (value instanceof Double && GlobalConstants.FORM_DOUBLE_NULL.equals(value)) {
            return true;
        } else if (value instanceof BigDecimal && GlobalConstants.FORM_BIGDECIMAL_NULL.equals(value)) {
            return true;
        } else if (value instanceof Date && GlobalConstants.FORM_DATE_NULL.equals(value)) {
            return true;
        } else if (value instanceof String && StringUtils.isBlank(value.toString())) {
            return true;
        }

        return false;
    }

    /**
     * 复制已赋值的属性值至目标对象（忽略null属性值和集合属性）
     * 
     * @param dest 目标对象
     * @param orig 源对象
     */
    public static void copyProperties(Object dest, Object orig) {
        if (orig == null) {
            return;
        }

        Field[] fieldArr = orig.getClass().getDeclaredFields();
        if (fieldArr != null) {
            for (Field field : fieldArr) {
                try {
                    String fieldName = field.getName();
                    Object fieldValue = BeanUtil.getFieldValue(orig, fieldName);

                    if (fieldValue == null || fieldValue instanceof Set || Modifier.isFinal(field.getModifiers())
                            || fieldValue.getClass().isAnnotationPresent(Entity.class)) {
                        continue;
                    } else if (isInputNull(fieldValue)) {
                        // 页面录入值为空字符串时，目标对象该属性值设为null
                        BeanUtil.setFieldValue(dest, fieldName, null);
                    } else {
                        BeanUtil.setFieldValue(dest, fieldName, fieldValue);
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据源集合更新目标集合内容
     * 
     * @param <T> 集合对象泛型
     * @param destSet 目标集合
     * @param origSet 源集合
     */
    public static <T> void updateSet(Collection<T> destSet, Collection<T> origSet) {
        if (destSet == null) {
            // 目标集合为null时，初始化目标集合并复制所有源集合数据
            destSet = new LinkedHashSet<T>();
            destSet.addAll(origSet);
            return;
        }

        if (origSet == null) {
            // 源集合为null时，将更新目标集合为空集，根据hibernate机制将删除相应数据集
            destSet.clear();
            return;
        }

        // 将源集合对象中的信息更新至已有集合
        Set<T> newSet = new LinkedHashSet<T>();
        for (T enty : origSet) {
            boolean hit = false;

            for (T e : destSet) {
                if (e.equals(enty)) {
                    copyProperties(e, enty);
                    newSet.add(e);
                    hit = true;
                    break;
                }
            }

            if (!hit) {
                newSet.add(enty);
            }
        }

        destSet.clear();
        destSet.addAll(newSet);
    }
}
