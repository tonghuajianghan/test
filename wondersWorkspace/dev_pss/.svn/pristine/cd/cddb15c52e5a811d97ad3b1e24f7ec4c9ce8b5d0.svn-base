package com.wondersgroup.core.dialect;

import java.sql.Types;

import org.hibernate.Hibernate;

/**
 * 自定义sybase方言，添加hibernate3.0未支持的特性
 */
public class SybaseDialect extends org.hibernate.dialect.SybaseASE15Dialect {
    public SybaseDialect() {
        super();
        // 添加nvarchar支持
        registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
        // 解决jpa利用NativeQuery查询时将char($l>1)认为character的bug
        registerHibernateType(Types.CHAR, Hibernate.STRING.getName());
    }
}
