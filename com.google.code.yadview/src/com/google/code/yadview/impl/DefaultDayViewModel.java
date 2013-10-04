package com.google.code.yadview.impl;

import android.text.format.Time;

import com.google.code.yadview.DayViewModel;

public class DefaultDayViewModel implements DayViewModel {
	
	private Time mTime = new Time();

	public DefaultDayViewModel() {
		mTime.setToNow();
	}
	
	@Override
	public long getTime() {
		return mTime.toMillis(false);
	}

	@Override
	public void setTime(long t) {
		mTime.set(t);

	}

}
