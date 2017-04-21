package com.travelSite.client;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {
    @DefaultMessage("Add")
    String addButton();
    @DefaultMessage("Done")
    String doneButton();
    @DefaultMessage("citySelect")
    String citySelect();
    @DefaultMessage("inDateSelect")
    String inDateSelect();
    @DefaultMessage("outDateSelect")
    String outDateSelect();
}
