package org.olim.client;


import com.google.web.bindery.event.shared.EventBus;
import org.olim.client.data.FirstController;
import org.olim.client.data.FirstModel;
import org.olim.client.data.FirstModelLoadCommand;
import org.olim.client.data.FirstView;

import javax.inject.Inject;

public class LifeCycle {
    public EventBus eventBus;
    public FirstModel firstModel;
    public FirstView firstView;
    public FirstController firstController;

    @Inject
    public LifeCycle(EventBus eventBus, FirstModel firstModel, FirstView firstView, FirstController firstController) {
        this.eventBus = eventBus;
        this.firstModel = firstModel;
        this.firstView = firstView;
        this.firstController = firstController;
    }

    public void start(){
        eventBus.fireEvent(FirstModelLoadCommand.create());

    }

}
