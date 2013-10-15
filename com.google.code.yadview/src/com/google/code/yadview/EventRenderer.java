package com.google.code.yadview;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface EventRenderer {

    public abstract void prepareForEvents(ArrayList<Event> events);

    public abstract void drawEvent(EventLayout event, Canvas canvas, Paint p, Paint eventTextPaint, int visibleTop, int visibleBot, boolean isSelectedEvent, boolean drawSelectedEvent);

}
