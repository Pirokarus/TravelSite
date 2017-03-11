package org.olim.client.data;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

import java.util.ArrayList;
import java.util.List;

public class CitiesView extends HorizontalPanel {

    public HorizontalPanel citiesModelStart(List<CountryBox> countriesList) {

        final Label errLabel = new Label("");
        final VerticalPanel mainPanel = new VerticalPanel();
        final HorizontalPanel addPanel = new HorizontalPanel();
        final Button addButton = new Button("Добавить");

        final HorizontalPanel LabelPanel = new HorizontalPanel();
        final Label emptLabel = new Label("");
        final Label cityLabel = new Label("Пункт назначения");
        final Label inLabel = new Label("Дата прибытия");
        final Label outLabel = new Label("Дата отъезда");

        //final Frame map = new Frame("https://www.google.com/maps/embed/v1/place?key=AIzaSyB2XEJDcsD1Yn3eC-pZeStmzISqUEv6dG8 &"+ "q=Moscow");
        //map.setSize("700px","700px");

        setStyleName("sitePanel");
        //map.setUrl("https://www.google.com/maps/embed/v1/place?key=AIzaSyB2XEJDcsD1Yn3eC-pZeStmzISqUEv6dG8&"+ "q=Kazan");

        final VerticalPanel cityPanel = new VerticalPanel();
        cityPanel.add(mainPanel);
        cityPanel.add(addPanel);
        cityPanel.add(addButton);
        //sitePanel.add(map);
        this.add(cityPanel);
        LabelPanel.add(emptLabel);
        LabelPanel.add(cityLabel);
        LabelPanel.add(inLabel);
        LabelPanel.add(outLabel);

        mainPanel.add(LabelPanel);

        final List<String> AllCities = new ArrayList<String>();
        for (CountryBox country : countriesList) {
            List<String> cities = country.getCities();
            for (String city : cities) {
                AllCities.add(city + " ," + country.getCounrty());
            }
        }

        final MultiWordSuggestOracle oracleAllCities = new MultiWordSuggestOracle();
        oracleAllCities.addAll(AllCities);
        oracleAllCities.setDefaultSuggestionsFromText(AllCities);

        final SuggestBox citiesSugestBox = new SuggestBox(oracleAllCities);

        citiesSugestBox.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                citiesSugestBox.showSuggestionList();
            }
        });

        final DateBox inDate = new DateBox();
        final DateBox outDate = new DateBox();
        inDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getLongDateFormat()));
        outDate.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getLongDateFormat()));

        final Label emLabel = new Label("");

        addPanel.add(emLabel);
        addPanel.add(citiesSugestBox);
        addPanel.add(inDate);
        addPanel.add(outDate);
        cityPanel.setStyleName("sitePanel");
        mainPanel.setStyleName("sitePanel");

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {


                final HorizontalPanel city = new HorizontalPanel();
                final Button delButton = new Button("-");
                final SuggestBox newCitiesSugestBox = new SuggestBox(oracleAllCities);
                final DateBox inDate1 = new DateBox();
                final DateBox outDate1 = new DateBox();

                newCitiesSugestBox.addClickListener(new ClickListener() {
                    @Override
                    public void onClick(Widget widget) {
                        newCitiesSugestBox.showSuggestionList();
                    }
                });

                newCitiesSugestBox.setValue(citiesSugestBox.getValue(), true);

                inDate1.setValue(inDate.getValue());
                outDate1.setValue(outDate.getValue());

                city.add(delButton);
                city.add(newCitiesSugestBox);
                city.add(inDate1);
                city.add(outDate1);

                if (AllCities.contains(citiesSugestBox.getValue())) {

                    if ((inDate.getValue().before(outDate.getValue())) || inDate.getValue().equals(outDate.getValue())) {
                        mainPanel.add(city);
                        errLabel.setText("");

                        citiesSugestBox.setValue("");
                        inDate.setValue(outDate.getValue());
                        outDate.setValue(null);
                    } else {
                        errLabel.setText("Введите корректные даты прибытия и отъезда");

                    }
                } else {
                    errLabel.setText("Введите пункт назначения");
                }

                delButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        mainPanel.remove(city);
                    }
                });

            }
        });


        return this;
    }
}
