package com.google.code.yadview;


public class DeleteEventEvent {

    private Event mEventToDelete;

    
    public DeleteEventEvent(Event selectedEvent) {
        mEventToDelete = selectedEvent;
    }

    public Event getEventToDelete() {
        return mEventToDelete;
    }


}
