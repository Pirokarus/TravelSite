package org.olim.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class travelSite implements EntryPoint {

    public void onModuleLoad() {

        final Label errLabel = new Label("");
        final VerticalPanel mainPanel = new VerticalPanel();
        final HorizontalPanel addPanel = new HorizontalPanel();
        final Button addButton = new Button("Добавить");

        final List<String> countryList = new ArrayList<String>();
        countryList.add("Россия");
        countryList.add("Белоруссия");
        countryList.add("Казахстан");

        final List<String> RussiaList = new ArrayList<String>();
        RussiaList.add("Москва");
        RussiaList.add("Санкт-Петербург");
        RussiaList.add("Нижний Новгород");
        RussiaList.add("Сочи");

        for (String citiName:RussiaList) {
            int index = RussiaList.indexOf(citiName);
            citiName = citiName + ", Россия";
            RussiaList.set(index,citiName);
        }

        final List<String> BelarusList = new ArrayList<String>();
        BelarusList.add("Минск");
        BelarusList.add("Брест");
        BelarusList.add("Могилёв");

        for (String citiName:BelarusList) {
            int index = BelarusList.indexOf(citiName);
            citiName = citiName + ", Белоруссия";
            BelarusList.set(index,citiName);
        }

        final List<String> KazahList = new ArrayList<String>();
        KazahList.add("Астана");
        KazahList.add("Алма-Аты");

        for (String citiName:KazahList) {
            int index = KazahList.indexOf(citiName);
            citiName = citiName + ", Казахстан";
            KazahList.set(index,citiName);
        }

        final List<String> AllCities = new ArrayList<String>();
        AllCities.addAll(RussiaList);
        AllCities.addAll(BelarusList);
        AllCities.addAll(KazahList);

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

        addPanel.add(citiesSugestBox);
        addPanel.add(inDate);
        addPanel.add(outDate);

        citiesSugestBox.setSize("500","500");

        RootPanel.get("MyTravelFieldContainer").add(mainPanel);
        RootPanel.get("MyAddFieldContainer").add(addPanel);
        RootPanel.get("MyTravelAddButtonContainer").add(addButton);
        RootPanel.get("MyTravelErrLabel").add(errLabel);

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

                if(AllCities.contains(citiesSugestBox.getValue())) {

                    mainPanel.add(city);
                    errLabel.setText("");
                }
                else
                {
                    errLabel.setText("Введите пункт назначения");
                }

                delButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        mainPanel.remove(city);
                    }
                });
                citiesSugestBox.setValue("");
            }
        });
    }
}
