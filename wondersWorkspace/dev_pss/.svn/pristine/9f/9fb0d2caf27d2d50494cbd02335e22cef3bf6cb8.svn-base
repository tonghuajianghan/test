package com.wondersgroup.core.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

/**
 * 日期处理工具。
 * <p>
 * 相关的日期处理工具类为org.apache.commons.lang.time.DateFormatUtils
 * 
 * @since 1.0.0
 */

public class DateUtil {

    /** 默认日期格式 */
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    /** 日期格式：中文日期 */
    public static final String FORMAT_CHINA_DATE = "yyyy年M月d日";

    /** 日期格式2 */
    public static final String FORMAT_DATE_MIN = "yyyyMMdd";

    /** 默认时间格式 */
    public static final String FORMAT_TIME = "HH:mm:ss";

    /** 默认日期时间格式 */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /** 星期的中文显示格式 */
    public static String[] WEEK_CHINESE = new String[] { "日", "一", "二", "三", "四", "五", "六" };

    /** 日志 */
    private static Logger logger = Logger.getLogger(DateUtil.class);

    /**
     * 将日期转换成字符格式
     * 
     * @param date java.util.Date类型
     * @param format 如果为null或""，默认为DATE格式
     * @return 无法成功转换则返回null
     */
    public static String date2String(java.util.Date date, String format) {
        String result = "";
        if (date == null) {
            return result;
        }
        if (StringUtils.isEmpty(format)) {
            format = FORMAT_DATE;
        }
        try {
            result = DateFormatUtils.format(date, format);
        } catch (Exception ex) {
            logger.warn("日期转换为字符串错误，日期：" + date.toString() + "， 格式：" + format);
        }

        return result;
    }

    /**
     * 将字符串转换成日期格式
     * 
     * @param str 需要转换的字符串
     * @param format 相应的转换格式，如果参数为Blank则表示按常规的三种格式转换
     * @return 如果不能正常转换则返回null
     */
    public static java.util.Date string2Date(String str, String format) {
        if (StringUtils.isEmpty(str) || "0".equals(StringUtils.trimToEmpty(str))) {
            return null;
        }

        Date result = null;
        String[] formats = null;
        if (StringUtils.isEmpty(format)) {
            formats = new String[3];
            formats[0] = FORMAT_DATETIME;
            formats[1] = FORMAT_DATE;
            formats[2] = FORMAT_TIME;
        } else {
            formats = new String[4];
            formats[0] = format;
            formats[1] = FORMAT_DATETIME;
            formats[2] = FORMAT_DATE;
            formats[3] = FORMAT_TIME;
        }
        try {
            result = DateUtils.parseDate(str, formats);
        } catch (Exception ex) {
            logger.warn("日期或时间格式不正确，日期时间字符串：" + str + "， 格式：" + format);

        }

        return result;
    }

    /**
     * 将字符串转换成sql日期格式
     * 
     * @param str 需要转换的字符串
     * @param format 相应的转换格式，如果参数为Blank则表示按常规的三种格式转换
     * @return 如果不能正常转换则返回null
     */
    public static java.sql.Date string2SqlDate(String str, String format) {
        return new java.sql.Date(string2Date(str, format).getTime());
    }

    /**
     * 将时间戳转换成字符串格式
     * 
     * @param ts 时间戳
     * @param format 日期时间格式
     * @return 转换后的字符串
     */
    public static String timestamp2String(Timestamp ts, String format) {
        return ts == null ? null : date2String(new java.util.Date(ts.getTime()), format);
    }

    /**
     * 将字符串转换成时间戳格式
     * 
     * @param str 需要转换的字符串
     * @param format 相应的转换格式，如果参数为Blank则表示按常规的三种格式转换
     * @return 如果不能正常转换则返回null
     * @throws Exception
     */
    public static Timestamp string2Timestamp(String str, String format) {
        return string2Date(str, format) == null ? null : new Timestamp(string2Date(str, format).getTime());
    }

