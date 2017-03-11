package org.olim.client.views;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface CityStyleRecources extends ClientBundle {

    public interface MyCss extends CssResource {
        String cityStyle();

        String background();

        String removeButton();
    }
    @Source("CityLine.css")
    MyCss style();
}
