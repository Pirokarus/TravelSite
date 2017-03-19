package org.olim.client.data;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.event.shared.EventBus;
import org.olim.client.AppMessages;

import javax.inject.Inject;
import java.util.List;

public class View extends HorizontalPanel {

    private static CitiesListModel citiesListModel;
    private EventBus eventBus;
    private List<Station> path;
    private String lang = "en";
    private AppMessages messages = GWT.create(AppMessages.class);

    @Inject
    public View(CitiesListModel citiesListModel, EventBus eventBus) {
        this.citiesListModel = citiesListModel;
        this.eventBus = eventBus;
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
