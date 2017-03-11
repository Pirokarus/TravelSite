package org.olim.client;


import com.google.web.bindery.event.shared.EventBus;
import org.olim.client.data.CitiesListDownloadController;
import org.olim.client.data.CitiesListModel;
import org.olim.client.data.CitiesModelLoadCommand;
import org.olim.client.data.View;

import javax.inject.Inject;

public class LifeCycle {
    private EventBus eventBus;
    private CitiesListModel citiesListModel;
    private View view;
    private CitiesListDownloadController citiesListDownloadController;

    @Inject
    public LifeCycle(EventBus eventBus, CitiesListModel citiesListModel, View view, CitiesListDownloadController citiesListDownloadController) {
        this.eventBus = eventBus;
        this.citiesListDownloadController = citiesListDownloadController;
        this.citiesListModel = citiesListModel;
        this.view = view;

    }

    public void start(){
        eventBus.fireEvent(CitiesModelLoadCommand.create());

    }

}
