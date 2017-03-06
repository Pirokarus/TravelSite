package org.olim.client.data;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class FirstModelChangedEvent extends GwtEvent<FirstModelChangedEventHandler> {
    public final static Type<FirstModelChangedEventHandler> TYPE = new Type<>();

    private FirstModelChangedEvent() {

    }

    public static FirstModelChangedEvent create() {
        return new FirstModelChangedEvent();
    }

    @Override
    public Type getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(FirstModelChangedEventHandler handler) {
        handler.onFirstModelChanged(this);
    }
}
