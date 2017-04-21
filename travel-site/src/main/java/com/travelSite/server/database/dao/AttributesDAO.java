package com.travelSite.server.database.dao;

import com.travelSite.server.database.model.*;

import java.util.List;

public interface AttributesDAO {
    void saveAttribute(PkAttributesEntity pkAttributeEntity);

    List<PkAttributesEntity> findAllAttributes();

    PkAttributesEntity findAttributeById(int id);

    void deleteAttributeById(int id);
}
