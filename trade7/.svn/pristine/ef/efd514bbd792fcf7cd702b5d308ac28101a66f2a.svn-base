package com.liantuo.trade.common.util.date;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * 
 * @作者 Jimmy
 * @最后修改人
 * @修改时间
 * @复审人
 */
public class DateUtil {

    public static final String DEFAULT_DATE = "yyyy-MM-dd";
    
    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String DEFAULT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static Date formatDate(String date) {
        return format(date, DEFAULT_DATE);
    }

    public static Date formatDateTime(String date) {
        return format(date, DEFAULT_DATE_TIME);
    }

    public static Date format(String date, String pattern) {
        return DateTimeFormat.forPattern(pattern).parseDateTime(date).toDate();
    }
    
    public static String toDateTime(Date date){
        return toString(date, DEFAULT_DATE_TIME);
    }
    
    public static String toDate(Date date){
        return toString(date, DEFAULT_DATE);
    }
    
    public static String toString(Date date, String pattern){
        DateTime dt = new DateTime(date);
        return dt.toString(pattern);
    }
    
}
