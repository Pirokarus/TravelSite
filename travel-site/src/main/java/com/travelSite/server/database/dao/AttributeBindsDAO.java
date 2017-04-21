package com.travelSite.server.database.dao;

import com.travelSite.server.database.model.*;

import java.util.List;

public interface AttributeBindsDAO {

    void saveAttributeBind(PkAttributeBindsEntity pkAttributeBindsEntity);

    List<PkAttributeBindsEntity> findAllAttributeBinds();

    PkAttributeBindsEntity findAttributeBindById(int id);

    void deleteAttributeBindById(int id);

    List<PkAttributeBindsEntity> findAttributeBindByObjectTypeId(int id);

}
