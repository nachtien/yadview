package com.google.code.yadview;

public class CreateEventEvent {

    private final long mStartTimeInMillis;
    private final boolean mSelectionAllDay;

    public CreateEventEvent(long startTimeInMillis, boolean selectionAllday) {
        mStartTimeInMillis = startTimeInMillis;
        mSelectionAllDay = selectionAllday;
    }
    
    public long getStartTimeInMillis() {
        return mStartTimeInMillis;
    }
    
    public boolean isSelectionAllDay() {
        return mSelectionAllDay;
    }

}
