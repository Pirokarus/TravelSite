package org.olim.client.data;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.event.shared.EventBus;
import org.olim.client.AppMessages;
import org.olim.client.views.CityTable;

import javax.inject.Inject;
import java.util.List;

//import com.google.gwt.maps.client.MapWidget;
//import com.google.gwt.maps.client.geom.LatLng;

public class View extends HorizontalPanel {

    private static CitiesListModel citiesListModel;
    private EventBus eventBus;
    private List<Station> path;
    private String lang = "en";
    private AppMessages messages = GWT.create(AppMessages.class);

    @Inject
    public View(CitiesListModel citiesListModel, EventBus eventBus) {
        this.citiesListModel = citiesListModel;
        this.eventBus = eventBus;
        citiesListModel.addFirstModelChangedHandler(new MyCitiesModelChangedHandler());
        RootPanel.get("MyTravelFieldContainer").add(this);

    }

    public List<Station> getPath() {
        return path;
    }

    private class MyCitiesModelChangedHandler implements CitiesModelChangedEventHandler {
        @Override
        public void onCitiesModelChanged(CitiesModelChangedEvent event) {

            //LatLng latLng = LatLng.newInstance(30000,30000);
            MapOptions mapOptions = MapOptions.newInstance();
            MapWidget mapWidget = new MapWidget(mapOptions);
            mapWidget.setSize("500px", "500px");


            HorizontalPanel mainPanel = new HorizontalPanel();
            mainPanel.add(mapWidget);

            VerticalPanel cityPanel = new VerticalPanel();
            final CityTable cityTable = new CityTable(citiesListModel.getData());
            cityPanel.add(cityTable);
            Button readyButton = new Button(messages.doneButton());
            mainPanel.add(cityPanel);
            cityPanel.add(readyButton);

            add(mainPanel);

            readyButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    path = cityTable.getPath();
                    eventBus.fireEvent(PersonalPathUploadComand.create());
                }
            });

        }
    }
}
