package com.ElectionWebAdministration.web.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface IDAO<T> {
	
	public List<T> getAll();
	public Serializable create(T model);
	public void delete(long id);
	public T get(long id);
	public void update(T model);
	public List<T> findByCriteria(Criteria searchCriteria);

}
