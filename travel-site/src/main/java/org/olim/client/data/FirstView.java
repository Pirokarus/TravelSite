package org.olim.client.data;

import com.google.gwt.user.client.ui.Composite;

import javax.inject.Inject;

public class FirstView extends Composite {
    @Inject
    public FirstView(FirstModel firstModel){
        firstModel.addFirstModelChangedHandler(new MyFirstModelChangedHandler());

    }

    private class MyFirstModelChangedHandler implements FirstModelChangedEventHandler{
        @Override
        public void onFirstModelChanged(FirstModelChangedEvent event) {
            //implementation
        }
    }
}
