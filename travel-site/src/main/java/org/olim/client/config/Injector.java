package org.olim.client.config;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import org.olim.client.LifeCycle;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);
    public LifeCycle getLifeCycle();
}
