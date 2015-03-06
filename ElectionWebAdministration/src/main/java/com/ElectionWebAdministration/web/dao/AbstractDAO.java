package com.ElectionWebAdministration.web.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO<T extends Serializable> implements IDAO<T> {
private static Logger logger = Logger.getLogger(AbstractDAO.class);
	
	Class<T> clazz;
	
	public AbstractDAO (Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	@Override
	public List<T> getAll() {
		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}
	
	@Override
	public Serializable create(T entity) {
		return getSession().save(entity);
	}
	
	@Override
	public void update(T model) {
		getSession().update(model);
	}
	
	@Override
	public void delete(long id) {
		getSession().delete(get(id));
	}
	
	@Override
	public T get(long id) {
		return (T) getSession().load(clazz, id);
	}
	
	@Override
	public List<T> findByCriteria(Criteria searchCriteria) {
		return searchCriteria.list();
	}
}
