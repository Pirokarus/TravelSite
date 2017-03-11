package org.olim.client.config;



import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import org.olim.client.data.CitiesListDownloadController;
import org.olim.client.data.CitiesListModel;
import org.olim.client.data.View;


public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(CitiesListModel.class).in(Singleton.class);
        bind(View.class).in(Singleton.class);
        bind(CitiesListDownloadController.class).in(Singleton.class);
    }
}
