package com.google.code.yadview;

import com.google.code.yadview.events.CreateEventEvent;
import com.google.code.yadview.impl.DefaultDayViewResources;
import com.google.code.yadview.impl.DefaultUtilFactory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnLongClickListener;

public class DayViewOnLongClickListener implements OnLongClickListener {

    private Context mContext;
    private DayView mDayView;
    private DayViewResources mDayViewResources;
    private DefaultUtilFactory mUtilFactory;

    public DayViewOnLongClickListener(Context context, DayView dv, DayViewResources resources, DefaultUtilFactory utilFactory) {
        mContext = context;
        mDayView = dv;
        mUtilFactory = utilFactory;
        mDayViewResources = resources;
    }

    @Override
    public boolean onLongClick(View v) {
        int flags = DateUtils.FORMAT_SHOW_WEEKDAY;
        long time = mDayView.getSelectedTimeInMillis();
        if (!mDayView.isSelectionAllday()) {
            flags |= DateUtils.FORMAT_SHOW_TIME;
        }
        if (DateFormat.is24HourFormat(mContext)) {
            flags |= DateUtils.FORMAT_24HOUR;
        }

        new AlertDialog.Builder(mContext).setTitle(mUtilFactory.buildTimezoneUtils().formatDateRange(mContext, time, time,
                flags))
                .setItems(mDayViewResources.getLongPressItems(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            mDayView.getEventBus().post(new CreateEventEvent(mDayView.getSelectedTimeInMillis(), mDayView.isSelectionAllday()));
                        }
                    }
                }).show().setCanceledOnTouchOutside(true);
        return true;
    }

}
