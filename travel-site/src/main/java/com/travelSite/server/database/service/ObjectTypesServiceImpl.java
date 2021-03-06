package com.travelSite.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelSite.server.database.dao.*;
import com.travelSite.server.database.model.PkObjectTypesEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service("objectTypesService")
@Transactional
public class ObjectTypesServiceImpl implements ObjectTypesService {

    @Autowired
    private ObjectTypesDAO objectTypesDAO;

    public void saveObjectType(PkObjectTypesEntity pkObjectTypesEntity) {
        objectTypesDAO.saveObjectType(pkObjectTypesEntity);
    }

    public List<PkObjectTypesEntity> findAllObjectTypes() {
        return objectTypesDAO.findAllObjectTypes();
    }

    public PkObjectTypesEntity findObjectTypeById(int id) {
        return objectTypesDAO.findObjectTypeById(id);
    }

    public void deleteObjectTypeById(int id) {
        objectTypesDAO.deleteObjectTypeById(id);
    }
}
