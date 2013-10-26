/*
Copyright 2013 Chris Pope

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 
 */

package com.google.code.yadview.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

import com.google.code.yadview.DayView;
import com.google.code.yadview.DayViewOnCreateContextMenuListener;
import com.google.code.yadview.DayViewOnKeyListener;
import com.google.code.yadview.DayViewOnLongClickListener;
import com.google.code.yadview.EventResource;

public class DefaultDayViewFactory implements ViewFactory {

    private final ViewSwitcher mViewSwitcher;
    private final Context mContext;
    private final EventResource mEventResource;
    private final DefaultEventLoader mEventLoader;


    public DefaultDayViewFactory(ViewSwitcher vs, EventResource eventResource, Context context) {
        mContext = context;
        mViewSwitcher = vs;
        mEventResource = eventResource;
        mEventLoader = new DefaultEventLoader(mEventResource);
    }
    
    
    @Override
    public View makeView() {
        //using alternate renderer - use alternate dayview resources
        DefaultDayViewResources resources = new DefaultDayViewResources(mContext);
        DefaultUtilFactory utilFactory = new DefaultUtilFactory("yadview_harness.prefs");
        DayView dv = new DayView(mContext, mViewSwitcher, mEventLoader, 1, utilFactory, resources, new DefaultEventRenderer(resources, utilFactory), new DefaultDayViewRenderer(resources));
        dv.setLayoutParams(new ViewSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        
        //matching previous behaviour
        dv.setOnCreateContextMenuListener(new DayViewOnCreateContextMenuListener(mContext, dv, utilFactory, resources, mEventResource));
        dv.setOnLongClickListener(new DayViewOnLongClickListener(mContext, dv, resources, utilFactory));
        dv.setOnKeyListener(new DayViewOnKeyListener(mContext, dv));
        return dv;
    }
    
    public Context getContext() {
        return mContext;
    }
    
    public DefaultEventLoader getEventLoader() {
        return mEventLoader;
    }
    
    public EventResource getEventResource() {
        return mEventResource;
    }
    
    public ViewSwitcher getViewSwitcher() {
        return mViewSwitcher;
    }
    
    

}
