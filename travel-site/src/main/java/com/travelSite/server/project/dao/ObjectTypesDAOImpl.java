package com.travelSite.server.project.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.travelSite.server.project.model.*;

import java.util.List;

@Repository("objectTypesDAO")
public class ObjectTypesDAOImpl extends AbstractDAO implements ObjectTypesDAO {
    public void saveObjectType(PkObjectTypesEntity pkObjectTypesEntity) {
        persist(pkObjectTypesEntity);
    }

    public List<PkObjectTypesEntity> findAllObjectTypes() {
        Criteria criteria = getSession().createCriteria(PkObjectTypesEntity.class);
        return (List<PkObjectTypesEntity>)criteria.list();
    }

    public PkObjectTypesEntity findObjectTypeById(int id) {
        Criteria criteria = getSession().createCriteria(PkObjectTypesEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (PkObjectTypesEntity) criteria.uniqueResult();
    }

    public void deleteObjectTypeById(int id) {
        delete(findObjectTypeById(id));
    }
}
