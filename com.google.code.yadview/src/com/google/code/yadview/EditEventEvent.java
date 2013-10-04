package com.google.code.yadview;


public class EditEventEvent {

    private Event mEvent;

    public EditEventEvent(Event event) {
        mEvent = event;
    }
    
    public Event getEvent() {
        return mEvent;
    }

}
