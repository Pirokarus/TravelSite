package org.olim.client.data;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.Event.Type;
import com.google.web.bindery.event.shared.HandlerRegistration;

import java.util.ArrayList;
import java.util.List;

public class CitiesModel extends HorizontalPanel{
    @Inject
    public HorizontalPanel citiesModelStart() {
        final String height = "30px";
        final String sugHeight = "28px";
        final String butHeight = "36px";
        final String labelHeight = "30px";
        final String labelWidth = "155px";
        final String empLabelWidth = "13px";
        final String emptLabelWidth = "20px";
        final String width = "150px";
        final String butWidth = "15px";

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

                if(AllCities.contains(citiesSugestBox.getValue())) {

                    if ((inDate.getValue().before(outDate.getValue()))||inDate.getValue().equals(outDate.getValue())){
                        mainPanel.add(city);
                        errLabel.setText("");

                        citiesSugestBox.setValue("");
                        inDate.setValue(outDate.getValue());
                        outDate.setValue(null);
                    }
                    else {
                        errLabel.setText("Введите корректные даты прибытия и отъезда");

                    }
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

                delButton.setSize(butWidth,butHeight);
                newCitiesSugestBox.setSize(width,sugHeight);
                outDate1.setSize(width,height);
                inDate1.setSize(width,height);


            }
        });

        emLabel.setSize(empLabelWidth,butHeight);
        citiesSugestBox.setSize(width,sugHeight);
        inDate.setSize(width,height);
        outDate.setSize(width,height);

        emptLabel.setSize(emptLabelWidth,labelHeight);
        cityLabel.setSize(labelWidth,labelHeight);
        inLabel.setSize(labelWidth,labelHeight);
        outLabel.setSize(labelWidth,labelHeight);
        return this;
    }
}