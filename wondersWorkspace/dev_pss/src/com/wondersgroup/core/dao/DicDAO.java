package com.wondersgroup.core.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.wondersgroup.core.constant.ConfigConstants;
import com.wondersgroup.core.constant.GlobalConstants;

@SuppressWarnings("unused")
public class DicDAO extends BaseJdbcDAO {
    private static final String PERSISTENCE_UNIT_BUSINESS = ConfigConstants.getInstance().get("jdbc.business");

    /**
     * 根据查询结果集组装字典
     * 
     * @param result
     * @return
     */
    private Map<String, String> getDic(List<Map<String, Object>> result) {
        Map<String, String> map = new LinkedHashMap<String, String>();

        if (result != null) {
            for (Map<String, Object> r : result) {
                String key = StringUtils.trimToEmpty(String.valueOf(r.get("k")));
                String value = StringUtils.trimToEmpty(String.valueOf(r.get("v")));
                map.put(key, value);
            }
        }

        return map;
    }

    /**
     * 根据查询结果集组装字典（两级）
     * 
     * @param result
     * @return
     */
    private Map<String, Map<String, String>> getAdvancedDic(List<Map<String, Object>> result) {
        Map<String, Map<String, String>> map = new LinkedHashMap<String, Map<String, String>>();

        if (result != null) {
            for (Map<String, Object> r : result) {
                String key1 = StringUtils.trimToEmpty(String.valueOf(r.get("k1")));
                String key2 = StringUtils.trimToEmpty(String.valueOf(r.get("k2")));
                String value = StringUtils.trimToEmpty(String.valueOf(r.get("v")));

                if (!map.containsKey(key1)) {
                    map.put(key1, new LinkedHashMap<String, String>());
                }

                Map<String, String> subMap = map.get(key1);
                subMap.put(key2, value);
            }
        }

        return map;
    }

    /**
     * 获取常规字典
     * 
     * @param dataSourceName 数据源
     * @param tableName 表名
     * @param keyColumn 索引字段名
     * @param valueColumn 字典值字段名
     * @param validityColumn 有效性字段名
     * @param orderbyColumns 排序
     * @return
     */
    private Map<String, String> getDic(String dataSourceName, String tableName, String keyColumn, String valueColumn, String validityColumn,
            String orderbyColumns) {
        if (StringUtils.isBlank(tableName) || StringUtils.isBlank(keyColumn) || StringUtils.isBlank(valueColumn)) {
            return new LinkedHashMap<String, String>();
        }

        StringBuffer sql = new StringBuffer("select ");
        sql.append(keyColumn).append(" as k, ").append(valueColumn).append(" as v from ").append(tableName);

        if (StringUtils.isNotBlank(validityColumn)) {
            sql.append(" where ").append(validityColumn).append(" = '").append(GlobalConstants.YES_VALUE).append("'");
        }

        if (StringUtils.isNotBlank(orderbyColumns)) {
            sql.append(" order by ").append(orderbyColumns);
        }

        return this.getDic(super.find(dataSourceName, sql.toString()));
    }

    /**
     * 用户类型字典
     * 
     * @return
     */
    public Map<String, String> getDicUserType() {
        return getDic(PERSISTENCE_UNIT_BUSINESS, "DIC_USER_TYPE", "TYPE_ID", "TYPE_NAME", null, null);
    }

    /**
     * 产品字典
     * 
     * @return
     */
    public Map<String, String> getDicProd() {
        return getDic(PERSISTENCE_UNIT_BUSINESS, "PSS_PROD", "PROD_ID", "PROD_NAME", null, null);
    }
}
