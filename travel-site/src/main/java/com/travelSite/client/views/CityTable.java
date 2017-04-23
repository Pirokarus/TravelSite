package com.travelSite.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.travelSite.client.AppMessages;
import com.travelSite.client.data.Location;
import com.travelSite.shared.City;

import java.util.ArrayList;
import java.util.List;

public class CityTable extends Composite {
    private static CityTableUiBinder UiBinder = GWT.create(CityTableUiBinder.class);

    @UiField
    VerticalPanel cityPanel;
    @UiField(provided = true)
    CityLine addCityLine;
    @UiField(provided = true)
    Button addButton;
    private AppMessages messages = GWT.create(AppMessages.class);
    private List<City> citiesList;
    private List<Location> path;

    public CityTable(List<City> citiesList) {

        addCityLine = new CityLine(citiesList);
        addButton = new Button(messages.addButton());
        this.citiesList = citiesList;
        initWidget(UiBinder.createAndBindUi(this));
        path = new ArrayList<>();
        addButton.setStyleName("addButton");
        addCityLine.setStyleName("addCityStyle");
    }
    @UiTemplate("CityTable.ui.xml")
    interface CityTableUiBinder extends UiBinder<Widget, CityTable> {
    }

    @UiHandler("addButton")
    void doAddClick(ClickEvent event){
        if(path.size()<15) {
            Button removeButton = new Button("-");
            removeButton.setStyleName("removeButton");
            CityLine chosenCity = new CityLine(this.citiesList,
                    addCityLine.getCity(),
                    addCityLine.getInDate(),
                    addCityLine.getOutDate());

            final HorizontalPanel chosenCityPanel = new HorizontalPanel();
            chosenCityPanel.add(removeButton);
            chosenCityPanel.add(chosenCity);
            cityPanel.add(chosenCityPanel);

            final Location location = new Location(addCityLine.getCity(),
                    addCityLine.getInDate(),
                    addCityLine.getOutDate());
            path.add(location);

            removeButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    cityPanel.remove(chosenCityPanel);
                    path.remove(location);
                }
            });
            addCityLine.cityField.setValue("");
            addCityLine.inDateField.setValue(addCityLine.getOutDate());
            addCityLine.outDateField.setValue(null);
        }
    }

    public List<Location> getPath() {
        return path;
    }

    public CityLine getCityLine(){return this.addCityLine;}
}