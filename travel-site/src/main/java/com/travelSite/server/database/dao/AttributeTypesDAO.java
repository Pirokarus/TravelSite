package com.travelSite.server.database.dao;

import com.travelSite.server.database.model.*;

import java.util.List;

public interface AttributeTypesDAO {

    void saveAttributeType(PkAttributeTypesEntity pkAttributeTypesEntity);

    List<PkAttributeTypesEntity> findAllAttributeTypes();

    PkAttributeTypesEntity findAttributeTypeById(int id);

    void deleteAttributeTypeById(int id);

}

