package com.travelSite.client.views;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface CityStyleRecources extends ClientBundle {

    @Source("CityLine.css")
    MyCss style();

    public interface MyCss extends CssResource {
        String cityStyle();
        String background();
        String dateStyle();
    }
}
