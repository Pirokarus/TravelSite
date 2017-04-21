package com.travelSite.client.data;

import javax.inject.Inject;
import java.util.List;

public class PersonalPathModel extends ModelBase {

    private List<Location> cityList;

    @Inject
    public PersonalPathModel() {
    }

    public void setCityList(List<Location> cityList) {
        this.cityList = cityList;
    }
}
