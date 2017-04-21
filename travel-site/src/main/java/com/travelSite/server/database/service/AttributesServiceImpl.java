package com.travelSite.server.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelSite.server.database.dao.AttributesDAO;
import com.travelSite.server.database.model.PkAttributesEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service("attributesService")
@Transactional
public class AttributesServiceImpl implements AttributesService {

    @Autowired
    private AttributesDAO attributesDAO;

    public void saveAttribute(PkAttributesEntity pkAttributeEntity) {
        attributesDAO.saveAttribute(pkAttributeEntity);
    }

    public List<PkAttributesEntity> findAllAttributes() {
        return attributesDAO.findAllAttributes();
    }

    public PkAttributesEntity findAttributeById(int id) {
        return attributesDAO.findAttributeById(id);
    }

    public void deleteAttributeById(int id) {
        attributesDAO.deleteAttributeById(id);
    }
}