    /**
     * 得到时间的年
     * 
     * @param date
     * @return int
     */
    public static int getYear(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 得到传入时间的月份
     * 
     * @param date
     * @return
     */
    public static int getMonth(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 得到传入时间的天
     * 
     * @param date
     * @return
     */
    public static int getDay(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * 得到传入时间的季度
     * 
     * @param date
     * @return
     */
    public static int getQuarter(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int quarter = 0;
        switch (month) {
        case 0:
        case 1:
        case 2:
            quarter = 1;
            break;
        case 3:
        case 4:
        case 5:
            quarter = 2;
            break;
        case 6:
        case 7:
        case 8:
            quarter = 3;
            break;
        case 9:
        case 10:
        case 11:
            quarter = 4;
            break;
        }
        return quarter;
    }

    /**
     * 添加年。
     * 
     * @param date 日期
     * @param num 添加的年数
     * @return 添加后的日期
     */
    public static java.util.Date addYears(java.util.Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, num);
        return cal.getTime();
    }

    /**
     * 添加月份。
     * 
     * @param date 日期
     * @param num 添加对月数
     * @return 添加后的日期
     */
    public static java.util.Date addMonths(java.util.Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, num);
        return cal.getTime();
    }

    /**
     * 添加天数。
     * 
     * @param date 日期
     * @param num 添加的天数
     * @return 添加后的日期
     */
    public static java.util.Date addDays(java.util.Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, num);
        return cal.getTime();
    }

    /**
     * 得到当年第一天的开始时间。
     * 
     * @param date 日期
     * @return 当年第一天的开始时间
     */
    public static java.util.Date getFirstDateOfYear(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到当月第一天的开始时间。
     * 
     * @param date 日期
     * @return 当月第一天的开始时间
     */
    public static java.util.Date getFirstDateOfMonth(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到当年的最后一天最后一秒。
     * 
     * @param date 日期
     * @return 当年最后一天最后一秒
     */
    public static java.util.Date getLastDateOfYear(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 得到当月的最后一天最后一秒。
     * 
     * @param date 日期
     * @return 当月最后一天最后一秒
     */
    public static java.util.Date getLastDateOfMonth(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 得到该日期的最后时间，精确到秒（即23：59：59）
     * 
     * @param dateStr
     * @return
     */
    public static java.util.Date getLastSecondOfDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        dateStr = dateStr.trim();
        String convertedDateStr = new StringBuffer(dateStr).append(" 23:59:59").toString();
        return string2Date(convertedDateStr, FORMAT_DATETIME);
    }

    /**
     * 计算两个日期之间的天数
     * 
     * @param time1 时间一 起始时间
     * @param time2 时间二 结束时间
     * @return
     */
    public static long calDaysBetweenDate(String time1, String time2) {
        long days = 0;
        SimpleDateFormat ft = new SimpleDateFormat(FORMAT_DATE);

        Date date1;
        try {
            date1 = ft.parse(time1);

            Date date2 = ft.parse(time2);
            days = date2.getTime() - date1.getTime();
            days = days / 1000 / 60 / 60 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 比较是否在同一年同一月内的同一周
     * 
     * @param date
     * @param date2
     * @return
     */
    public static boolean isSameWeek(java.util.Date date, java.util.Date date2) {
        return getWeekInMonth(date) == getWeekInMonth(date2) && isSameYear(date, date2) && isSameMonth(date, date2);
    }

    /**
     * 比较两个日期是偶同年同月同日
     * 
     * @param date
     * @param date2
     * @return
     */
    public static boolean isSameDay(java.util.Date date, java.util.Date date2) {
        return isSameYear(date, date2) && isSameMonth(date, date2) && getDay(date) == getDay(date2);
    }

    /**
     * 比较两个日期是否同年同月
     */
    public static boolean isSameMonth(java.util.Date date, java.util.Date date2) {
        return isSameYear(date, date2) && getMonth(date) == getMonth(date2);
    }

    /**
     * 比较两个日期是否是在同一年度的同一季度内
     * 
     * @param date
     * @param date2
     * @return
     */
    public static boolean isSameQuarter(java.util.Date date, java.util.Date date2) {
        return getQuarter(date) == getQuarter(date2) && isSameYear(date, date2);
    }

    /**
     * 比较两个日期是否属于同一年度
     * 
     * @param date
     * @param date2
     * @return
     */
    public static boolean isSameYear(java.util.Date date, java.util.Date date2) {
        return getYear(date) == getYear(date2);
    }

    /**
     * 在月内的第几周
     * 
     * @param date
     * @return
     */
    public static int getWeekInMonth(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date == null ? new Date() : date);
        int week = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        return week;
    }

    /**
     * 星期几
     * 
     * @param date
     * @return
     */
    public static int getWeekday(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date == null ? new Date() : date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        return week;
    }
}
