package org.olim.client.data;


import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

import javax.inject.Inject;

public class FirstModel extends ModelBase {
    private final EventBus eventBus;
    private String key;

    public void setData(String key){
        if(this.key!=key){
            this.key=key;

            fireEvent(FirstModelChangedEvent.create());
        }
    }

    public String getData(){
        return key;
    }



    @Inject
    public FirstModel(EventBus eventBus){
        this.eventBus = eventBus;
    }

    public final HandlerRegistration addFirstModelChangedHandler(FirstModelChangedEventHandler handler){
        return addHandler(FirstModelChangedEvent.TYPE,handler);
    }

}
