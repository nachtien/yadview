package com.google.code.yadview.util;

public class EventRenderingUtils {
  public static final int DECLINED_EVENT_ALPHA = 0x66;
  public static final int DECLINED_EVENT_TEXT_ALPHA = 0xC0;

    
    
    public int getDeclinedEventTextAlpha() {
        return DECLINED_EVENT_TEXT_ALPHA;
    }


    // This takes a color and computes what it would look like blended with
    // white. The result is the color that should be used for declined events.
    public int getDeclinedColorFromColor(int color) {
        int bg = 0xffffffff;
        int a = DECLINED_EVENT_ALPHA;
        int r = (((color & 0x00ff0000) * a) + ((bg & 0x00ff0000) * (0xff - a))) & 0xff000000;
        int g = (((color & 0x0000ff00) * a) + ((bg & 0x0000ff00) * (0xff - a))) & 0x00ff0000;
        int b = (((color & 0x000000ff) * a) + ((bg & 0x000000ff) * (0xff - a))) & 0x0000ff00;
        return (0xff000000) | ((r | g | b) >> 8);
    }

}
