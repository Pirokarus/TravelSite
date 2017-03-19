package org.olim.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import org.olim.client.data.CountryBox;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CityLine extends Composite {
    final static MultiWordSuggestOracle oracleCitiesList = new MultiWordSuggestOracle();
    private static CityLineUiBinder uiBinder =
            GWT.create(CityLineUiBinder.class);
    @UiField(provided = true)
    final CityStyleRecources res;
    @UiField(provided = true)
    SuggestBox cityField;
    @UiField
    DateBox inDateField;
    @UiField
    DateBox outDateField;
    private List<CountryBox> countriesList;

    public CityLine(List<CountryBox> countriesList) {

        this.countriesList = countriesList;
        getSuggestions(countriesList);
        cityField = new SuggestBox(oracleCitiesList);
        this.res = GWT.create(CityStyleRecources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));

        cityField.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                cityField.showSuggestionList();
            }
        });
        inDateField.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getLongDateFormat()));
        outDateField.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getLongDateFormat()));

    }
    public CityLine(List<CountryBox> countriesList, String city, Date inDate, Date outDate) {
        this.countriesList = countriesList;
        getSuggestions(countriesList);
        cityField = new SuggestBox(oracleCitiesList);
        this.res = GWT.create(CityStyleRecources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));

        cityField.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                cityField.showSuggestionList();
            }
        });
        inDateField.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getLongDateFormat()));
        outDateField.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getLongDateFormat()));
        cityField.setValue(city);
        inDateField.setValue(inDate);
        outDateField.setValue(outDate);
    }

    private void getSuggestions(List<CountryBox> countriesList) {

        final List<String> AllCities = new ArrayList<String>();
        for (CountryBox country : countriesList) {
            List<String> cities = country.getCities();
            for (String city : cities) {
                AllCities.add(city + " ," + country.getCounrty());
            }
        }
        oracleCitiesList.addAll(AllCities);
        oracleCitiesList.setDefaultSuggestionsFromText(AllCities);


    }

    public Date getInDate() {
        return inDateField.getValue();
    }

    public void setInDate(Date date) {
        this.inDateField.setValue(date);
    }

    public Date getOutDate() {
        return outDateField.getValue();
    }

    public void setOutDate(Date date) {
        this.outDateField.setValue(date);
    }

    public String getCity() {
        return cityField.getValue();
    }

    public void setCity(String city) {
        cityField.setValue(city);
    }

    @UiTemplate("CityLine.ui.xml")
    interface CityLineUiBinder extends UiBinder<Widget, CityLine> {
    }




    /*
    @UiHandler("cityField")
    void doClick(ClickEvent event){
        cityField.showSuggestionList();
    }
/*
    @UiHandler("removeButton")
    void doClick(ClickEvent event){

    }

*/

}