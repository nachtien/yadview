package com.google.gode.yadview_harness;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.widget.ViewSwitcher;

import com.google.code.yadview.DayView;
import com.google.code.yadview.EventResource;
import com.google.code.yadview.impl.DefaultEventResource;
import com.google.code.yadview.impl.DefaultUtilFactory;

public class MainActivity extends Activity  {

    private EventResource mEventResource;
    private YadviewHarnessDayViewFactory mViewFactory;

	public MainActivity() {
//	    mEventResource = new MockEventResource();
	    mEventResource = new DefaultEventResource(this, new DefaultUtilFactory("yadview_harness.prefs"));
		
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewSwitcher vs = (ViewSwitcher)findViewById(R.id.view_switcher);
		mViewFactory = new YadviewHarnessDayViewFactory(vs, mEventResource, this);
		
		vs.setFactory(mViewFactory);
		
		DayView dv = (DayView)vs.getCurrentView();
        Time today = new Time();
        today.setToNow();
        dv.setSelected(today, false, false);
        dv.clearCachedEvents();
        dv.reloadEvents();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mViewFactory.getEventLoader().startBackgroundThread();
		
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mViewFactory.getEventLoader().stopBackgroundThread();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	


}
