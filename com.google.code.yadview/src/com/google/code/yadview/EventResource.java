package com.google.code.yadview;


import java.util.List;

public interface EventResource {
    
    public static final int ACCESS_LEVEL_NONE = 0;
    public static final int ACCESS_LEVEL_DELETE = 1;
    public static final int ACCESS_LEVEL_EDIT = 2;

    
    List<Event> get(int startJulianDay, int numDays,Predicate continueLoading);

    public int getEventAccessLevel(Event e);
    
    
    

    
}

