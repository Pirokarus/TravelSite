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
        RussiaList.add("Санкт-Питербург");
        RussiaList.add("Нижний Новгород");
        RussiaList.add("Сочи");

        final List<String> BelarusList = new ArrayList<String>();
        BelarusList.add("Минск");
        BelarusList.add("Брест");
        BelarusList.add("Могилёв");

        final List<String> KazahList = new ArrayList<String>();
        KazahList.add("Астана");
        KazahList.add("Алма-Аты");

        final List<String> AllCities = new ArrayList<String>();
        AllCities.addAll(RussiaList);
        AllCities.addAll(BelarusList);
        AllCities.addAll(KazahList);

        final MultiWordSuggestOracle oracleCountries = new MultiWordSuggestOracle();
        oracleCountries.addAll(countryList);
        oracleCountries.setDefaultSuggestionsFromText(countryList);

        final MultiWordSuggestOracle oracleAllCities = new MultiWordSuggestOracle();
        oracleAllCities.addAll(AllCities);
        oracleAllCities.setDefaultSuggestionsFromText(AllCities);

        final MultiWordSuggestOracle oracleRussianCities = new MultiWordSuggestOracle();
        oracleRussianCities.addAll(RussiaList);
        oracleRussianCities.setDefaultSuggestionsFromText(RussiaList);

        final MultiWordSuggestOracle oracleBelarusCities = new MultiWordSuggestOracle();
        oracleBelarusCities.addAll(BelarusList);
        oracleBelarusCities.setDefaultSuggestionsFromText(BelarusList);

        final MultiWordSuggestOracle oracleKazahCities = new MultiWordSuggestOracle();
        oracleKazahCities.addAll(KazahList);
        oracleKazahCities.setDefaultSuggestionsFromText(KazahList);

        final SuggestBox RuSagestBox = new SuggestBox(oracleRussianCities);
        final SuggestBox BlSagestBox = new SuggestBox(oracleBelarusCities);
        final SuggestBox KzSagestBox = new SuggestBox(oracleKazahCities);

        RuSagestBox.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                RuSagestBox.showSuggestionList();
            }
        });

        BlSagestBox.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                BlSagestBox.showSuggestionList();
            }
        });

        KzSagestBox.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                KzSagestBox.showSuggestionList();
            }
        });

        final SuggestBox countriesSugestBox = new SuggestBox(oracleCountries);

        countriesSugestBox.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                countriesSugestBox.showSuggestionList();
            }
        });

        addPanel.add(countriesSugestBox);

        final SuggestBox citiesSugestBox = new SuggestBox(oracleAllCities);

        citiesSugestBox.addClickListener(new ClickListener() {
            @Override
            public void onClick(Widget widget) {
                citiesSugestBox.showSuggestionList();
            }
        });

        addPanel.add(citiesSugestBox);

        countriesSugestBox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
            @Override
            public void onSelection(SelectionEvent<SuggestOracle.Suggestion> selectionEvent) {

                switch (countriesSugestBox.getValue()) {
                    case ("Россия"):
                        addPanel.remove(1);
                        addPanel.insert(RuSagestBox, 1);
                        break;

                    case ("Белоруссия"):
                        addPanel.remove(1);
                        addPanel.insert(BlSagestBox, 1);
                        break;

                    case ("Казахстан"):
                        addPanel.remove(1);
                        addPanel.insert(KzSagestBox, 1);
                        break;

                }
            }
        });

        citiesSugestBox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
            @Override
            public void onSelection(SelectionEvent<SuggestOracle.Suggestion> selectionEvent) {

                if (RussiaList.contains(citiesSugestBox.getValue())){
                    countriesSugestBox.setValue("Россия");
                    RuSagestBox.setValue(citiesSugestBox.getValue());
                    addPanel.remove(1);
                    addPanel.insert(RuSagestBox, 1);
                }

                if (BelarusList.contains(citiesSugestBox.getValue())){
                    countriesSugestBox.setValue("Белоруссия");
                    BlSagestBox.setValue(citiesSugestBox.getValue());
                    addPanel.remove(1);
                    addPanel.insert(BlSagestBox, 1);
                }

                if (KazahList.contains(citiesSugestBox.getValue())){
                    countriesSugestBox.setValue("Казахстан");
                    KzSagestBox.setValue(citiesSugestBox.getValue());
                    addPanel.remove(1);
                    addPanel.insert(KzSagestBox, 1);
                }
            }
        });

        final DateBox inDate = new DateBox();

        addPanel.add(inDate);

        final DateBox outDate = new DateBox();

        addPanel.add(outDate);

        RootPanel.get("MyTravelFieldContainer").add(mainPanel);
        RootPanel.get("MyAddFieldContainer").add(addPanel);
        RootPanel.get("MyTravelAddButtonContainer").add(addButton);
        RootPanel.get("MyTravelErrLabel").add(errLabel);

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                final SuggestBox newRuSagestBox = new SuggestBox(oracleRussianCities);
                final SuggestBox newBlSagestBox = new SuggestBox(oracleBelarusCities);
                final SuggestBox newKzSagestBox = new SuggestBox(oracleKazahCities);

                newRuSagestBox.addClickListener(new ClickListener() {
                    @Override
                    public void onClick(Widget widget) {
                        newRuSagestBox.showSuggestionList();
                    }
                });

                newBlSagestBox.addClickListener(new ClickListener() {
                    @Override
                    public void onClick(Widget widget) {
                        newBlSagestBox.showSuggestionList();
                    }
                });

                newKzSagestBox.addClickListener(new ClickListener() {
                    @Override
                    public void onClick(Widget widget) {
                        newKzSagestBox.showSuggestionList();
                    }
                });

                final HorizontalPanel city = new HorizontalPanel();
                final Button delButton = new Button("-");
                final SuggestBox newCountriesSugestBox = new SuggestBox(oracleCountries);
                final DateBox inDate1 = new DateBox();
                final DateBox outDate1 = new DateBox();

                newCountriesSugestBox.setValue(countriesSugestBox.getValue(), true);

                inDate1.setValue(inDate.getValue());
                outDate1.setValue(outDate.getValue());

                city.add(delButton);
                city.add(newCountriesSugestBox);
                city.add(inDate1);
                city.add(outDate1);

                switch (countriesSugestBox.getValue()) {
                    case ("Россия"):
                        newRuSagestBox.setValue(RuSagestBox.getValue());
                        city.insert(newRuSagestBox, 2);
                        break;

                    case ("Белоруссия"):
                        newBlSagestBox.setValue(BlSagestBox.getValue());
                        city.insert(newBlSagestBox, 2);
                        break;

                    case ("Казахстан"):
                        newKzSagestBox.setValue(KzSagestBox.getValue());
                        city.insert(newKzSagestBox, 2);
                        break;
                }

                newCountriesSugestBox.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {
                    @Override
                    public void onSelection(SelectionEvent<SuggestOracle.Suggestion> selectionEvent) {

                        switch (newCountriesSugestBox.getValue()) {
                            case ("Россия"):
                                city.remove(2);
                                city.insert(newRuSagestBox, 2);
                                break;

                            case ("Белоруссия"):
                                city.remove(2);
                                city.insert(newBlSagestBox, 2);
                                break;

                            case ("Казахстан"):
                                city.remove(2);
                                city.insert(newKzSagestBox, 2);
                                break;

                        }
                    }
                });

                if(countryList.contains(countriesSugestBox.getValue())) {

                    mainPanel.add(city);
                    errLabel.setText("");
                }
                else
                {
                    errLabel.setText("Введите страну");
                }

                delButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        mainPanel.remove(city);
                    }
                });
                countriesSugestBox.setValue("");
                RuSagestBox.setValue("");
                BlSagestBox.setValue("");
                KzSagestBox.setValue("");
            }
        });
    }
}
