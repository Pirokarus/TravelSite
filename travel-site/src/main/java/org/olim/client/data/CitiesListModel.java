package org.olim.client.data;


import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

import javax.inject.Inject;
import java.util.List;

public class CitiesListModel extends ModelBase {

    private List<CountryBox> countries;

    public void setData(List<CountryBox> countries){
        if(this.countries!=countries){
            this.countries=countries;

            fireEvent(CitiesModelChangedEvent.create());
        }
    }

    public List<CountryBox> getData(){
        return countries;
    }



    @Inject
    public CitiesListModel(EventBus eventBus){

    }

    public final HandlerRegistration addFirstModelChangedHandler(CitiesModelChangedEventHandler handler){
        return addHandler(CitiesModelChangedEvent.TYPE,handler);
    }

}
