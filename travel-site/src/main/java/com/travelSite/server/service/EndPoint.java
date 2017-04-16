package com.travelSite.server.service;

import com.travelSite.server.project.DataBaseManager.DBManager;
import com.travelSite.shared.CityBox;
import com.travelSite.shared.Req;
import com.travelSite.shared.TestCountriesList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/load")
public class EndPoint {
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityBox> getCitiesList(Req req){

        List<CityBox> cityList = new DBManager().getCitiesList("en");

        //List<CityBox> cityList = new TestCountriesList().getCityBoxes();


        return cityList;
    }

}
