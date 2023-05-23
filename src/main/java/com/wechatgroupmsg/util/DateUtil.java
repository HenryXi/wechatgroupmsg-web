package com.wechatgroupmsg.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class DateUtil {

    public static final String FORMAT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String FORMAT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE_TIME_PATERN_WITHOUTBLANK = "yyyyMMddHHmmss";
    public static final String FORMAT_DATE_TIME_PATERN_WITHOUTBLANK02 = "yyyyMMdd";
    public static final String FORMAT_DATE_TIME_PATERN_HHMMSS = "mmss";
    public static final String FORMAT_DATE_PATTERN_YMD = "yyyy年MM月dd日";

    public static String format(Date date, String pattern) {
        if (null == date)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    public static String getTodayStartDay() {
        String todayDate = format(new Date(), DateUtil.FORMAT_DATE_PATTERN);
        return todayDate;
    }

    public static String getYMD() {
        String todayDate = format(new Date(), DateUtil.FORMAT_DATE_PATTERN_YMD);
        return todayDate;
    }

    public static String getTodayStartTime() {
        String todayTime = format(new Date(), DateUtil.FORMAT_DATE_TIME_PATTERN);
        return todayTime;
    }

    public static String getTodayEndTime() {
        String todayStart = format(new Date(), DateUtil.FORMAT_DATE_PATTERN);
        return todayStart + " 23:59:59";
    }

    public static String getFormatDateTimePattern(String str) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE_TIME_PATTERN);
            Date date = sdf.parse(str);
            if (date.toString() != null)
                return str;
            return null;
        } catch (Exception e) {

        }
        return null;
    }

    /*
     * 获取一年前的Date
     */
    public static Date getLastYear() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        return y;
    }

    /**
     * 获取昨天日期0点0时0分的
     *
     * @return
     */
    public static Date getLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /*
     * 将时间戳转换为Date
     */
    public static Date stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        return new Date(lt);
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate2(long s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 根据一个时间字符串解析成日期类
     *
     * @param s      日期的字符串
     * @param patern 将要解析的Date格式表达式
     * @return 返回一个日期类型
     */
    public static Date stringToDate(String s, String patern) {
        try {
            DateFormat fmt = new SimpleDateFormat(patern);
            Date date = fmt.parse(s);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getYMDHMSWithoutBlank() {
        return format(new Date(), DateUtil.FORMAT_DATE_TIME_PATERN_WITHOUTBLANK);
    }

    public static String getYMDWithoutBlank() {
        return format(new Date(), DateUtil.FORMAT_DATE_TIME_PATERN_WITHOUTBLANK02);
    }

    public static String getMSWithoutBlank() {
        return format(new Date(), DateUtil.FORMAT_DATE_TIME_PATERN_HHMMSS);
    }

    public static String getYMDWithChinese() {
        return format(new Date(), "yyyy年MM月dd日");
    }

    public static String addDay(Date date, long day) {
        day = date.getTime() + day * 24 * 60 * 60 * 1000;
        return format(new Date(day), FORMAT_DATE_TIME_PATTERN);
    }

    /**
     * 获取date几个月前或者几个月后
     */
    public static Date calendarMonth(Date date, int mCount) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一个月.整数往后推,负数往前移动
        calendar.add(Calendar.MONTH, mCount);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取date几天前或者几天后
     */
    public static Date calendarDay(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一个月.整数往后推,负数往前移动
        calendar.add(Calendar.DATE, day);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取某个时间点前后间隔几天的时间
     * day可以是负数，也可以是正数
     *
     * @param date
     * @param day
     * @return
     */
    public static Long intervalTime(Date date, int day) {
        long interval = day * 24 * 60 * 60 * 1000;
        long nowTime = date.getTime();

        return nowTime + interval;
    }

    /**
     * 获取某个时间点前后间隔几天的时间
     * day可以是负数，也可以是正数
     *
     * @param nowTime
     * @param day
     * @return
     */
    public static Long intervalTime(long nowTime, int day) {
        long interval = day * 24 * 60 * 60 * 1000;
        return nowTime + interval;
    }

    /**
     * 计算两个时间相隔的天数
     */
    public static final int daysBetween(long beginTs, long endTs) {
        //得到两个日期相差的天数
        int days = ((int) (endTs / 1000) - (int) (beginTs / 1000)) / 3600 / 24;

        return days;
    }

    /**
     * 将时间戳转换成YMD形式的字符串
     *
     * @param time
     * @return
     */
    public static final String getYMD(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE_PATTERN);
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    /**
     * 将时间戳转化成YMDHMS形式的字符串
     *
     * @param time
     * @return
     */
    public static final String getYMDHMS(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_PATTERN);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    /**
     * 将字符串日期（yyyyMMdd）转换为时间戳
     *
     * @param dateStr
     * @return
     */
    public static long date2Timestamp(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME_PATERN_WITHOUTBLANK02);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 将字符串日期（yyyy-MM-dd HH:mm:ss）转换为时间戳
     *
     * @param dateStr
     * @return
     */
    public static long date2Timestamp2(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME_PATTERN);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
