package com.travelSite.client;

import com.google.gwt.core.client.EntryPoint;
import com.travelSite.client.config.Injector;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TravelSite implements EntryPoint {

    public void onModuleLoad() {
        final Injector injector = Injector.INSTANCE;
        injector.getLifeCycle().start();
        //RootPanel.get("MyTravelFieldContainer").add(new CityLine(new TestCountriesList().getCountryBoxes()));
    }

/*
private native void setMark(String x, String y) /*-{
    $vnd.googlemapapi.setMark(x,y);
}-*/;


}