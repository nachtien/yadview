package com.google.code.yadview.events;

import android.text.format.Time;

public class ShowDateInDayViewEvent {

    private Time mSelectedTime;

    public ShowDateInDayViewEvent(Time selectedTime) {
        mSelectedTime = selectedTime;
    }
    
    public Time getSelectedTime() {
        return mSelectedTime;
    };
    


}
