package com.google.code.yadview;

import android.text.format.Time;

public class ShowDateInAgendaViewEvent  {

    private Time mSelectedTime;

    public ShowDateInAgendaViewEvent(Time selectedTime) {
        mSelectedTime = selectedTime;
    }
    
    public Time getSelectedTime() {
        return mSelectedTime;
    }

}
