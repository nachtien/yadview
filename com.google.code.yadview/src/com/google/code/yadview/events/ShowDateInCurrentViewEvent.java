package com.google.code.yadview.events;

import android.text.format.Time;

public class ShowDateInCurrentViewEvent  {

    private Time mShowDate;
    private Time mShowTime;

    public ShowDateInCurrentViewEvent(Time date, Time time) {
        mShowDate = date;
        mShowTime = time;

    }
    
    public Time getShowDate() {
        return mShowDate;
    }

    public Time getShowTime() {
        return mShowTime;
    }

}
