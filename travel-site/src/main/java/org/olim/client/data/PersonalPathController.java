package org.olim.client.data;

import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;

public class PersonalPathController {

    private EventBus eventBus;
    private PersonalPathModel pathModel;
    private View view;

    @Inject
    public PersonalPathController(EventBus eventBus, PersonalPathModel pathModel, View view) {
        this.eventBus = eventBus;
        this.pathModel = pathModel;
        this.view = view;
        eventBus.addHandler(PersonalPathUploadComand.TYPE, new myPersonalPathUploadComandHandler());
    }

    private class myPersonalPathUploadComandHandler implements PersonalPathUploadComandHandler {

        @Override
        public void onPersonalPathUploadComand(PersonalPathUploadComand command) {

            pathModel.setCityList(view.getPath());
        }
    }
}
