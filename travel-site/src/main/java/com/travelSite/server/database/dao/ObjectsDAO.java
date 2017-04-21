package com.travelSite.server.database.dao;

import com.travelSite.server.database.model.*;

import java.util.List;

public interface ObjectsDAO {

    void saveObject(PkObjectsEntity pkObjectsEntity);

    List<PkObjectsEntity> findAllObjects();

    PkObjectsEntity findObjectById(int id);

    void deleteObjectById(int id);

    List<PkObjectsEntity> findAllObjectsByObjectTypeId(int id);

}
