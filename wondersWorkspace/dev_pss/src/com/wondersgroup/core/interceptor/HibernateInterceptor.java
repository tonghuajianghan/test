package com.wondersgroup.core.interceptor;

import org.hibernate.EmptyInterceptor;

import com.wondersgroup.core.constant.GlobalConstants;

@SuppressWarnings("serial")
public class HibernateInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        sql = sql.replaceAll(GlobalConstants.DB_PREFIX, GlobalConstants.DB_PREFIX_REAL);
        return super.onPrepareStatement(sql);
    }
}
