package com.travelSite.server.database.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.travelSite.server.database.model.*;

import java.util.List;

@Repository("paramsDAO")
public class ParamsDAOImpl extends AbstractDAO implements ParamsDAO {
    public void saveParam(PkParamsEntity pkParamsEntity) {
        persist(pkParamsEntity);
    }

    public List<PkParamsEntity> findAllParams() {
        Criteria criteria = getSession().createCriteria(PkParamsEntity.class);
        return (List<PkParamsEntity>)criteria.list();
    }

    public PkParamsEntity findParamById(int id) {
        Criteria criteria = getSession().createCriteria(PkParamsEntity.class);
        criteria.add(Restrictions.eq("id", id));
        return (PkParamsEntity) criteria.uniqueResult();
    }

    public void deleteParamById(int id) {
        delete(findParamById(id));
    }

    public List<PkParamsEntity> findAllParamsByObjectId(int id) {
        Criteria criteria = getSession().createCriteria(PkParamsEntity.class);
        criteria.add(Restrictions.eq("object_id", id));
        return (List<PkParamsEntity>)criteria.list();

    }

    public void deleteAllParamsByObjectId(int id) {
        for(PkParamsEntity pkParamsEntity:findAllParamsByObjectId(id)){
            delete(pkParamsEntity);
        }
    }
}
