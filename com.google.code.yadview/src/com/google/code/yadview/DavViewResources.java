package com.google.code.yadview;

import android.graphics.drawable.Drawable;

public interface DavViewResources {
//    public String getNoTitleEventTitle();
//    public int getNoColourEventColour();
    public String[] get12HoursNoAmPm();
    public String[] get24Hours();
    public abstract int getEventAlldayTextRightMargin();
    public abstract int getEventAllDayTextLeftMargin();
    public abstract int getEventTextRightMargin();
    public abstract int getEventTextLeftMargin();
    public abstract int getDayHeaderFontSize();
    public abstract int getEventAllDayTextBottomMargin();
    public abstract int getEventAllDayTextTopMargin();
    public abstract int getEventTextBottomMargin();
    public abstract int getEventTextTopMargin();
    public abstract float getMinUnexpandedAllDayEventHeight();
    
    // smallest height to draw an event with
    public abstract float getMinEventHeight();
    
    // sizing for "box +n" in allDay events
    public abstract int getNewEventHintTextFontSize();
    
    /**
     * The height of the day names/numbers for multi-day views
     */
    public abstract int getMultiDayHeaderHeight();
    
    public abstract int getHoursRightMargin();
    public abstract int getHoursLeftMargin();
    public abstract int getMinHoursWidth();
    public abstract int getAMPMTextSize();
    public abstract int getHoursTextSize();
    
    // margins and sizing for the expand allday icon
    public abstract int getExpandAllDayBottomMargin();
    public abstract int getDayHeaderBottomMargin();
    
    /**
     * The height of the day names/numbers when viewing a single day
     */
    public abstract int getOneDayHeaderHeight();
    public abstract int getDateHeaderFontSize();
    public abstract String getNewEventHintString();
    public abstract String getCreateNewEventString();
    public abstract int getHoursMargin();
    public abstract int getEventTextFontSize(int numDays);
    public abstract int getDayHeaderHeight(int numDays);
    public abstract CharSequence[] getLongPressItems();
    public abstract Drawable getAcceptedOrTentativeEventBoxDrawable();
    public abstract int getNewEventHintColor();
    public abstract Drawable getCollapseAlldayDrawable();
    public abstract Drawable getExpandAlldayDrawable();
    public abstract Drawable getTodayHeaderDrawable();
    public abstract Drawable getCurrentTimeAnimateLine();
    public abstract Drawable getCurrentTimeLine();
    public abstract int getMoreEventsTextColor();
    public abstract int getEventTextColor();
    public abstract int getClickedColor();
    public abstract int getPressedColor();
    public abstract int getCalendarHourLabelColor();
    public abstract int getCalendarGridLineInnerVerticalColor();
    public abstract int getCalendarGridLineInnerHorizontalColor();
    public abstract int getCalendarGridAreaSelected();
    public abstract int getCalendarAmPmLabel();
    public abstract int getBgColor();
    public abstract int getFutureBgColorRes();
    public abstract int getCalendarDateBannerTextColor();
    public abstract int getWeekSundayColor();
    public abstract int getWeekSaturdayColor();
    public abstract String getEventCountTemplate();
    public abstract int getGridLineColor();
    public int getEventPopupViewLayoutID();
    public String getMoreEventsMonthText(int remainingEvents);
    public CharSequence getViewEventMenuItemLabel();
    public CharSequence getEditEventMenuItemLabel();
    public CharSequence getDeleteEventMenuItemLabel();
    public CharSequence getCreateEventMenuItemLabel();
    public CharSequence getShowDayViewMenuItemLabel();
    
    
    public void resetDisplayDensity();
    public abstract int getNEW_EVENT_MAX_LENGTH();
    public abstract int getNEW_EVENT_WIDTH();
    public abstract int getNEW_EVENT_MARGIN();
    public abstract int getEVENT_LINE_PADDING();
    public abstract int getEVENT_SQUARE_WIDTH();
    public abstract int getALL_DAY_EVENT_RECT_BOTTOM_MARGIN();
    public abstract int getEVENT_RECT_STROKE_WIDTH();
    public abstract int getEVENT_RECT_RIGHT_MARGIN();
    public abstract int getEVENT_RECT_LEFT_MARGIN();
    public abstract int getEVENT_RECT_BOTTOM_MARGIN();
    public abstract int getEVENT_RECT_TOP_MARGIN();
    public abstract int getCALENDAR_COLOR_SQUARE_SIZE();
    public abstract int getDAY_HEADER_RIGHT_MARGIN();
    public abstract int getDAY_HEADER_ONE_DAY_BOTTOM_MARGIN();
    public abstract int getDAY_HEADER_ONE_DAY_RIGHT_MARGIN();
    public abstract int getDAY_HEADER_ONE_DAY_LEFT_MARGIN();
    public abstract int getDAY_HEADER_HEIGHT();
    public abstract int getMIN_Y_SPAN();
    public abstract int getMAX_CELL_HEIGHT();
    public abstract int getDEFAULT_CELL_HEIGHT();
    public abstract int getCURRENT_TIME_LINE_TOP_OFFSET();
    public abstract int getCURRENT_TIME_LINE_SIDE_BUFFER();
    public abstract int getMIN_CELL_WIDTH_FOR_TEXT();
    public abstract int getHOURS_TOP_MARGIN();
    public abstract float getGRID_LINE_LEFT_MARGIN();
    public abstract float getNORMAL_FONT_SIZE();
    public abstract int getMAX_HEIGHT_OF_ONE_ALLDAY_EVENT();
    public abstract int getALLDAY_TOP_MARGIN();
    public abstract int getSingleAlldayHeight();
    
    /**
     * This is how big the unexpanded allday height is allowed to be. It will
     * get adjusted based on screen size
     */
    public abstract int getMAX_UNEXPANDED_ALLDAY_HEIGHT();
    public int getEventPopupTimeTextFieldID();
    public int getEventPopupEventWhereTextFieldID();
    public int getEventPopupTitleTextFieldID();
    public int getEventPopupReminderIconID();
    public int getEventPopupRepeatIconID();
}
