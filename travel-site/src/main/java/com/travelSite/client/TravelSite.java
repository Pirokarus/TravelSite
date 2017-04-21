package com.travelSite.client;

import com.google.gwt.core.client.EntryPoint;
import com.travelSite.client.config.Injector;

public class TravelSite implements EntryPoint {

    public void onModuleLoad() {
        final Injector injector = Injector.INSTANCE;
        injector.getLifeCycle().start();
        }
}
