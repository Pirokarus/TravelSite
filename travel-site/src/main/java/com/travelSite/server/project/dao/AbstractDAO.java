package com.travelSite.server.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by glak0514 on 27.03.2017.
 */
public class AbstractDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity){
        getSession().persist(entity);
    }

    public void delete(Object entity){
        getSession().delete(entity);
    }
}

