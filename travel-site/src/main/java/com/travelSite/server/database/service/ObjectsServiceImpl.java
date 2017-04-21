package com.travelSite.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelSite.server.database.dao.ObjectsDAO;
import com.travelSite.server.database.model.PkObjectsEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service("objectsService")
@Transactional
public class ObjectsServiceImpl implements ObjectsService {

    @Autowired
    private ObjectsDAO objectsDAO;

    public void saveObject(PkObjectsEntity pkObjectsEntity) {
        objectsDAO.saveObject(pkObjectsEntity);
    }

    public List<PkObjectsEntity> findAllObjects() {
        return objectsDAO.findAllObjects();
    }

    public PkObjectsEntity findObjectById(int id) {
        return objectsDAO.findObjectById(id);
    }

    public void deleteObjectById(int id) {
        objectsDAO.deleteObjectById(id);
    }

    public List<PkObjectsEntity> findAllObjectsByObjectTypeId(int id) {
        return objectsDAO.findAllObjectsByObjectTypeId(id);
    }
}
