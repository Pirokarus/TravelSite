package org.olim.client.data;




import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;

public class FirstController {

    private static FirstModel firstModel;
    private final EventBus eventBus;

    @Inject
    public FirstController(FirstModel firstModel, EventBus eventBus){
        this.firstModel = firstModel;
        this.eventBus = eventBus;
        eventBus.addHandler(FirstModelLoadCommand.TYPE,new MyFirstModelCommandHandler());

    }

    private class MyFirstModelCommandHandler implements FirstModelLoadCommandHandler {

        @Override
        public void onFirstModelLoadComand(FirstModelLoadCommand command) {

            firstModel.setData("olim");

        }
    }
}
