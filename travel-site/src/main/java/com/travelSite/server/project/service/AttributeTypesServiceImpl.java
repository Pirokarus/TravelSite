package com.travelSite.server.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelSite.server.project.dao.AttributeTypesDAO;
import com.travelSite.server.project.model.*;

import javax.transaction.Transactional;
import java.util.List;


@Service("attributeTypesService")
@Transactional
public class AttributeTypesServiceImpl implements AttributeTypesService {

    @Autowired
    private AttributeTypesDAO attributeTypesDAO;

    public void saveAttributeType(PkAttributeTypesEntity pkAttributeTypesEntity) {
        attributeTypesDAO.saveAttributeType(pkAttributeTypesEntity);
    }

    public List<PkAttributeTypesEntity> findAllAttributeTypes() {
        return attributeTypesDAO.findAllAttributeTypes();
    }

    public PkAttributeTypesEntity findContactById(int id) {
        return attributeTypesDAO.findAttributeTypeById(id);
    }

    public void deleteAttributeTypeById(int id) {
        attributeTypesDAO.deleteAttributeTypeById(id);
    }
}
