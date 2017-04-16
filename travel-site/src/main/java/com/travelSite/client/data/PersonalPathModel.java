package com.travelSite.client.data;

import javax.inject.Inject;
import java.util.List;

public class PersonalPathModel extends ModelBase {

    private List<Station> cityList;

    @Inject
    public PersonalPathModel() {
    }

    public void setCityList(List<Station> cityList) {
        this.cityList = cityList;
    }
}
