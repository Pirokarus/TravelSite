package com.travelSite.client.data;


import com.google.web.bindery.event.shared.HandlerRegistration;
import com.travelSite.shared.CityBox;

import javax.inject.Inject;
import java.util.List;

public class CitiesListModel extends ModelBase {

    private List<CityBox> cities;


    @Inject
    public CitiesListModel() {

    }

    public List<CityBox> getData() {
        return cities;
    }

    public void setData(List<CityBox> countries) {
        if (this.cities != countries) {
            this.cities = countries;

            fireEvent(CitiesModelChangedEvent.create());
        }
    }

    public final HandlerRegistration addFirstModelChangedHandler(CitiesModelChangedEventHandler handler) {
        return addHandler(CitiesModelChangedEvent.TYPE, handler);
    }

}
