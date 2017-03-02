package org.olim.client.data;

import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class ModelBase {

    private final EventBus eventBus;

    public ModelBase(EventBus eventBus){
        this.eventBus = eventBus;
    }

    protected final void fireEvent(Event<?> event) {
        this.eventBus.fireEvent(event);
    }


    protected final <H> HandlerRegistration addHandler(Event.Type<H> type, H handler) {
        return this.eventBus.addHandler(type, handler);
    }


}
