package com.travelSite.client.data;

import com.google.web.bindery.event.shared.HandlerRegistration;
import com.travelSite.shared.City;

import javax.inject.Inject;
import java.util.List;

public class CitiesListModel extends ModelBase {

    public void setData(List<City> cities) {
        if (this.cities != cities) {
            this.cities = cities;
            fireEvent(CitiesModelChangedEvent.create());
        }
    }

    private List<City> cities;

    @Inject
    public CitiesListModel() {

    }

    public List<City> getData() {
        return cities;
    }

    public final HandlerRegistration addFirstModelChangedHandler(CitiesModelChangedEventHandler handler) {
        return addHandler(CitiesModelChangedEvent.TYPE, handler);
    }

}
