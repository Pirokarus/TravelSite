package com.travelSite.server.project.DataBaseManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.travelSite.server.project.config.SpringConfiguration;
import com.travelSite.server.project.model.*;
import com.travelSite.server.project.service.*;

public class BaseDB {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AttributeTypesService attributeTypesService = (AttributeTypesService) context.getBean("attributeTypesService");
        AttributeBindsService attributeBindsService = (AttributeBindsService) context.getBean("attributeBindsService");
        AttributesService attributesService = (AttributesService)context.getBean("attributesService");
        ObjectsService objectsService = (ObjectsService)context.getBean("objectsService");
        ObjectTypesService objectTypesService = (ObjectTypesService)context.getBean("objectTypesService");
        ParamsService paramsService = (ParamsService) context.getBean("paramsService");

        PkObjectTypesEntity cityObjectType = new PkObjectTypesEntity("City");
        objectTypesService.saveObjectType(cityObjectType);

        PkAttributeTypesEntity stringField = new PkAttributeTypesEntity("String Field");
        PkAttributeTypesEntity numField = new PkAttributeTypesEntity("Number Field");
        attributeTypesService.saveAttributeType(stringField);
        attributeTypesService.saveAttributeType(numField);

        PkAttributesEntity cityNameAttribute = new PkAttributesEntity("City Name",stringField);
        PkAttributesEntity countryNameAttribute = new PkAttributesEntity("Country Name",stringField);
        PkAttributesEntity cityLatitudeAttribute = new PkAttributesEntity("Latitude", numField);
        PkAttributesEntity cityLongitudeAttribute = new PkAttributesEntity("Longitude",numField);
        PkAttributesEntity localAttribute = new PkAttributesEntity("Localization",stringField);

        attributesService.saveAttribute(cityNameAttribute);
        attributesService.saveAttribute(countryNameAttribute);
        attributesService.saveAttribute(cityLatitudeAttribute);
        attributesService.saveAttribute(cityLongitudeAttribute);
        attributesService.saveAttribute(localAttribute);


        PkAttributeBindsEntity cityNameBind = new PkAttributeBindsEntity(cityObjectType,cityNameAttribute);
        PkAttributeBindsEntity countryNameBind = new PkAttributeBindsEntity(cityObjectType,countryNameAttribute);
        PkAttributeBindsEntity cityLatitudeBind = new PkAttributeBindsEntity(cityObjectType,cityLatitudeAttribute);
        PkAttributeBindsEntity cityLongitudeBind = new PkAttributeBindsEntity(cityObjectType,cityLongitudeAttribute);
        PkAttributeBindsEntity localBind = new PkAttributeBindsEntity(cityObjectType,localAttribute);

        attributeBindsService.saveAttributeBind(cityNameBind);
        attributeBindsService.saveAttributeBind(countryNameBind);
        attributeBindsService.saveAttributeBind(cityLatitudeBind);
        attributeBindsService.saveAttributeBind(cityLongitudeBind);
        attributeBindsService.saveAttributeBind(localBind);
/*
        PkObjectsEntity moscowObject = new PkObjectsEntity("Moscow",cityObjectType);

        objectsService.saveObject(moscowObject);

        PkParamsEntity moscowNameParam = new PkParamsEntity("Moscow",moscowObject,cityNameAttribute);
        PkParamsEntity moscowCountryParam = new PkParamsEntity("Russia",moscowObject,countryNameAttribute);
        PkParamsEntity moscowLatitudeParam = new PkParamsEntity(55.7494733,moscowObject,cityLatitudeAttribute);
        */



    }
}
