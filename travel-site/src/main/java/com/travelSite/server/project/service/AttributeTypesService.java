package com.travelSite.server.project.service;

import com.travelSite.server.project.model.*;

import java.util.List;

public interface AttributeTypesService {

    void saveAttributeType(PkAttributeTypesEntity pkAttributeTypesEntity);

    List<PkAttributeTypesEntity> findAllAttributeTypes();

    PkAttributeTypesEntity findContactById(int id);

    void deleteAttributeTypeById(int id);

}
