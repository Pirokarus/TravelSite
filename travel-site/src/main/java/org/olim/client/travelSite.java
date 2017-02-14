package org.olim.client;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import org.olim.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;

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

                                  final HorizontalPanel sity = new HorizontalPanel();
                                  final Button delButton = new Button("-");
                                  sity.add(delButton);


                                  final ListBox combobox1 = new ListBox();

                                  combobox1.addItem("London");
                                  combobox1.addItem("Rome");
                                  combobox1.addItem("Paris");
                                  combobox1.addItem("Berlin");
                                  combobox1.addItem("Madrid");

                                  final DateBox inDate1 = new DateBox();

                                  final DateBox outDate1 = new DateBox();

                                  combobox1.setItemSelected(combobox.getSelectedIndex(),true);

                                  inDate1.setValue(inDate.getValue());
                                  outDate1.setValue(outDate.getValue());




                                  sity.add(combobox1);
                                  sity.add(inDate1);
                                  sity.add(outDate1);

                                  mainPanel.add(sity);


                                  delButton.addClickHandler(new ClickHandler() {
                                    @Override
                                    public void onClick(ClickEvent clickEvent) {

                                      mainPanel.remove(sity);

                                    }
                                    });


                                }
                              });





  }
}
