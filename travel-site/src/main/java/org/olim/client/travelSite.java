package org.olim.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import org.olim.client.config.Injector;
import org.olim.client.data.CitiesView;
import org.olim.client.data.TestCountriesList;
import org.olim.client.views.CityLine;

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
