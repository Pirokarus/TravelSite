package com.travelSite.server.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelSite.server.project.dao.AttributeBindsDAO;
import com.travelSite.server.project.model.PkAttributeBindsEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service("attributeBindsService")
@Transactional
public class AttributeBindsServiceImpl implements AttributeBindsService{
    @Autowired
    private AttributeBindsDAO attributeBindsDAO;

    public void saveAttributeBind(PkAttributeBindsEntity pkAttributeBindsEntity) {
        attributeBindsDAO.saveAttributeBind(pkAttributeBindsEntity);
    }

    public List<PkAttributeBindsEntity> findAllAttributeBinds() {
        return attributeBindsDAO.findAllAttributeBinds();
    }

    public PkAttributeBindsEntity findAttributeBindById(int id) {
        return attributeBindsDAO.findAttributeBindById(id);
    }

    public void deleteAttributeBindById(int id) {
        attributeBindsDAO.deleteAttributeBindById(id);
    }

    public List<PkAttributeBindsEntity> findAttributeBindByObjectTypeId(int id) {
        return attributeBindsDAO.findAttributeBindByObjectTypeId(id);
    }
}
