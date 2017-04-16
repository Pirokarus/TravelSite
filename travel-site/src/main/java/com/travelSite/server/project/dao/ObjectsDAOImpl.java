package com.travelSite.server.project.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.travelSite.server.project.model.*;

import java.util.List;

@Repository("objectsDAO")
public class ObjectsDAOImpl extends AbstractDAO implements ObjectsDAO {
    public void saveObject(PkObjectsEntity pkObjectsEntity) {
        persist(pkObjectsEntity);
    }

    public List<PkObjectsEntity> findAllObjects() {
        Criteria criteria = getSession().createCriteria(PkObjectsEntity.class);
        return (List<PkObjectsEntity>)criteria.list();
    }

    public PkObjectsEntity findObjectById(int id) {
        Criteria criteria = getSession().createCriteria(PkObjectsEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (PkObjectsEntity) criteria.uniqueResult();
    }

    public void deleteObjectById(int id) {
        delete(findObjectById(id));
    }

    public List<PkObjectsEntity> findAllObjectsByObjectTypeId(int id) {
        Criteria criteria = getSession().createCriteria(PkObjectsEntity.class);
        criteria.add(Restrictions.eq("object_type_id", id));
        return (List<PkObjectsEntity>)criteria.list();
    }
}
