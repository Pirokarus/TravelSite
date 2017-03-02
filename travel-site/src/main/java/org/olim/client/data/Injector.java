package org.olim.client.data;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.web.bindery.event.shared.EventBus;

@GinModules(InjectorModule.class)
public interface Injector {
    public static final Injector INSTANCE = GWT.create(Injector.class);
    public EventBus getEventBus();
    public CitiesModel getCitiesModel();
}
