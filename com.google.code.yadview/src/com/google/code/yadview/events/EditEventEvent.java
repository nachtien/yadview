package com.google.code.yadview.events;

import com.google.code.yadview.Event;


public class EditEventEvent {

    private Event mEvent;

    public EditEventEvent(Event event) {
        mEvent = event;
    }
    
    public Event getEvent() {
        return mEvent;
    }

}
