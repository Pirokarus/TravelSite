package org.olim.client.data;

import com.google.gwt.event.shared.GwtEvent;

public class FirstModelLoadCommand extends GwtEvent<FirstModelLoadCommandHandler> {

    public final static Type<FirstModelLoadCommandHandler> TYPE = new Type<>();

    private FirstModelLoadCommand(){}

    public static FirstModelLoadCommand create(){
        return new FirstModelLoadCommand();
    }

    @Override
    public Type getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(FirstModelLoadCommandHandler handler) {
        handler.onFirstModelLoadComand(this);
    }
}
