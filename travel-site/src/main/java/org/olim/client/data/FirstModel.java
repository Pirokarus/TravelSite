package org.olim.client.data;

import com.google.web.bindery.event.shared.HandlerRegistration;

public class FirstModel extends ModelBase {
    private String key;
    private String name;
    public void setData(String key,String name){
        if(this.key!=key&&this.name!=name){
            this.key=key;
            this.name=name;
            fireEvent(FirstModelChangedEvent.create());
        }
    }
    public final HandlerRegistration addFirstModelChangedHandler(FirstModelChangedEventHandler handler){
        return addHandler(FirstModelChangedEvent.TYPE,handler);
    }
}
