package com.wondersgroup.core.util;

import com.wondersgroup.core.constant.GlobalConstants;

/**
 * 数据库类型属性工具类
 * 
 * @author Ryan
 */
public class DBUtil {
    /**
     * 当前数据库是否是sybase
     * 
     * @return
     */
    public static boolean isSybase() {
        return "sybase".equalsIgnoreCase(GlobalConstants.DB_TYPE);
    }

    /**
     * 当前数据库是否是oracle
     * 
     * @return
     */
    public static boolean isOracle() {
        return "oracle".equalsIgnoreCase(GlobalConstants.DB_TYPE);
    }

    /**
     * 当前数据库是否是mysql
     * 
     * @return
     */
    public static boolean isMySql() {
        return "mysql".equalsIgnoreCase(GlobalConstants.DB_TYPE);
    }

    /**
     * 当前数据库是否是informix
     * 
     * @return
     */
    public static boolean isInformix() {
        return "informix".equalsIgnoreCase(GlobalConstants.DB_TYPE);
    }

    /**
     * 当前数据库是否是DB2
     * 
     * @return
     */
    public static boolean isDb2() {
        return "DB2".equalsIgnoreCase(GlobalConstants.DB_TYPE);
    }

    /**
     * 当前数据库是否是sqlserver
     * 
     * @return
     */
    public static boolean isSqlServer() {
        return "sqlserver".equalsIgnoreCase(GlobalConstants.DB_TYPE);
    }

    /**
     * 返回数据库中获取字段数据长度的函数名
     * 
     * @return
     */
    public static String getLengthFunc() {
        if (isSybase()) {
            return "datalength";
        } else {
            return "length";
        }
    }

    /**
     * 返回数据库中字符串截取函数名
     * 
     * @return
     */
    public static String getSubstrFunc() {
        if (isSybase()) {
            return "substring";
        } else {
            return "substr";
        }
    }

    /**
     * 返回数据库中字符串替换函数名
     * 
     * @return
     */
    public static String getReplaceFunc() {
        if (isSybase()) {
            return "str_replace";
        } else {
            return "replace";
        }
    }

    /**
     * 返回数据库中获取当前时间的函数名
     * 
     * @return
     */
    public static String getTodayFunc() {
        if (isSybase() || isSqlServer()) {
            return "getdate()";
        } else if (isOracle()) {
            return "sysdate";
        } else if (isInformix()) {
            return "current";
        } else if (isMySql()) {
            return "sysdate()";
        } else {
            return "sysdate";
        }
    }
}
