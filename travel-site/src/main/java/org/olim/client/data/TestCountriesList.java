package org.olim.client.data;

import java.util.ArrayList;
import java.util.List;

public class TestCountriesList {
    public List<CountryBox> getCountryBoxes(){
        List<CountryBox> out = new ArrayList<>();

        CountryBox Russia = new CountryBox("Russia");
        Russia.add("Moscow");
        Russia.add("Saint Petersburg");
        Russia.add("Nizhniy Novgorod");
        out.add(Russia);

        CountryBox Belarus = new CountryBox("Belarus");
        Belarus.add("Minsk");
        Belarus.add("Homyel");
        Belarus.add("Mahilyow");
        out.add(Belarus);

        CountryBox Kazakhstan = new CountryBox("Kazakhstan");
        Kazakhstan.add("Almaty");
        Kazakhstan.add("Astana");
        Kazakhstan.add("Shymkent");
        out.add(Kazakhstan);
        return out;
    }
}
