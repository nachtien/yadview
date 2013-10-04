package com.google.code.yadview.impl;

import com.google.code.yadview.util.CalendarDateUtils;
import com.google.code.yadview.util.EventRenderingUtils;
import com.google.code.yadview.util.PreferencesUtils;
import com.google.code.yadview.util.TimeZoneUtils;

public class DefaultUtilFactory {
    private String mPrefsName;

    public DefaultUtilFactory(String prefsName){
        mPrefsName = prefsName;
    }
    
    public TimeZoneUtils buildTimezoneUtils(){
        return new TimeZoneUtils(mPrefsName);
    }

    public PreferencesUtils buildPreferencesUtils() {
        return new PreferencesUtils(mPrefsName);
    }

    public CalendarDateUtils buildDateUtils() {
        return new CalendarDateUtils(buildPreferencesUtils());
    }

    public EventRenderingUtils buildRenderingUtils() {
        return new EventRenderingUtils();
    }
}
