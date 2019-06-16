package com.mx.petshop.sys.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mxwbq on 2019/6/16.
 */
public class DateUtil {
    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

    public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String formatFullTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_PATTERN);
    }

    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }
}
