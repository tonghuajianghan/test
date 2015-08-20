package com.wondersgroup.core.constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class ConfigConstants {
    /** 单体实例 */
    private static ConfigConstants instance;

    /** 配置属性 */
    private Map<String, String> config = new HashMap<String, String>();

    /**
     * 私有构造器
     */
    private ConfigConstants() {
    }

    /**
     * @return 返回 instance。
     */
    public static ConfigConstants getInstance() {
        if (instance == null) {
            instance = new ConfigConstants();
        }
        return instance;
    }

    /**
     * 获取配置属性
     * 
     * @param key
     * @return
     */
    public String get(String key) {
        return this.config.get(key);
    }

    /**
     * 初始化配置属性
     * 
     * @throws IOException
     */
    public void init() throws IOException {
        // 读取默认配置文件
        this.read("/config.properties");

        // 扩展配置文件路径配置项名称
        String ext = "config.ext";

        // 支持多重继承，循环读取配置
        while (StringUtils.isNotBlank(this.config.get(ext))) {
            // 读取扩展配置文件路径
            String path = this.config.get(ext);

            // 清除配置属性中已读取的扩展配置文件路径
            this.config.remove(ext);

            // 读取扩展配置文件
            this.read(path);
        }
    }

    /**
     * 读取配置文件内容并将配置加载至内存
     * 
     * @param conf 配置文件路径
     * @throws IOException
     */
    private void read(String conf) throws IOException {
        if (StringUtils.isNotBlank(conf)) {
            InputStream is = null;
            Properties props = new Properties();

            try {
                is = ConfigConstants.class.getResourceAsStream(conf);
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
                props.load(br);
                Enumeration<?> propKeys = props.propertyNames();
                while (propKeys.hasMoreElements()) {
                    String propName = (String) propKeys.nextElement();
                    String propValue = props.getProperty(propName);

                    this.config.put(propName, propValue);
                }
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }
    }
}
