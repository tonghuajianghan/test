package com.wondersgroup.core.util.el;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.HtmlUtils;

import com.wondersgroup.core.constant.ConfigConstants;
import com.wondersgroup.core.util.DateUtil;

public class Tools {
    /**
     * 根据键值取值
     * 
     * @param map
     * @param key
     * @return
     */
    public static Object map(Map<?, ?> map, Object key) {
        return map == null ? null : (map.get(key) == null ? map.get(String.valueOf(key)) : map.get(key));
    }

    /**
     * 获取集合中第一个元素
     * 
     * @param <T>
     * @param con
     * @return
     */
    public static <T> T first(Collection<T> con) {
        if (con != null) {
            for (T ele : con) {
                return ele;
            }
        }

        return null;
    }

    /**
     * 对数字对象作处理，如果为0或空则返回默认值
     * 
     * @param number 数字对象
     * @param defaultValue 默认值
     * @return
     */
    public static String number(Number number, String defaultValue) {
        if (number == null || StringUtils.isBlank(number.toString()) || "0".equals(number.toString())) {
            return defaultValue;
        } else {
            return number.toString();
        }
    }

    /**
     * 字符串长度控制
     * 
     * @param str 原字符串
     * @param maxlen 字符串最大长度
     * @param suffix 如果有截断，则返回字符串含后缀
     * @return
     */
    public static String cutstr(String str, int maxlen, String suffix) {
        // 后缀默认为空字符串
        if (StringUtils.isBlank(suffix)) {
            suffix = "";
        }
        // 字符串真实长度
        int len = str.replaceAll("[^\\x00-\\xff]", "**").length();
        if (len > maxlen) {
            // 当前双字节字符数
            int count = str.replaceAll("[\\x00-\\xff]", "").length();
            // 当前至少还需截断的长度
            int cutlen = Math.max((int) Math.floor((count + str.length() - maxlen) / 2), 1);
            // 递归截取字符串
            return cutstr(str.substring(0, str.length() - cutlen), maxlen, "") + suffix;
        } else {
            return str;
        }
    }

    /**
     * 获取字符串真实长度
     * 
     * @param str
     * @return
     */
    public static int len(String str) {
        return str.replaceAll("[^\\x00-\\xff]", "**").length();
    }

    /**
     * 获取配置文件中的键值
     * 
     * @param key 键名
     * @return
     */
    public static String config(String key) {
        return ConfigConstants.getInstance().get(key);
    }

    /**
     * 将阿拉伯数字转换成中文数字
     * 
     * @param digit
     * @return
     */
    public static String digit2cn(String digit) {
        // 中文数字字典
        final List<String> NUMBER = Arrays.asList("零", "一", "二", "三", "四", "五", "六", "七", "八", "九");
        final List<String> UNIT = Arrays.asList(" ", "万", "亿", "兆");
        final List<String> UNIT_BASE = Arrays.asList("十", "百", "千");

        // 语法规则字典
        Map<String, String> rule = new HashMap<String, String>();
        rule.put("零零", "零");
        rule.put("零十", "零");
        rule.put("零百", "零");
        rule.put("零千", "零");
        rule.put("零兆", "兆");
        rule.put("零亿", "亿");
        rule.put("零万", "万");
        rule.put("兆亿", "兆零");
        rule.put("亿万", "亿零");

        // 校验字符有效性
        if (StringUtils.isBlank(digit) || !digit.matches("-?\\d+")) {
            return "";
        }

        // 处理负号
        String prefix = "";
        if (digit.contains("-")) {
            prefix = "负";
        }
        digit = digit.replaceAll("-", "");

        // 生成纯单位字符串
        String units = "";
        for (int i = digit.length() - 1; i >= 0; i--) {
            if (i % 4 == 0) {
                units += UNIT.get(i / 4);
            } else {
                units += UNIT_BASE.get(i % 4 - 1);
            }
        }

        // 去头部所有0（零除外）
        while (digit.startsWith("0") && digit.length() != 1) {
            digit = digit.substring(1);
            units = units.substring(1);
        }

        // 去末尾所有0（零除外）
        while (digit.endsWith("0") && digit.length() != 1) {
            digit = digit.substring(0, digit.length() - 1);
            units = units.substring(0, units.length() - 1);
        }

        // 拼接数字、单位
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digit.length(); i++) {
            int idx = Integer.valueOf(digit.substring(i, i + 1));
            sb.append(NUMBER.get(idx)).append(units.substring(i, i + 1));
        }
        String cn = StringUtils.trimToEmpty(sb.toString());

        // 根据语法规则处理字符串
        boolean b;
        do {
            // 是否通过语法规则校验
            b = false;
            for (String key : rule.keySet()) {
                if (cn.contains(key)) {
                    b = true;
                    break;
                }
            }
            // 未通过校验，继续替换
            if (b) {
                for (String key : rule.keySet()) {
                    if (cn.contains(key)) {
                        cn = cn.replaceAll(key, rule.get(key));
                    }
                }
            }
        } while (b);

        // 对以“一十”开始的字符串特殊处理
        if (cn.startsWith("一十")) {
            cn = cn.substring(1);
        }

        // 拼接符号
        return prefix + cn;
    }

    /**
     * html->html转义
     * 
     * @param html
     * @return
     */
    public static String htmlEscape(String html) {
        return HtmlUtils.htmlEscape(html);
    }

    /**
     * html转义->html
     * 
     * @param html
     * @return
     */
    public static String htmlUnescape(String html) {
        return HtmlUtils.htmlUnescape(html);
    }

    /**
     * 处理script中引用的字符串，转义特殊字符，防止script编译报错
     * 
     * @param str
     * @return
     */
    public static String scriptEscape(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("\r", "\\r");
        map.put("\n", "\\n");

        for (String key : map.keySet()) {
            str = str.replace(key, map.get(key));
        }

        return htmlEscape(str);
    }

    /**
     * 根据指定时间和间隔计算新时间
     * 
     * @param date 指定时间
     * @param add 时间间隔
     * @param mode 时间间隔单位（天/月/年）
     * @return
     */
    public static String caldate(Date date, int add, int mode) {
        Date result = null;
        switch (mode) {
        case 1: // 时间间隔单位：天
            result = DateUtil.addDays(date, add);
            break;
        case 2: // 时间间隔单位：月
            result = DateUtil.addMonths(date, add);
            break;
        case 3: // 时间间隔单位：年
            result = DateUtil.addYears(date, add);
            break;
        }
        return DateUtil.date2String(result, DateUtil.FORMAT_DATE);
    }

    /**
     * 获取当前日期时间
     * 
     * @return
     */
    public static Date datetime() {
        return new Date(System.currentTimeMillis());
    }
}
