package com.travelSite.server.project.DataBaseManager;



import com.travelSite.server.project.config.SpringConfiguration;
import com.travelSite.server.project.model.PkObjectsEntity;
import com.travelSite.server.project.service.ObjectsService;
import com.travelSite.server.project.service.ParamsService;
import com.travelSite.shared.CityBox;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class test {

    public static void main(String[] args) {

        DBManager dbManager = new DBManager();

        List<CityBox> cityBoxList = dbManager.getCitiesList("en");
/*
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ObjectsService objectsService = (ObjectsService) context.getBean("objectsService");
        ParamsService paramsService = (ParamsService) context.getBean("paramsService");

        List<PkObjectsEntity> citiesObjectList = objectsService.findAllObjects();
*/
        System.out.println(cityBoxList);
    }
}
