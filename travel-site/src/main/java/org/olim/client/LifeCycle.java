package org.olim.client;


import com.google.web.bindery.event.shared.EventBus;
import org.olim.client.data.*;

import javax.inject.Inject;

public class LifeCycle {
    private EventBus eventBus;
    private CitiesListModel citiesListModel;
    private View view;
    private CitiesListDownloadController citiesListDownloadController;
    private PersonalPathModel pathModel;
    private PersonalPathController pathController;

    @Inject
    public LifeCycle(EventBus eventBus, CitiesListModel citiesListModel, View view, CitiesListDownloadController citiesListDownloadController, PersonalPathModel pathModel, PersonalPathController pathController) {
        this.eventBus = eventBus;
        this.citiesListModel = citiesListModel;
        this.view = view;
        this.citiesListDownloadController = citiesListDownloadController;
        this.pathModel = pathModel;
        this.pathController = pathController;
    }

    public void start() {
        eventBus.fireEvent(CitiesModelLoadCommand.create());

    }

}
