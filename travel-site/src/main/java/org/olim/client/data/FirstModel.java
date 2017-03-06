package org.olim.client.data;

import com.google.web.bindery.event.shared.HandlerRegistration;

import javax.inject.Inject;

public class FirstModel extends ModelBase {
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

    public void start(){
        fireEvent(FirstModelLoadCommand.create());

    }

    @Inject
    public FirstModel(){}

    public final HandlerRegistration addFirstModelChangedHandler(FirstModelChangedEventHandler handler){
        return addHandler(FirstModelChangedEvent.TYPE,handler);
    }
    public final HandlerRegistration addFirstModelComandHandler(FirstModelLoadCommandHandler handler){
        return addHandler(FirstModelLoadCommand.TYPE,handler);
    }
}
