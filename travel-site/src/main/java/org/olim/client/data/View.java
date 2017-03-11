package org.olim.client.data;

import com.google.gwt.user.client.ui.*;

import javax.inject.Inject;

public class View extends HorizontalPanel {

    private static CitiesListModel citiesListModel;

    @Inject
    public View(CitiesListModel citiesListModel){
        this.citiesListModel = citiesListModel;
        citiesListModel.addFirstModelChangedHandler(new MyCitiesModelChangedHandler());
        RootPanel.get("MyTravelFieldContainer").add(this);

    }

    private class MyCitiesModelChangedHandler implements CitiesModelChangedEventHandler {
        @Override
        public void onFirstModelChanged(CitiesModelChangedEvent event) {
            //implementation


            //add(new Label(firstModel.getData()));
            //add(new Label(citiesListModel.getData()));
            add(new CitiesView().citiesModelStart(citiesListModel.getData()));

        }
    }
}
