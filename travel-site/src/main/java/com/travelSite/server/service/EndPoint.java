package com.travelSite.server.service;

import com.travelSite.server.database.DataBaseManager.DBManager;
import com.travelSite.shared.City;
import com.travelSite.shared.Locale;
import com.travelSite.shared.TestCountriesList;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@Path("/load")
public class EndPoint {
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCitiesList(){

        List<City> cityList = new DBManager().getCitiesList("en");


        //List<City> cityList = new TestCountriesList().getCityBoxes();

        return cityList;
    }

}
