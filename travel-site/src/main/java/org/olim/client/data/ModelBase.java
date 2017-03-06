package org.olim.client.data;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.HandlerRegistration;

import javax.inject.Inject;

public class ModelBase {

    private final EventBus eventBus;
@Inject
    public ModelBase(){
        this.eventBus = new SimpleEventBus();
    }

    protected final void fireEvent(Event<?> event) {
        this.eventBus.fireEvent(event);
    }


    protected final <H> HandlerRegistration addHandler(Event.Type<H> type, H handler) {
        return this.eventBus.addHandler(type, handler);
    }


}
