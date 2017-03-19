package org.olim.client.data;

import com.google.gwt.core.client.GWT;
import org.olim.client.AppMessages;

import java.util.ArrayList;
import java.util.List;

public class TestCountriesList {
    private AppMessages messages = GWT.create(AppMessages.class);

    public List<CountryBox> getCountryBoxes() {
        List<CountryBox> out = new ArrayList<>();

        CountryBox Russia = new CountryBox(messages.russia());
        Russia.add(messages.moscow());
        Russia.add(messages.saintPetersburg());
        Russia.add(messages.nizhnyNovgorod());
        out.add(Russia);

        CountryBox Belarus = new CountryBox(messages.belarus());
        Belarus.add(messages.minsk());
        Belarus.add(messages.mogilev());
        Belarus.add(messages.gomel());
        out.add(Belarus);

        CountryBox Kazakhstan = new CountryBox(messages.kazakhstan());
        Kazakhstan.add(messages.almaty());
        Kazakhstan.add(messages.astana());
        Kazakhstan.add(messages.shymkent());
        out.add(Kazakhstan);
        return out;
    }
}
