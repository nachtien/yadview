package com.google.gode.yadview_harness;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

import com.google.code.yadview.DayView;
import com.google.code.yadview.MockEventResource;
import com.google.code.yadview.ViewEventEvent;
import com.google.code.yadview.impl.DefaultDayViewModel;
import com.google.code.yadview.impl.DefaultDayViewResources;
import com.google.code.yadview.impl.DefaultEventLoader;
import com.google.code.yadview.impl.DefaultUtilFactory;
import com.google.common.eventbus.Subscribe;

public class MainActivity extends Activity implements ViewFactory {

	private DefaultEventLoader mEventLoader;

	public MainActivity() {
		mEventLoader = new DefaultEventLoader(new MockEventResource());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		ViewSwitcher vs = (ViewSwitcher)findViewById(R.id.view_switcher);
		
		vs.setFactory(this);
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		mEventLoader.startBackgroundThread();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mEventLoader.stopBackgroundThread();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public View makeView() {
		ViewSwitcher vs = (ViewSwitcher)findViewById(R.id.view_switcher);
		DayView dv = new DayView(this, new DefaultDayViewModel(), vs, mEventLoader, 1, new DefaultUtilFactory("yadview_harness.prefs"), new DefaultDayViewResources(this));
		
		
		dv.getEventBus().register(this);
		
        dv.setLayoutParams(new ViewSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        
        Time today = new Time();
        today.setToNow();
        dv.setSelected(today, false, false);
        dv.clearCachedEvents();
        dv.reloadEvents();
        
		return dv;
	}
	


}
