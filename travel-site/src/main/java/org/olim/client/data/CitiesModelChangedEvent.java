package org.olim.client.data;

import com.google.gwt.event.shared.GwtEvent;

public class CitiesModelChangedEvent extends GwtEvent<CitiesModelChangedEventHandler> {
    public final static Type<CitiesModelChangedEventHandler> TYPE = new Type<>();

    private CitiesModelChangedEvent() {

    }

    public static CitiesModelChangedEvent create() {
        return new CitiesModelChangedEvent();
    }

    @Override
    public Type getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CitiesModelChangedEventHandler handler) {
        handler.onCitiesModelChanged(this);
    }
}
