package com.travelSite.server.project.dao;

import com.travelSite.server.project.model.*;

import java.util.List;

public interface ObjectTypesDAO {

    void saveObjectType(PkObjectTypesEntity pkObjectTypesEntity);

    List<PkObjectTypesEntity> findAllObjectTypes();

    PkObjectTypesEntity findObjectTypeById(int id);

    void deleteObjectTypeById(int id);
}
