package com.travelSite.server.database.dao;

import com.travelSite.server.database.model.*;

import java.util.List;

public interface ObjectTypesDAO {

    void saveObjectType(PkObjectTypesEntity pkObjectTypesEntity);

    List<PkObjectTypesEntity> findAllObjectTypes();

    PkObjectTypesEntity findObjectTypeById(int id);

    void deleteObjectTypeById(int id);
}
