package org.olim.client.data;




import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;

public class CitiesListDownloadController {

    private CitiesListModel citiesListModel;
    private final EventBus eventBus;

    @Inject
    public CitiesListDownloadController(CitiesListModel citiesListModel, EventBus eventBus){
        this.citiesListModel = citiesListModel;
        this.eventBus = eventBus;
        eventBus.addHandler(CitiesModelLoadCommand.TYPE,new MyCitiesModelCommandHandler());

    }

    private class MyCitiesModelCommandHandler implements CitiesModelLoadCommandHandler {

        @Override
        public void onCitiesModelLoadComand(CitiesModelLoadCommand command) {
            citiesListModel.setData(new TestCountriesList().getCountryBoxes());
        }

    }
}
