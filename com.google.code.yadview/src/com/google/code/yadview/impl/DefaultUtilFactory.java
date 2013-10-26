/*
Copyright 2013 Chris Pope

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 
 */


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
