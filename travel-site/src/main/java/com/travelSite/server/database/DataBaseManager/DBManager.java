package com.travelSite.server.database.DataBaseManager;

import com.travelSite.shared.City;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.travelSite.server.database.config.SpringConfiguration;
import com.travelSite.server.database.model.PkObjectsEntity;
import com.travelSite.server.database.model.PkParamsEntity;
import com.travelSite.server.database.service.AttributesService;
import com.travelSite.server.database.service.ObjectTypesService;
import com.travelSite.server.database.service.ObjectsService;
import com.travelSite.server.database.service.ParamsService;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public void create(String cityName, String countryName, Double latitude, Double longitude, String local){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AttributesService attributesService = (AttributesService)context.getBean("attributesService");
        ObjectsService objectsService = (ObjectsService)context.getBean("objectsService");
        ObjectTypesService objectTypesService = (ObjectTypesService)context.getBean("objectTypesService");
        ParamsService paramsService = (ParamsService) context.getBean("paramsService");

        PkObjectsEntity citiObject = new PkObjectsEntity(cityName,objectTypesService.findObjectTypeById(1));
        objectsService.saveObject(citiObject);

        PkParamsEntity cityNameParam = new PkParamsEntity(cityName,citiObject,attributesService.findAttributeById(1));
        PkParamsEntity countryNameParam = new PkParamsEntity(countryName,citiObject,attributesService.findAttributeById(2));
        PkParamsEntity latitudeParam = new PkParamsEntity(latitude,citiObject,attributesService.findAttributeById(3));
        PkParamsEntity longitudeParam = new PkParamsEntity(longitude,citiObject,attributesService.findAttributeById(4));
        PkParamsEntity localParam = new PkParamsEntity(local,citiObject,attributesService.findAttributeById(5));

        paramsService.saveParam(cityNameParam);
        paramsService.saveParam(countryNameParam);
        paramsService.saveParam(latitudeParam);
        paramsService.saveParam(longitudeParam);
        paramsService.saveParam(localParam);
    }

    public List<City> getCitiesList(String local) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ObjectsService objectsService = (ObjectsService) context.getBean("objectsService");
        ParamsService paramsService = (ParamsService) context.getBean("paramsService");

        List<PkObjectsEntity> citiesObjectList = objectsService.findAllObjects();

        List<City> out = new ArrayList<City>();

        for (PkObjectsEntity cityObject : citiesObjectList) {
            if (cityObject.getPkObjectTypesByObjectTypeId().getObjectTypeId() == 1) {
                List<PkParamsEntity> cityParam = paramsService.findAllParamsByObjectId(cityObject.getObjectId());
                String cityName = "";
                String countryName = "";
                Double latitude = 0.;
                Double longitude = 0.;
                String thisLocal = "";
                for (PkParamsEntity param : cityParam) {

                    switch (param.getPkAttributesByAttributeId().getAttributeId()) {
                        case 1:
                            cityName = param.getTextValue();
                            break;
                        case 2:
                            countryName = param.getTextValue();
                            break;
                        case 3:
                            latitude = param.getNumberValue();
                            break;
                        case 4:
                            longitude = param.getNumberValue();
                            break;
                        case 5:
                            thisLocal = param.getTextValue();
                            break;
                    }
                    if (!cityName.equals("") && !countryName.equals("") && !latitude.equals(0.) && !longitude.equals(0.) && !thisLocal.equals("")) {
                        if (local.equals(thisLocal)) {
                            out.add(new City(cityName, countryName, latitude, longitude));
                        }
                    }
                }
            }
        }
        return out;
    }
}
