package com.travelSite.server.database.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.travelSite.server.database.model.*;

import java.util.List;

@Repository("attributeBindsDAO")
public class AttributeBindsDAOIml extends AbstractDAO implements AttributeBindsDAO {

    public void saveAttributeBind(PkAttributeBindsEntity pkAttributeBindsEntity) {
        persist(pkAttributeBindsEntity);
    }

    public List<PkAttributeBindsEntity> findAllAttributeBinds() {
        Criteria criteria = getSession().createCriteria(PkAttributeBindsEntity.class);
        return (List<PkAttributeBindsEntity>)criteria.list();
    }

    public PkAttributeBindsEntity findAttributeBindById(int id) {
        Criteria criteria = getSession().createCriteria(PkAttributeBindsEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (PkAttributeBindsEntity) criteria.uniqueResult();
    }

    public void deleteAttributeBindById(int id) {
        Criteria criteria = getSession().createCriteria(PkAttributeBindsEntity.class);
        criteria.add(Restrictions.eq("id", id));
        delete((PkAttributeBindsEntity)criteria.uniqueResult());
    }

    public List<PkAttributeBindsEntity> findAttributeBindByObjectTypeId(int id) {
        Criteria criteria = getSession().createCriteria(PkAttributeBindsEntity.class);
        criteria.add(Restrictions.eq("object_type_id", id));
        return (List<PkAttributeBindsEntity>)criteria.list();
    }
}
