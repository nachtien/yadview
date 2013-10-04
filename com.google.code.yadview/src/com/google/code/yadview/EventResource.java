package com.google.code.yadview;


import java.util.List;

public interface EventResource {
    List<Event> get(int startJulianDay, int numDays,Predicate continueLoading);

}

