package org.olim.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.olim.client.AppMessages;
import org.olim.client.data.CountryBox;
import org.olim.client.data.Station;

import java.util.List;


public class CityTable extends Composite {
    private static CityTableUiBinder UiBinder = GWT.create(CityTableUiBinder.class);
    @UiField
    VerticalPanel cityPanel;
    @UiField(provided = true)
    CityLine addCityLine;
    @UiField
    Button addButton;
    @UiField
    Button doneButton;
    private AppMessages messages = GWT.create(AppMessages.class);
    private List<CountryBox> countriesList;
    private List<Station> path;
    public CityTable(List<CountryBox> countriesList) {

        addCityLine = new CityLine(countriesList);
        addButton.setText(messages.addButton());
        doneButton.setText(messages.doneButton());
        this.countriesList = countriesList;
        initWidget(UiBinder.createAndBindUi(this));
    }
    @UiTemplate("CityTable.ui.xml")
    interface CityTableUiBinder extends UiBinder<Widget, CityTable> {
    }
/*
    @UiHandler("addButton")
    void doClick(ClickEvent event){
        Button removeButton = new Button("-");
        CityLine chosenCity = new CityLine(this.countriesList, addCityLine.getCity(),addCityLine.getInDate(),addCityLine.getOutDate());
        final HorizontalPanel chosenCityPanel = new HorizontalPanel();

        chosenCityPanel.add(removeButton);
        chosenCityPanel.add(chosenCity);

        cityPanel.add(chosenCityPanel);

        removeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                cityPanel.remove(chosenCityPanel);
            }
        });
    }
*/

}