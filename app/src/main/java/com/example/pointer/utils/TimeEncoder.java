package com.example.pointer.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeEncoder {
    public static Long dateToInt(Date date) {
        return date.getTime();
    }

    public static Date intToDate(Long time) {
        Date date = new Date();
        date.setTime(time);

        return date;
    }

    public static String dateToStr(Date date, String pattern) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String dateToStr(Long time, String pattern) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(intToDate(time));
    }
}

