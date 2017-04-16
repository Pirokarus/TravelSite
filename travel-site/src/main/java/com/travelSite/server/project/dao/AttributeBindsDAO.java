package com.travelSite.server.project.dao;

import com.travelSite.server.project.model.*;

import java.util.List;

public interface AttributeBindsDAO {

    void saveAttributeBind(PkAttributeBindsEntity pkAttributeBindsEntity);

    List<PkAttributeBindsEntity> findAllAttributeBinds();

    PkAttributeBindsEntity findAttributeBindById(int id);

    void deleteAttributeBindById(int id);

    List<PkAttributeBindsEntity> findAttributeBindByObjectTypeId(int id);

}
