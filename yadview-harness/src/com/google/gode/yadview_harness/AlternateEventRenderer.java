
package com.google.gode.yadview_harness;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.code.yadview.DayViewResources;
import com.google.code.yadview.EventLayout;
import com.google.code.yadview.EventRenderer;
import com.google.code.yadview.impl.DefaultDayViewResources;
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


        

        int width = (int)(event.getRight() - event.getLeft());
        int height = (int)(event.getBottom() - event.getTop());
        mTemplateView.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
        LinearLayout ll = (LinearLayout)mTemplateView;
        
        ll.layout(0,0,0,0);
        mEventTitle.setText(event.getEvent().getTitle());
        mEventColourPanel.setBackgroundColor(Color.BLACK | event.getEvent().getColor());

        
        mTemplateView.draw(canvas);
        
        
        if(isSelectedEvent){
            //we have already translated
            Rect r = new Rect();
            r.top = 0;
            r.bottom = height;
            r.left = 0;
            r.right = width;

            
            Paint p2 = new Paint(p);
            int color = mDayViewResources.getClickedColor();
            p2.setStrokeWidth(mDayViewResources.getEVENT_RECT_STROKE_WIDTH());
            p2.setColor(color);
            p2.setStyle(Style.FILL);
            p2.setAlpha(75);
            canvas.drawRect(r, p2);
        }
        
        canvas.restore();
    }
    
    
    
    public static class AlternateRendererDayViewResources extends DefaultDayViewResources {

        public AlternateRendererDayViewResources(Context ctx) {
            super(ctx);
        }

        @Override
        public float getMinEventHeight() {
            return 150;
        }
        
        @Override
        public int getSingleAlldayHeight() {
            return 150;
        }

        @Override
        public int getMAX_UNEXPANDED_ALLDAY_HEIGHT() {
            return getSingleAlldayHeight() * 2;
        }
        
        @Override
        public float getMinUnexpandedAllDayEventHeight() {
            return getSingleAlldayHeight();
        }
        
        @Override
        public int getMAX_HEIGHT_OF_ONE_ALLDAY_EVENT() {
            return getSingleAlldayHeight();
        }
        
        
    }
    


}
