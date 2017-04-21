package com.travelSite.client.service;

import com.travelSite.shared.City;
import com.travelSite.shared.Locale;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/rest")
public interface EndPoint extends RestService{
    @GET
    @Path("/load")
    void  getCitiesList(MethodCallback<List<City>> callback);
}
