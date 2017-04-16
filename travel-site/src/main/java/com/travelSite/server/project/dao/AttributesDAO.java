package com.travelSite.server.project.dao;

import com.travelSite.server.project.model.*;

import java.util.List;

public interface AttributesDAO {
    void saveAttribute(PkAttributesEntity pkAttributeEntity);

    List<PkAttributesEntity> findAllAttributes();

    PkAttributesEntity findAttributeById(int id);

    void deleteAttributeById(int id);
}
