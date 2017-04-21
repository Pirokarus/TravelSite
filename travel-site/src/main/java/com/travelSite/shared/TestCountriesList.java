package com.travelSite.shared;

import java.util.ArrayList;
import java.util.List;

public class TestCountriesList {
    //private AppMessages messages = GWT.create(AppMessages.class);

    public List<City> getCityBoxes() {
        List<City> out = new ArrayList<>();


        out.add(new City("moscow","russia",55.7494733,37.3523219));
        out.add(new City("saintPetersburg","russia",59.9171483,30.0448872));
        out.add(new City("nizhnyNovgorod","russia",56.2926609,43.786664));


        out.add(new City("minsk","belarus",53.8838069,27.4548925));
        out.add(new City("mogilev","belarus",53.8834808,30.2114953));
        /*
        Belarus.add(new City(messages.gomel(),52.4228951,30.8459554));
        out.add(Belarus);

        ountryBox Kazakhstan = new ountryBox(messages.kazakhstan());
        Kazakhstan.add(new City(messages.almaty(),43.2171382,76.8040822));
        Kazakhstan.add(new City(messages.astana(),51.147862,71.3393078));
        out.add(Kazakhstan);
        */
        return out;
    }
}
