package org.olim.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import org.olim.client.data.CitiesModel;
import org.olim.client.data.Injector;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TravelSite implements EntryPoint {

    public void onModuleLoad() {
        final Injector injector = Injector.INSTANCE;


        RootPanel.get("MyTravelFieldContainer").add(injector.getCitiesModel().citiesModelStart());

        //RootPanel.get("MyAddFieldContainer").add(cityPanel);
        //RootPanel.get("MyTravelAddButtonContainer").add(addButton);
        //RootPanel.get("MyTravelErrLabel").add(errLabel);


    }

/*
private native void setMark(String x, String y) /*-{
    $vnd.googlemapapi.setMark(x,y);
}-*/;




}
