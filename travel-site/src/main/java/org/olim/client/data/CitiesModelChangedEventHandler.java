package org.olim.client.data;

import com.google.gwt.event.shared.EventHandler;

public interface CitiesModelChangedEventHandler extends EventHandler {
    void onFirstModelChanged(CitiesModelChangedEvent event);
}
