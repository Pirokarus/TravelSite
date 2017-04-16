package com.travelSite.server.project.dao;

import com.travelSite.server.project.model.*;

import java.util.List;

public interface ObjectsDAO {

    void saveObject(PkObjectsEntity pkObjectsEntity);

    List<PkObjectsEntity> findAllObjects();

    PkObjectsEntity findObjectById(int id);

    void deleteObjectById(int id);

    List<PkObjectsEntity> findAllObjectsByObjectTypeId(int id);

}
