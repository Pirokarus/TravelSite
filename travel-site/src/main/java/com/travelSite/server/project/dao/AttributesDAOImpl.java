package com.travelSite.server.project.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.travelSite.server.project.model.*;

import java.util.List;

@Repository("attributesDAO")
public class AttributesDAOImpl extends AbstractDAO implements AttributesDAO {
    public void saveAttribute(PkAttributesEntity pkAttributeEntity) {
        persist(pkAttributeEntity);
    }

    public List<PkAttributesEntity> findAllAttributes() {
        Criteria criteria = getSession().createCriteria(PkAttributesEntity.class);
        return (List<PkAttributesEntity>)criteria.list();
    }

    public PkAttributesEntity findAttributeById(int id) {
        Criteria criteria = getSession().createCriteria(PkAttributesEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (PkAttributesEntity) criteria.uniqueResult();
    }

    public void deleteAttributeById(int id) {
        Criteria criteria = getSession().createCriteria(PkAttributesEntity.class);
        criteria.add(Restrictions.eq("id", id));
        delete((PkAttributesEntity)criteria.uniqueResult());
    }
}
