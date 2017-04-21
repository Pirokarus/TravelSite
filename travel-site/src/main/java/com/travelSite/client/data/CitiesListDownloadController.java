package com.travelSite.client.data;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.travelSite.client.service.EndPoint;
import com.travelSite.shared.City;
import com.travelSite.shared.Locale;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CitiesListDownloadController {

    private final EventBus eventBus;
    private CitiesListModel citiesListModel;
    private final EndPoint endPoint = GWT.create(EndPoint.class);

    @Inject
    public CitiesListDownloadController(CitiesListModel citiesListModel, EventBus eventBus) {
        this.citiesListModel = citiesListModel;
        this.eventBus = eventBus;
        eventBus.addHandler(CitiesModelLoadCommand.TYPE, new MyCitiesModelCommandHandler());

    }

    private class MyCitiesModelCommandHandler implements CitiesModelLoadCommandHandler {

        @Override
        public void onCitiesModelLoadComand(CitiesModelLoadCommand command) {

            endPoint.getCitiesList(new MethodCallback<List<City>>() {
                @Override
                public void onFailure(Method method, Throwable throwable) {

                }

                @Override
                public void onSuccess(Method method, List<City> cities) {
                    citiesListModel.setData((ArrayList<City>) cities);
                }
            });
        }

    }
}
