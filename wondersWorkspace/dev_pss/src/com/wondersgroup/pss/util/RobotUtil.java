package com.wondersgroup.pss.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 智能机器人工具类
 * 
 * @author jianghan
 */
public class RobotUtil {
    /**
     * 智能分词
     * 
     * @param keywords
     * @return
     */
    public static List<String> splitKeyword(String keywords) {
        if (StringUtils.isBlank(keywords)) {
            return null;
        }

        List<String> result = new ArrayList<String>();

        if (keywords.contains(" ")) {
            for (String kwds : keywords.split(" ")) {
                result.addAll(splitKeyword(kwds));
            }
        }

        List<String> situation1 = new ArrayList<String>();
        situation1.add("是什么");
        situation1.add("有什么用");
        situation1.add("怎么用");
        situation1.add("怎么使用");
        situation1.add("如何用");
        situation1.add("如何使用");

        for (String s : situation1) {
            if (keywords.contains(s)) {
                result.add(keywords.substring(0, keywords.indexOf(s)));
            }
        }

        List<String> situation2 = new ArrayList<String>();
        situation2.add("什么是");
        situation2.add("怎么用");
        situation2.add("怎么使用");
        situation2.add("如何用");
        situation2.add("如何使用");

        for (String s : situation2) {
            if (keywords.contains(s)) {
                result.add(keywords.substring(keywords.indexOf(s)).replaceFirst(s, ""));
            }
        }

        result.add(keywords);

        return result;
    }
}
