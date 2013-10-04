package com.google.code.yadview;

import com.google.common.collect.Lists;

import java.util.List;

public class MockEventResource implements EventResource {

    
    
    
    @Override
    public List<Event> get(int startJulianDay, int numDays, Predicate continueLoading) {
        List<Event> events = Lists.newArrayList();
        
        Event e1 = new Event();
        e1.setAllDay(false);
        e1.setEndDay(startJulianDay);
        e1.setId(1);
        e1.setEndTime(9 * 60);
        e1.setStartDay(startJulianDay);
        e1.setStartTime(8 * 60);

        e1.setTitle("testevent");
        events.add(e1);
        
        return events;
        
    }



}
