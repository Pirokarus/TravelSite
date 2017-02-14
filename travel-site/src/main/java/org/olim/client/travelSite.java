package org.olim.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class travelSite implements EntryPoint {

    public void onModuleLoad() {

        // final Label MyTravelLabel = new Label("Моё путешествие");
        final VerticalPanel mainPanel = new VerticalPanel();
        final HorizontalPanel addPanel = new HorizontalPanel();
        final Button addButton = new Button("Добавить");


        //addPanel.add(delButton);

        final ListBox combobox = new ListBox();

        combobox.addItem("London");
        combobox.addItem("Rome");
        combobox.addItem("Paris");
        combobox.addItem("Berlin");
        combobox.addItem("Madrid");


        addPanel.add(combobox);

        final DateBox inDate = new DateBox();

        addPanel.add(inDate);

        final DateBox outDate = new DateBox();

        addPanel.add(outDate);


        //  RootPanel.get("MyTravelLabelContainer").add(MyTravelLabel);
        RootPanel.get("MyTravelFieldContainer").add(mainPanel);
        RootPanel.get("MyAddFieldContainer").add(addPanel);
        RootPanel.get("MyTravelAddButtonContainer").add(addButton);


        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

                final HorizontalPanel city = new HorizontalPanel();
                final Button delButton = new Button("-");
                city.add(delButton);


                final ListBox combobox1 = new ListBox();


                combobox1.addItem("London");
                combobox1.addItem("Rome");
                combobox1.addItem("Paris");
                combobox1.addItem("Berlin");
                combobox1.addItem("Madrid");

                final DateBox inDate1 = new DateBox();

                final DateBox outDate1 = new DateBox();

                combobox1.setItemSelected(combobox.getSelectedIndex(), true);

                inDate1.setValue(inDate.getValue());
                outDate1.setValue(outDate.getValue());


                city.add(combobox1);
                city.add(inDate1);
                city.add(outDate1);

                mainPanel.add(city);


                delButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {

                        mainPanel.remove(city);

                    }
                });


            }
        });


    }
}
