package com.google.code.yadview.util;

public class UtilFactory {
    private String mPrefsName;

    public UtilFactory(String prefsName){
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
