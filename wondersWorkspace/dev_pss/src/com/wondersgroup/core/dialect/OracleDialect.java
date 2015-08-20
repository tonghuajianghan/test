package com.wondersgroup.core.dialect;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.StandardSQLFunction;

/**
 * 自定义Oracle方言，添加hibernate3.0未支持的特性
 */
public class OracleDialect extends org.hibernate.dialect.Oracle10gDialect {

    public OracleDialect() {
        super();
        // 添加lvarchar支持
        registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
        // 解决jpa利用NativeQuery查询时将char($l>1)认为character的bug
        registerHibernateType(Types.CHAR, Hibernate.STRING.getName());
        registerFunction("getdate", new NoArgSQLFunction("sysdate", Hibernate.DATE, false));
        registerFunction("substring", new StandardSQLFunction("substr", Hibernate.STRING));
    }
}
