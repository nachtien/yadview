package com.google.code.yadview.events;

import android.text.format.Time;

public class UpdateTitleEvent {

    private final Time mStartTime;
    private final Time mEndTime;
    private final int mNumDaysDisplayed;

    public UpdateTitleEvent(Time start, Time end, int numDays) {
        mStartTime = start;
        mEndTime = end;
        mNumDaysDisplayed = numDays;
        
    }
    
    public Time getEndTime() {
        return mEndTime;
    }
    
    public Time getStartTime() {
        return mStartTime;
    }
    
    public int getNumDaysDisplayed() {
        return mNumDaysDisplayed;
    }
    

}
