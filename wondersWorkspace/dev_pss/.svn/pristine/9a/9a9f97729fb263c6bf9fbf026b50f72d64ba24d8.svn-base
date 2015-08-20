package com.wondersgroup.core.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.wondersgroup.core.constant.ConfigConstants;
import com.wondersgroup.core.exception.DAOException;

@SuppressWarnings("unchecked")
public class BaseJdbcDAO {
    /**
     * 获取数据库源
     * 
     * @param dataSourceName JNDI
     * @return
     */
    private DataSource getDataSource(String dataSourceName) {
        final String accessType = ConfigConstants.getInstance().get("db.access.type");
        if ("jndi".equalsIgnoreCase(accessType) && StringUtils.isNotBlank(dataSourceName)) {
            List<String> prefixList = new ArrayList<String>();
            prefixList.add("");
            prefixList.add("java:");
            prefixList.add("java:comp/env");

            try {
                Context ctx = new InitialContext();
                for (String prefix : prefixList) {
                    try {
                        (ctx = (Context) ctx.lookup(prefix)).listBindings("jdbc");
                        break;
                    } catch (NameNotFoundException ex) {
                        ctx = new InitialContext();
                    }
                }
                return (DataSource) ctx.lookup(dataSourceName);
            } catch (NamingException ex) {
                throw new DAOException("初始化数据源失败！", ex);
            }
        } else {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(ConfigConstants.getInstance().get("db.conn.url"));
            dataSource.setDriverClassName(ConfigConstants.getInstance().get("db.conn.driver"));
            dataSource.setUsername(ConfigConstants.getInstance().get("db.conn.username"));
            dataSource.setPassword(ConfigConstants.getInstance().get("db.conn.password"));
            return dataSource;
        }
    }

    /**
     * 获取JDBC支持类
     * 
     * @param dataSourceName JNDI
     * @return
     */
    protected NamedParameterJdbcTemplate getTemplate(String dataSourceName) {
        return new NamedParameterJdbcTemplate(this.getDataSource(dataSourceName));
    }

    /**
     * 获取JDBC支持类，用于调用存储过程及自定义函数
     * 
     * @param dataSourceName JNDI
     * @return
     */
    protected SimpleJdbcCall getCall(String dataSourceName) {
        return new SimpleJdbcCall(this.getDataSource(dataSourceName));
    }

