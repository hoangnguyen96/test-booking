package com.spring.booking.more;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 4/28/2017.
 */
public class DateFormat {
    private static SimpleDateFormat dateFormatSQL= new SimpleDateFormat("MM/dd/yyyy");

    private static SimpleDateFormat dateFormatMySQL= new SimpleDateFormat("yyyy/MM/dd");

    private static SimpleDateFormat dateMySQL= new SimpleDateFormat("yyyy-MM-dd");

    private static Date date= null;

    public static Date stringToDate(String dateStr){
        try {
            date= dateFormatSQL.parse(dateStr);
            dateFormatMySQL.format(date);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static Date parseDateMySql(Date date){
        dateFormatMySQL.format(date);
        return date;
    }

    public static Date parseDateStrToDate(String dateStr){
        try {
            return dateMySQL.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseDateToStringMySQL(String dateStr){
        try {
            date= dateFormatSQL.parse(dateStr);
            return dateMySQL.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDateToString(String dateStr){
        try {
            date= dateMySQL.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
