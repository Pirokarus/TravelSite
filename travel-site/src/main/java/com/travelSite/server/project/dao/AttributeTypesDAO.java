package com.travelSite.server.project.dao;

import com.travelSite.server.project.model.*;

import java.util.List;

/**
 * Created by glak0514 on 27.03.2017.
 */
public interface AttributeTypesDAO {

    void saveAttributeType(PkAttributeTypesEntity pkAttributeTypesEntity);

    List<PkAttributeTypesEntity> findAllAttributeTypes();

    PkAttributeTypesEntity findAttributeTypeById(int id);

    void deleteAttributeTypeById(int id);

}

