package com.travelSite.server.database.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.travelSite.server.database.model.*;

import java.util.List;

@Repository("attributeTypesDAO")
public class AttributeTypesDAOImpl extends AbstractDAO implements AttributeTypesDAO {
    public void saveAttributeType(PkAttributeTypesEntity pkAttributeTypesEntity) {
        persist(pkAttributeTypesEntity);
    }

    public List<PkAttributeTypesEntity> findAllAttributeTypes() {
        Criteria criteria = getSession().createCriteria(PkAttributeTypesEntity.class);
        return (List<PkAttributeTypesEntity>)criteria.list();

    }

    public PkAttributeTypesEntity findAttributeTypeById(int id) {
        Criteria criteria = getSession().createCriteria(PkAttributeTypesEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (PkAttributeTypesEntity) criteria.uniqueResult();

    }

    public void deleteAttributeTypeById(int id) {
        Criteria criteria = getSession().createCriteria(PkAttributeTypesEntity.class);
        criteria.add(Restrictions.eq("id", id));
        delete((PkAttributeTypesEntity) criteria.uniqueResult());
    }
}
