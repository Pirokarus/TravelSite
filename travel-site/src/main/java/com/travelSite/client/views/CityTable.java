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
import com.travelSite.client.data.Station;
import com.travelSite.shared.CityBox;

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
    private List<CityBox> citiesList;
    private List<Station> path;

    public CityTable(List<CityBox> citiesList) {

        addCityLine = new CityLine(citiesList);
        addButton = new Button(messages.addButton());
        this.citiesList = citiesList;
        initWidget(UiBinder.createAndBindUi(this));
        path = new ArrayList<>();

    }
    @UiTemplate("CityTable.ui.xml")
    interface CityTableUiBinder extends UiBinder<Widget, CityTable> {
    }

    @UiHandler("addButton")
    void doAddClick(ClickEvent event){
        Button removeButton = new Button("-");
        CityLine chosenCity = new CityLine(this.citiesList, addCityLine.getCity(),addCityLine.getInDate(),addCityLine.getOutDate());
        final HorizontalPanel chosenCityPanel = new HorizontalPanel();

        chosenCityPanel.add(removeButton);
        chosenCityPanel.add(chosenCity);

        cityPanel.add(chosenCityPanel);

        final Station station = new Station(addCityLine.getCity(), addCityLine.getInDate(), addCityLine.getOutDate());
        path.add(station);

        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                cityPanel.remove(chosenCityPanel);
                path.remove(station);
            }
        });

        addCityLine.cityField.setValue("");
        addCityLine.inDateField.setValue(addCityLine.getOutDate());
        addCityLine.outDateField.setValue(null);
    }

    public List<Station> getPath() {
        return path;
    }

    public CityLine getCityLine(){return this.addCityLine;}
}