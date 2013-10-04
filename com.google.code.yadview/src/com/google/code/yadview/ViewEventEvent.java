package com.google.code.yadview;


public class ViewEventEvent {

    private final Event mEvent;
    private long mSelectedTimeInMillis;

    public ViewEventEvent(Event event, long selectedTimeInMillis) {
        mEvent = event;
        mSelectedTimeInMillis = selectedTimeInMillis;
    }
    
     public Event getEvent() {
        return mEvent;
    }
     
     public long getSelectedTimeInMillis() {
        return mSelectedTimeInMillis;
    }

}
