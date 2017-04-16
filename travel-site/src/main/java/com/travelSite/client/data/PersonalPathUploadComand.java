package com.travelSite.client.data;

import com.google.gwt.event.shared.GwtEvent;

public class PersonalPathUploadComand extends GwtEvent<PersonalPathUploadComandHandler> {

    public final static Type<PersonalPathUploadComandHandler> TYPE = new Type<>();

    private PersonalPathUploadComand() {
    }

    public static PersonalPathUploadComand create() {
        return new PersonalPathUploadComand();
    }

    @Override
    public Type<PersonalPathUploadComandHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PersonalPathUploadComandHandler handler) {
        handler.onPersonalPathUploadComand(this);
    }
}
