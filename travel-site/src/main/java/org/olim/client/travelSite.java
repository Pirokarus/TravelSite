package org.olim.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import org.olim.client.config.Injector;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TravelSite implements EntryPoint {

    public void onModuleLoad() {
        final Injector injector = Injector.INSTANCE;



        injector.getFirstModel().start();
        injector.getFirstView();
        injector.getFirstController();


        //RootPanel.get("MyAddFieldContainer").add(cityPanel);
        //RootPanel.get("MyTravelAddButtonContainer").add(addButton);
        //RootPanel.get("MyTravelErrLabel").add(errLabel);


    }

/*
private native void setMark(String x, String y) /*-{
    $vnd.googlemapapi.setMark(x,y);
}-*/;




}
