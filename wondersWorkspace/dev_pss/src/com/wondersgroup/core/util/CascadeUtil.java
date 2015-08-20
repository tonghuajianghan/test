package com.wondersgroup.core.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.collection.PersistentCollection;

public class CascadeUtil {
    /**
     * 延迟加载关联BO（最多加载4层关联）
     * 
     * @param bo
     */
    public static void lazyInit(Object bo) {
        lazyInit(bo, 4);
    }

    /**
     * 延迟加载关联BO
     * 
     * @param bo
     * @param level 最多加载层级
     */
    public static void lazyInit(Object bo, int level) {
        if (bo == null || level < 0) {
            return;
        }

        if (bo instanceof Set) {
            // 延迟加载
            for (Object obj : (Set<?>) bo) {
                lazyInit(obj, level - 1);
            }
            return;
        }

        Field[] fieldArr = bo.getClass().getDeclaredFields();
        if (fieldArr != null) {
            for (Field field : fieldArr) {
                try {
                    Object fieldValue = BeanUtil.getFieldValue(bo, field.getName());

                    if (fieldValue == null) {
                        continue;
                    } else if (fieldValue instanceof Set) {
                        // 延迟加载
                        for (Object obj : (Set<?>) fieldValue) {
                            lazyInit(obj, level - 1);
                        }
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 级联设置关联属性（最多4层级联）
     * 
     * @param rootObj
     * @param propertyValue
     * @param propertyName
     */
    public static void setRefProperty(Object rootObj, Object propertyValue, String propertyName) {
        setRefProperty(rootObj, propertyValue, propertyName, 4);
    }

    /**
     * 设置关联属性
     * 
     * @param rootObj
     * @param propertyValue
     * @param propertyName
     * @param level 最多关联层级数
     */
    public static void setRefProperty(Object rootObj, Object propertyValue, String propertyName, int level) {
        if (rootObj == null || StringUtils.isBlank(propertyName) || level < 0) {
            return;
        }

        if (rootObj instanceof Collection) {
            for (Object obj : (Collection<?>) rootObj) {
                setRefProperty(obj, propertyValue, propertyName, level - 1);
            }
        }

        try {
            Field[] fieldArr = rootObj.getClass().getDeclaredFields();
            for (Field field : fieldArr) {
                String fieldName = field.getName();
                Object fieldValue = BeanUtil.getFieldValue(rootObj, fieldName);

                if (propertyName.equals(fieldName)) {
                    BeanUtil.setFieldValue(rootObj, propertyName, propertyValue);
                } else if (fieldValue == null) {
                    continue;
                } else if (fieldValue instanceof PersistentCollection && !((PersistentCollection) fieldValue).wasInitialized()) {
                    continue;
                } else if (fieldValue instanceof Collection) {
                    for (Object obj : (Collection<?>) fieldValue) {
                        setRefProperty(obj, propertyValue, propertyName, level - 1);
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除对象中为空的关联集合（一对多），同时清除非法空数据（最多4层级联）<br>
     * 关联集合判空条件：集合无成员或集合成员属性均为null或空字符串<br>
     * 
     * @param obj
     */
    public static void clearObject(Object obj) {
        clearObject(obj, 4, null);
    }

    /**
     * 清除对象中为空的关联集合（一对多），同时清除非法空数据（最多4层级联）<br>
     * 关联集合判空条件：集合无成员或集合成员属性均为null或空字符串<br>
     * 
     * @param obj
     * @param fieldFilter 忽略字段名
     */
    public static void clearObject(Object obj, List<String> fieldFilter) {
        clearObject(obj, 4, fieldFilter);
    }

    /**
     * 清除对象中为空的关联集合（一对多），同时清除非法空数据（最多4层级联）<br>
     * 关联集合判空条件：集合无成员或集合成员属性均为null或空字符串<br>
     * 
     * @param obj
     * @param level 最多处理层级
     * @param fieldFilter 忽略字段名
     */
    public static void clearObject(Object obj, int level, List<String> fieldFilter) {
        if (obj == null || level < 0) {
            return;
        }

        Field[] fieldArr = obj.getClass().getDeclaredFields();
        if (fieldArr != null) {
            for (Field field : fieldArr) {
                try {
                    String fieldName = field.getName();
                    Object fieldValue = BeanUtil.getFieldValue(obj, fieldName);

                    if (fieldValue == null) {
                        continue;
                    } else if (fieldValue instanceof PersistentCollection && !((PersistentCollection) fieldValue).wasInitialized()) {
                        continue;
                    } else if (fieldValue instanceof Collection) {
                        // 属性值为一对多关联集合
                        Collection<?> c = (Collection<?>) fieldValue;

                        // 用以保存集合空成员的Set
                        Collection<Object> removeSet = new HashSet<Object>();
                        for (Object v : c) {
                            // 递归处理集合成员对象
                            clearObject(v, level - 1, fieldFilter);

                            // 判断处理后的集合成员对象是否为空
                            if (FormUtil.isObjectEmpty(v, fieldFilter)) {
                                removeSet.add(v);
                            }
                        }

                        // 删除集合中的空元素
                        c.removeAll(removeSet);

                        // TODO 如果当前集合为空，无需设为null，否则hibernate不会执行删除操作
                    } else if (FormUtil.isInputNull(fieldValue)) {
                        // 属性值为系统认定的空值时，该属性设null
                        BeanUtil.setFieldValue(obj, fieldName, null);
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}