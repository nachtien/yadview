
package com.google.gode.yadview_harness;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.text.format.Time;

import com.google.code.yadview.Event;
import com.google.code.yadview.EventResource;
import com.google.code.yadview.Predicate;
import com.google.common.collect.Lists;

public class MockEventResource implements EventResource {

    @Override
    public List<Event> get(int startJulianDay, int numDays, Predicate continueLoading) {
        List<Event> events = Lists.newArrayList();

        Event e1 = new Event();

        e1.setAllDay(false);
        e1.setEndDay(startJulianDay);
        e1.setId(1);
        e1.setEndTime(9 * 60 - 1);
        e1.setStartDay(startJulianDay);
        e1.setStartTime(8 * 60);

        Time scratch = new Time();
        scratch.setJulianDay(startJulianDay);
        scratch.hour = 8;
        scratch.minute = e1.getStartTime() % 60;
        e1.setStartMillis(scratch.toMillis(false));
        scratch.hour = 9;
        scratch.minute = e1.getEndTime() % 60;
        e1.setEndMillis(scratch.toMillis(false));

        e1.setTitle("testevent");
        events.add(e1);

        if (startJulianDay % 2 == 0) {
            e1 = new Event();
            e1.setAllDay(true);
            e1.setEndDay(startJulianDay);
            e1.setId(2);
            e1.setStartDay(startJulianDay);

            e1.setTitle("testevent-allday");
            events.add(e1);
        }
        
        
        if (startJulianDay % 3 == 0) {
            e1 = new Event();
            e1.setAllDay(true);
            e1.setEndDay(startJulianDay);
            e1.setId(2);
            e1.setStartDay(startJulianDay);

            e1.setTitle("testevent2-allday");
            events.add(e1);
        }

        e1 = new Event();
        e1.setAllDay(false);
        e1.setEndDay(startJulianDay);
        e1.setId(3);
        e1.setEndTime(10 * 60 - 1);
        e1.setStartDay(startJulianDay);
        e1.setStartTime(7 * 60);

        scratch.hour = 7;
        scratch.minute = e1.getStartTime() % 60;
        e1.setStartMillis(scratch.toMillis(false));
        scratch.hour = 10;
        scratch.minute = e1.getEndTime() % 60;
        e1.setEndMillis(scratch.toMillis(false));

        e1.setTitle("overlapping");
        events.add(e1);

        e1 = new Event();
        e1.setAllDay(false);
        e1.setEndDay(startJulianDay);
        e1.setId(4);
        e1.setEndTime(11 * 60 + 30 - 1);
        e1.setStartDay(startJulianDay);
        e1.setStartTime(11 * 60);

        scratch.hour = 11;
        scratch.minute = e1.getStartTime() % 60;
        e1.setStartMillis(scratch.toMillis(false));
        scratch.hour = 11;
        scratch.minute = e1.getEndTime() % 60;
        e1.setEndMillis(scratch.toMillis(false));

        e1.setTitle("short");
        events.add(e1);

        e1 = new Event();
        e1.setAllDay(false);
        e1.setEndDay(startJulianDay);
        e1.setId(5);
        e1.setEndTime(12 * 60 + 30 - 1);
        e1.setStartDay(startJulianDay);
        e1.setStartTime(11 * 60 + 30);

        scratch.hour = 11;
        scratch.minute = e1.getStartTime() % 60;
        e1.setStartMillis(scratch.toMillis(false));
        scratch.hour = 12;
        scratch.minute = e1.getEndTime() % 60;
        e1.setEndMillis(scratch.toMillis(false));

        e1.setTitle("adjacent");
        events.add(e1);

        Collections.sort(events, new Comparator<Event>() {

            @Override
            public int compare(Event lhs, Event rhs) {
                long l = lhs.getStartMillis() - rhs.getStartMillis();
                if (l < 0) {
                    return -1;
                } else if (l > 0) {
                    return 1;
                } else
                    return 0;
            }
        });

        return events;

    }

}