    /**
     * 获取记录数（使用聚合函数count）
     * 
     * @param dataSourceName
     * @param sql <li>以占位符'?'来表示sql参数的，函数接受不定长参数param</li> <li>同时，接受命名参数规则的sql，函数接受Map<String, ?>及SqlParameterSource类型的参数param</li>
     * @param params
     * @return
     */
    protected int count(String dataSourceName, String sql, Object... params) {
        NamedParameterJdbcTemplate template = this.getTemplate(dataSourceName);

        if (params == null) {
            return template.getJdbcOperations().queryForInt(sql);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return template.queryForInt(sql, (Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return template.queryForInt(sql, (SqlParameterSource) params[0]);
        } else {
            return template.getJdbcOperations().queryForInt(sql, params);
        }
    }

    /**
     * 执行更新语句（增、删、改操作），返回结果
     * 
     * @param dataSourceName
     * @param sql <li>以占位符'?'来表示sql参数的，函数接受不定长参数param</li> <li>同时，接受命名参数规则的sql，函数接受Map<String, ?>及SqlParameterSource类型的参数param</li>
     * @param params
     * @return
     */
    protected int update(String dataSourceName, String sql, Object... params) {
        NamedParameterJdbcTemplate template = this.getTemplate(dataSourceName);

        if (params == null) {
            return template.getJdbcOperations().update(sql);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return template.update(sql, (Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return template.update(sql, (SqlParameterSource) params[0]);
        } else {
            return template.getJdbcOperations().update(sql, params);
        }
    }

    /**
     * 批量执行更新语句（增、删、改操作），返回结果
     * 
     * @param dataSourceName
     * @param sql <li>以占位符'?'来表示sql参数的，函数接受List<Object[]>类型参数param</li> <li>同时，接受命名参数规则的sql，函数接受Map<String, ?>及SqlParameterSource类型的参数param</li>
     * @param params
     * @return
     */
    protected int[] batchUpdate(String dataSourceName, String sql, Object params) {
        NamedParameterJdbcTemplate template = this.getTemplate(dataSourceName);

        if (params == null) {
            return template.getJdbcOperations().batchUpdate(sql, new ArrayList<Object[]>());
        } else if (params instanceof Map[]) {
            return template.batchUpdate(sql, (Map<String, ?>[]) params);
        } else if (params instanceof SqlParameterSource[]) {
            return template.batchUpdate(sql, (SqlParameterSource[]) params);
        } else if (params instanceof List) {
            return template.getJdbcOperations().batchUpdate(sql, (List<Object[]>) params);
        } else {
            return template.getJdbcOperations().batchUpdate(sql, new ArrayList<Object[]>());
        }
    }

    /**
     * 查询结果列表
     * 
     * @param dataSourceName
     * @param sql
     * @param params <li>以占位符'?'来表示sql参数的，函数接受不定长参数param</li> <li>同时，接受命名参数规则的sql，函数接受Map<String, ?>及SqlParameterSource类型的参数param</li>
     * @return
     */
    protected List<Map<String, Object>> find(String dataSourceName, String sql, Object... params) {
        NamedParameterJdbcTemplate template = this.getTemplate(dataSourceName);

        if (params == null) {
            return template.getJdbcOperations().queryForList(sql);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return template.queryForList(sql, (Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return template.queryForList(sql, (SqlParameterSource) params[0]);
        } else {
            return template.getJdbcOperations().queryForList(sql, params);
        }
    }

    /**
     * 查询结果列表
     * 
     * @param dataSourceName
     * @param sql
     * @param rowMapper
     * @param params <li>以占位符'?'来表示sql参数的，函数接受不定长参数param</li> <li>同时，接受命名参数规则的sql，函数接受Map<String, ?>及SqlParameterSource类型的参数param</li>
     * @return
     */
    protected <T> List<T> find(String dataSourceName, String sql, RowMapper<T> rowMapper, Object... params) {
        NamedParameterJdbcTemplate template = this.getTemplate(dataSourceName);

        if (params == null) {
            return template.getJdbcOperations().query(sql, rowMapper);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return template.query(sql, (Map<String, ?>) params[0], rowMapper);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return template.query(sql, (SqlParameterSource) params[0], rowMapper);
        } else {
            return template.getJdbcOperations().query(sql, rowMapper, params);
        }
    }

    /**
     * 查询单个结果
     * 
     * @param dataSourceName
     * @param sql <li>以占位符'?'来表示sql参数的，函数接受不定长参数param</li> <li>同时，接受命名参数规则的sql，函数接受Map<String, ?>及SqlParameterSource类型的参数param</li>
     * @param params
     * @return
     */
    protected Map<String, Object> findUnique(String dataSourceName, String sql, Object... params) {
        NamedParameterJdbcTemplate template = this.getTemplate(dataSourceName);

        try {
            if (params == null) {
                return template.getJdbcOperations().queryForMap(sql);
            } else if (params.length == 1 && params[0] instanceof Map) {
                return template.queryForMap(sql, (Map<String, ?>) params[0]);
            } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
                return template.queryForMap(sql, (SqlParameterSource) params[0]);
            } else {
                return template.getJdbcOperations().queryForMap(sql, params);
            }
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (IncorrectResultSizeDataAccessException e) {
            return this.find(dataSourceName, sql, params).get(0);
        }
    }

    /**
     * 查询单个结果
     * 
     * @param dataSourceName
     * @param sql <li>以占位符'?'来表示sql参数的，函数接受不定长参数param</li> <li>同时，接受命名参数规则的sql，函数接受Map<String, ?>及SqlParameterSource类型的参数param</li>
     * @param rowMapper
     * @param params
     * @return
     */
    protected <T> T findUnique(String dataSourceName, String sql, RowMapper<T> rowMapper, Object... params) {
        NamedParameterJdbcTemplate template = this.getTemplate(dataSourceName);

        try {
            if (params == null) {
                return template.getJdbcOperations().queryForObject(sql, rowMapper);
            } else if (params.length == 1 && params[0] instanceof Map) {
                return template.queryForObject(sql, (Map<String, ?>) params[0], rowMapper);
            } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
                return template.queryForObject(sql, (SqlParameterSource) params[0], rowMapper);
            } else {
                return template.getJdbcOperations().queryForObject(sql, rowMapper, params);
            }

        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (IncorrectResultSizeDataAccessException e) {
            return this.find(dataSourceName, sql, rowMapper, params).get(0);
        }
    }

    /**
     * 调用存储过程并返回结果
     * 
     * @param dataSourceName
     * @param procName 存储过程名
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected Map<String, Object> callProcedure(String dataSourceName, String procName, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withProcedureName(procName);

        if (params == null) {
            return call.execute();
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.execute((Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.execute((SqlParameterSource) params[0]);
        } else {
            return call.execute(params);
        }
    }

    /**
     * 调用存储过程并返回结果
     * 
     * @param dataSourceName
     * @param procName 存储过程名
     * @param schemaName
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected Map<String, Object> callProcedure(String dataSourceName, String procName, String schemaName, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withProcedureName(procName).withSchemaName(schemaName);

        if (params == null) {
            return call.execute();
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.execute((Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.execute((SqlParameterSource) params[0]);
        } else {
            return call.execute(params);
        }
    }

    /**
     * 调用存储过程并返回结果
     * 
     * @param dataSourceName
     * @param procName 存储过程名
     * @param returnType
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected <T> T callProcedure(String dataSourceName, String procName, Class<T> returnType, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withProcedureName(procName);

        if (params == null) {
            return call.executeObject(returnType);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.executeObject(returnType, (Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.executeObject(returnType, (SqlParameterSource) params[0]);
        } else {
            return call.executeObject(returnType, params);
        }
    }

    /**
     * 调用存储过程并返回结果
     * 
     * @param dataSourceName
     * @param procName 存储过程名
     * @param returnType
     * @param schemaName
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected <T> T callProcedure(String dataSourceName, String procName, Class<T> returnType, String schemaName, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withProcedureName(procName).withSchemaName(schemaName);

        if (params == null) {
            return call.executeObject(returnType);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.executeObject(returnType, (Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.executeObject(returnType, (SqlParameterSource) params[0]);
        } else {
            return call.executeObject(returnType, params);
        }
    }

    /**
     * 调用自定义函数并返回结果
     * 
     * @param dataSourceName
     * @param funcName 自定义函数名
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected Map<String, Object> callFunction(String dataSourceName, String funcName, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withFunctionName(funcName);

        if (params == null) {
            return call.execute();
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.execute((Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.execute((SqlParameterSource) params[0]);
        } else {
            return call.execute(params);
        }
    }

    /**
     * 调用自定义函数并返回结果
     * 
     * @param dataSourceName
     * @param funcName 自定义函数名
     * @param schemaName
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected Map<String, Object> callFunction(String dataSourceName, String funcName, String schemaName, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withFunctionName(funcName).withSchemaName(schemaName);

        if (params == null) {
            return call.execute();
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.execute((Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.execute((SqlParameterSource) params[0]);
        } else {
            return call.execute(params);
        }
    }

    /**
     * 调用自定义函数并返回结果
     * 
     * @param dataSourceName
     * @param funcName 自定义函数名
     * @param returnType
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected <T> T callFunction(String dataSourceName, String funcName, Class<T> returnType, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withFunctionName(funcName);

        if (params == null) {
            return call.executeFunction(returnType);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.executeFunction(returnType, (Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.executeFunction(returnType, (SqlParameterSource) params[0]);
        } else {
            return call.executeFunction(returnType, params);
        }
    }

    /**
     * 调用自定义函数并返回结果
     * 
     * @param dataSourceName
     * @param funcName 自定义函数名
     * @param returnType
     * @param schemaName
     * @param params 函数支持Map<String, ?>类型、SqlParameterSource类型及不定长参数
     * @return
     */
    protected <T> T callFunction(String dataSourceName, String funcName, Class<T> returnType, String schemaName, Object... params) {
        SimpleJdbcCall call = this.getCall(dataSourceName).withFunctionName(funcName).withSchemaName(schemaName);

        if (params == null) {
            return call.executeFunction(returnType);
        } else if (params.length == 1 && params[0] instanceof Map) {
            return call.executeFunction(returnType, (Map<String, ?>) params[0]);
        } else if (params.length == 1 && params[0] instanceof SqlParameterSource) {
            return call.executeFunction(returnType, (SqlParameterSource) params[0]);
        } else {
            return call.executeFunction(returnType, params);
        }
    }
}
