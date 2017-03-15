package org.olim.client.data;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.event.shared.EventBus;
import org.olim.client.data.localization.AppMessages;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.*;

public class View extends HorizontalPanel {

    private EventBus eventBus;
    private static CitiesListModel citiesListModel;
    private List<Station> path;
    private String lang = "en";
    private AppMessages messages = GWT.create(AppMessages.class);

    @Inject
    public View(CitiesListModel citiesListModel, EventBus eventBus){
        this.citiesListModel = citiesListModel;
        citiesListModel.addFirstModelChangedHandler(new MyCitiesModelChangedHandler());
        RootPanel.get("MyTravelFieldContainer").add(this);

    }

    public List<Station> getPath() {
        return path;
    }

    private class MyCitiesModelChangedHandler implements CitiesModelChangedEventHandler {
      @Override
        public void onCitiesModelChanged(CitiesModelChangedEvent event) {

            VerticalPanel cityPanel = new VerticalPanel();
            final CitiesView cityView = new CitiesView(citiesListModel.getData());
            cityPanel.add(cityView);
            Button readyButton = new Button(messages.doneButton());
            add(cityPanel);
            cityPanel.add(readyButton);

            readyButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                     path = cityView.getPath();
                     eventBus.fireEvent(PersonalPathUploadComand.create());
                }
            });

        }
    }
}
