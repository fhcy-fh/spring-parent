package com.fhcy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    /**
     * 年-月-日 时:分:秒 时间格式正则匹配表达式
     */
    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$");
    /**
     * 年-月-日 时:分:秒 时间格式
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年-月-日 时:分 时间格式正则匹配表达式
     */
    private static final Pattern DATE_TIME_MINUTE_PATTERN = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}$");

    private static final Pattern DATE_TIME_SLASH_PATTERN = Pattern.compile("^[0-9]{4}/[0-9]{2}/[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$");

    public static final String DATE_TIME_SLASH_FORMAT = "yyyy/MM/dd HH:mm:ss";

    /**
     * 年-月-日 时:分 时间格式
     */
    public static final String DATE_TIME_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    /**
     * 年-月-日 时间格式正则匹配表达式
     */
    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
    /**
     * 年-月-日 时间格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 年月日 时间格式正则匹配表达式
     */
    private static final Pattern DATE_PATTERN_NO_SPACER = Pattern.compile("^[0-9]{4}[0-9]{2}[0-9]{2}$");
    /**
     * 年月日 时间格式
     */
    public static final String DATE_FORMAT_NO_SPACER = "yyyyMMdd";

    public static final Map<Pattern, String> SUPPORT_FORMAT_MAP = new ConcurrentHashMap<>();

    static {
        SUPPORT_FORMAT_MAP.put(DATE_TIME_PATTERN, DATE_TIME_FORMAT);
        SUPPORT_FORMAT_MAP.put(DATE_TIME_SLASH_PATTERN, DATE_TIME_SLASH_FORMAT);
        SUPPORT_FORMAT_MAP.put(DATE_TIME_MINUTE_PATTERN, DATE_TIME_MINUTE_FORMAT);
        SUPPORT_FORMAT_MAP.put(DATE_PATTERN, DATE_FORMAT);
        SUPPORT_FORMAT_MAP.put(DATE_PATTERN_NO_SPACER, DATE_FORMAT_NO_SPACER);
    }

    /**
     * 获取当前时间时间戳
     */
    public static long nowTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 根据时间字符串解析成Date对象，该方法会自适应时间字符串格式
     *
     * @param dateText 时间字符串
     */
    public static Date parse(String dateText) {
        return DateUtils.convert(dateText);
    }

    private static Date convert(String dateString) {
        Date date = null;
        try {
            for (Pattern pattern : SUPPORT_FORMAT_MAP.keySet()) {
                Matcher matcher = pattern.matcher(dateString);
                if (matcher.matches()) {
                    date = new SimpleDateFormat(SUPPORT_FORMAT_MAP.get(pattern)).parse(dateString);
                    break;
                }
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
    }
}
