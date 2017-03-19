package org.olim.client.data;

import com.google.gwt.event.shared.GwtEvent;

public class CitiesModelLoadCommand extends GwtEvent<CitiesModelLoadCommandHandler> {

    public final static Type<CitiesModelLoadCommandHandler> TYPE = new Type<>();

    private CitiesModelLoadCommand() {
    }

    public static CitiesModelLoadCommand create() {
        return new CitiesModelLoadCommand();
    }

    @Override
    public Type getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CitiesModelLoadCommandHandler handler) {
        handler.onCitiesModelLoadComand(this);
    }
}
