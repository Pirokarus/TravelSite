package org.olim.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class CityLine extends Composite {
    private static CityLineUiBinder uiBinder =
            GWT.create(CityLineUiBinder.class);

    @UiTemplate("CityLine.ui.xml")
    interface CityLineUiBinder extends UiBinder<Widget, CityLine> {
    }

    @UiField(provided = true)
    final CityStyleRecources res;
    public CityLine() {
        this.res = GWT.create(CityStyleRecources.class);
        res.style().ensureInjected();
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiField(provided = true)
    SuggestBox cityField;
    @UiField
    DateLabel inDateField;
    @UiField
    DateLabel outDateField;
}