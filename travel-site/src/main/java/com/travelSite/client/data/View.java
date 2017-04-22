package com.travelSite.client.data;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.mvc.MVCArray;
import com.google.gwt.maps.client.overlays.*;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.event.shared.EventBus;
import com.travelSite.client.AppMessages;
import com.travelSite.client.views.CityTable;
import com.travelSite.shared.City;

import javax.inject.Inject;
import java.util.List;

//import com.google.gwt.maps.client.MapWidget;
//import com.google.gwt.maps.client.geom.LatLng;

public class View extends HorizontalPanel {

    private static CitiesListModel citiesListModel;
    private EventBus eventBus;
    private List<Location> path;
    private String lang = "en";
    private AppMessages messages = GWT.create(AppMessages.class);

    @Inject
    public View(CitiesListModel citiesListModel, EventBus eventBus) {
        this.citiesListModel = citiesListModel;
        this.eventBus = eventBus;
        citiesListModel.addFirstModelChangedHandler(new MyCitiesModelChangedHandler());
        RootPanel.get("MyTravelFieldContainer").add(this);

    }

    public List<Location> getPath() {
        return path;
    }

    private class MyCitiesModelChangedHandler implements CitiesModelChangedEventHandler {
            @Override
        public void onCitiesModelChanged(CitiesModelChangedEvent event) {

            LatLng latLng = LatLng.newInstance(50,50);
            MapOptions mapOptions = MapOptions.newInstance();
            mapOptions.setCenter(latLng);
            mapOptions.setZoom(4);
            MapWidget mapWidget = new MapWidget(mapOptions);

            MVCArray<LatLng> latLngMVCArray = MVCArray.newInstance();
            latLngMVCArray.setAt(1,LatLng.newInstance(50,55));
            latLngMVCArray.setAt(2,LatLng.newInstance(55,50));

            HorizontalPanel mainPanel = new HorizontalPanel();
            mainPanel.add(mapWidget);

            VerticalPanel cityPanel = new VerticalPanel();

            List<City> citiesList = citiesListModel.getData();
            final CityTable cityTable = new CityTable(citiesList);
            cityPanel.add(cityTable);

                for(final City city:citiesList){ setMarker(city, mapWidget, cityTable);}

            Button readyButton = new Button(messages.doneButton());
            mainPanel.add(cityPanel);
            setStyleName("background");
            cityPanel.add(readyButton);
            readyButton.setStyleName("doneButton");
            mapWidget.setStyleName("mapStyle");

            add(mainPanel);

            readyButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    path = cityTable.getPath();
                    eventBus.fireEvent(PersonalPathUploadComand.create());
                }
            });
        }

        private void setMarker(City city, MapWidget mapWidget, CityTable cityTable){

            LatLng centerIcon = LatLng.newInstance(city.getLatitude(), city.getLongitude());
            MarkerImage markerImage = MarkerImage.newInstance("http://www.google.com/mapfiles/markerA.png");
            MarkerOptions mOpts = MarkerOptions.newInstance();
            mOpts.setIcon(markerImage);
            mOpts.setPosition(centerIcon);

            Marker marker = Marker.newInstance(mOpts);
            marker.setMap(mapWidget);

            marker.addClickHandler(new ClickMapHandler() {
                @Override
                public void onEvent(ClickMapEvent clickMapEvent) {
                    cityTable.getCityLine().setCity(city.getName() + ", " + city.getCountry());
                }
            });
        }
    }
}
