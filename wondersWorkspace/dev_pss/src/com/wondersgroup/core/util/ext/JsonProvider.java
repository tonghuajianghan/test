package com.wondersgroup.core.util.ext;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

public class JsonProvider extends JacksonJsonProvider {
    public JsonProvider() {
        super();

        ObjectMapper objectMapper = new ObjectMapper();
        // 属性值为空则不作映射
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        // 对属性值进行排序
        objectMapper.enable(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY);
        // 集合为空则不做映射
        objectMapper.disable(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, SerializationConfig.Feature.WRITE_EMPTY_JSON_ARRAYS);
        // 属性不能映射时不抛出异常
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

        super.setMapper(objectMapper);
    }

    /**
     * 设置日期转换格式
     * 
     * @param format
     */
    public void setDateFormat(String format) {
        ObjectMapper objectMapper = this._mapperConfig.getConfiguredMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(format));
        super.setMapper(objectMapper);
    }

    /**
     * 获取当前配置的Mapper
     * 
     * @return
     */
    public ObjectMapper getMapper() {
        return this._mapperConfig.getConfiguredMapper();
    }
}
