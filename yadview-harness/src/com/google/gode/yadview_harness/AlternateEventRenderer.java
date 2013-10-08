
package com.google.gode.yadview_harness;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.code.yadview.DayViewResources;
import com.google.code.yadview.EventLayout;
import com.google.code.yadview.EventRenderer;
import com.google.code.yadview.impl.DefaultUtilFactory;

public class AlternateEventRenderer extends EventRenderer {

    private Context mContext;
    private DayViewResources mDayViewResources;
    private View mTemplateView;
    private TextView mEventTitle;
    private View mEventColourPanel;

    public AlternateEventRenderer(Context ctx, DayViewResources dayViewResources,
            DefaultUtilFactory utilFactory) {
        super(dayViewResources, utilFactory);
        mDayViewResources = dayViewResources;
        mContext = ctx;
        
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mTemplateView = inflater.inflate(R.layout.event_template, null, false);
        
        
        mEventTitle = (TextView)mTemplateView.findViewById(R.id.eventTitle);
        mEventColourPanel = mTemplateView.findViewById(R.id.eventColourPanel);
    }

    @Override
    public void drawEvent(EventLayout event, Canvas canvas, Paint p,
            Paint eventTextPaint, int visibleTop, int visibleBot,
            boolean isSelectedEvent, boolean drawSelectedEvent) {
        
        canvas.save();
        canvas.translate(event.getLeft(), event.getTop());


        
        Rect r = new Rect();
        r.top = Math.max((int) event.getTop() + mDayViewResources.getEVENT_RECT_TOP_MARGIN(), visibleTop);
        r.bottom = Math.min((int) event.getBottom() - mDayViewResources.getEVENT_RECT_BOTTOM_MARGIN(), visibleBot);
        r.left = (int) event.getLeft() + mDayViewResources.getEVENT_RECT_LEFT_MARGIN();
        r.right = (int) event.getRight();

        mTemplateView.measure(MeasureSpec.makeMeasureSpec((int)(event.getRight() - event.getLeft()), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec((int)(event.getBottom() - event.getTop()), MeasureSpec.EXACTLY));
        LinearLayout ll = (LinearLayout)mTemplateView;
        
        ll.layout(0,0,0,0);
        mEventTitle.setText(event.getEvent().getTitle());
        mEventColourPanel.setBackgroundColor(Color.BLACK | event.getEvent().getColor());

        
        
        mTemplateView.draw(canvas);
        
        canvas.restore();
        

    }

}
