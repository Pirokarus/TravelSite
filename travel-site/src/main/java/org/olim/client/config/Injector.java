package org.olim.client.config;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.web.bindery.event.shared.EventBus;
import org.olim.client.data.CitiesModel;
import org.olim.client.data.FirstController;
import org.olim.client.data.FirstModel;
import org.olim.client.data.FirstView;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);
    public EventBus getEventBus();
    public FirstModel getFirstModel();
    public FirstView getFirstView();
    public FirstController getFirstController();
}
