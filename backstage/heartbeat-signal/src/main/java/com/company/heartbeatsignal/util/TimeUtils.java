package com.company.heartbeatsignal.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Liquid
 * @类名： TimeUtils
 * @描述：
 * @date 2019/4/13
 */
public class TimeUtils {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String DD = "dd";

    /**
     * @param
     * @return
     * @throws
     * @author Liquid
     * @描述：
     * @date 2019/5/24
     */
    public static Date getAfterCurrentTime(int number, ChronoUnit chronoUnit) {
        return Date.from(Instant.now().plus(number, chronoUnit));
    }

    /**
     * @param
     * @return
     * @throws
     * @author Liquid
     * @描述：
     * @date 2019/5/24
     */
    public static Date getBeforeCurrentTime(int number, TemporalUnit temporalUnit) {
        return Date.from(Instant.now().minus(number, temporalUnit));
    }


    /**
     * @param
     * @return Date当前日期
     * @描述： 获取当前格式化后的的时间
     * @author Liquid
     * @date 2018/12/26
     */
    public static Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * @param
     * @return Date当前日期
     * @描述： 获取当前格式化后的的时间
     * @author Liquid
     * @date 2018/12/26
     */
    public static long getCurrentTimeMills() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    public static String getCurrentTimeString() {
        return DateFormatUtils.format(Calendar.getInstance().getTime(), YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    public static String getCurrentYearString() {
        return DateFormatUtils.format(Calendar.getInstance().getTime(), YYYY);
    }

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    public static String getCurrentMonthString() {
        return DateFormatUtils.format(Calendar.getInstance().getTime(), MM);
    }

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    public static String getCurrentDayString() {
        return DateFormatUtils.format(Calendar.getInstance().getTime(), DD);
    }

    /**
     * @param
     * @return java.lang.String 时间的字符串
     * @throws null
     * @author Liquid
     * @描述： 获取当前格式化后的的时间的字符串
     * @date 2018/12/30
     */
    public static String getCurrentYMDString() {
        return DateFormatUtils.format(Calendar.getInstance().getTime(), YYYY_MM_DD);
    }

    /**
     * @param date    日期对象
     * @param pattern 日期格式
     * @return java.lang.String 转换后的日期字符串
     * @author Liquid
     * @描述： 根据格式转换Date为日期字符串
     * @date 2018/12/28
     */
    public static String dateFormatToStringByFormat(Date date, String pattern) {
        return DateFormatUtils.format(date, YYYY_MM_DD_HH_MM_SS);
    }



}
