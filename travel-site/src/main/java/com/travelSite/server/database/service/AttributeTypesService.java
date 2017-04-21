package com.travelSite.server.database.service;

import com.travelSite.server.database.model.*;

import java.util.List;

public interface AttributeTypesService {

    void saveAttributeType(PkAttributeTypesEntity pkAttributeTypesEntity);

    List<PkAttributeTypesEntity> findAllAttributeTypes();

    PkAttributeTypesEntity findContactById(int id);

    void deleteAttributeTypeById(int id);

}
