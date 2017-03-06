package org.olim.client.data;

import com.google.gwt.inject.rebind.GinjectorInterfaceType;
import com.google.gwt.user.client.ui.*;
import org.olim.client.config.Injector;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

public class FirstView extends HorizontalPanel {

    private static FirstModel firstModel;

    @Inject
    public FirstView(FirstModel firstModel){
        this.firstModel = firstModel;
        firstModel.addFirstModelChangedHandler(new MyFirstModelChangedHandler());



    }



    private class MyFirstModelChangedHandler implements FirstModelChangedEventHandler{
        @Override
        public void onFirstModelChanged(FirstModelChangedEvent event) {
            //implementation


            //add(new Label(firstModel.getData()));
            RootPanel.get("MyTravelFieldContainer").add(new Label(firstModel.getData()));

        }
    }
}
