package com.google.code.yadview.events;

import com.google.code.yadview.Event;


public class DeleteEventEvent {

    private Event mEventToDelete;

    
    public DeleteEventEvent(Event selectedEvent) {
        mEventToDelete = selectedEvent;
    }

    public Event getEventToDelete() {
        return mEventToDelete;
    }


}
