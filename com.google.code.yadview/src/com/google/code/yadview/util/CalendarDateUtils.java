package com.google.code.yadview.util;

import java.util.Calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.format.Time;

public class CalendarDateUtils {

    public static final String KEY_WEEK_START_DAY = "preferences_week_start_day";
    public static final String WEEK_START_DEFAULT = "-1";
    private PreferencesUtils mPrefUtils;

    public CalendarDateUtils(PreferencesUtils prefUtils){
        mPrefUtils = prefUtils;
    }
    
    public boolean isSaturday(int dayOfWeek, int firstDayOfWeek) {
        return (firstDayOfWeek == Time.SUNDAY && dayOfWeek == 6)
                || (firstDayOfWeek == Time.MONDAY && dayOfWeek == 5)
                || (firstDayOfWeek == Time.SATURDAY && dayOfWeek == 0);
    }

    public boolean isSunday(int dayOfWeek, int firstDayOfWeek) {
        return (firstDayOfWeek == Time.SUNDAY && dayOfWeek == 0)
                || (firstDayOfWeek == Time.MONDAY &&dayOfWeek == 6)
                || (firstDayOfWeek == Time.SATURDAY && dayOfWeek == 1);

    }

    public int getFirstDayOfWeek(Context context) {
        SharedPreferences prefs = mPrefUtils.getSharedPreferences(context);
        String pref = prefs.getString(KEY_WEEK_START_DAY, WEEK_START_DEFAULT);

        int startDay;
        if (WEEK_START_DEFAULT.equals(pref)) {
            startDay = Calendar.getInstance().getFirstDayOfWeek();
        } else {
            startDay = Integer.parseInt(pref);
        }

        if (startDay == Calendar.SATURDAY) {
            return Time.SATURDAY;
        } else if (startDay == Calendar.MONDAY) {
            return Time.MONDAY;
        } else {
            return Time.SUNDAY;
        }
    }

}
