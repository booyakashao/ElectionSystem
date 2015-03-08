package com.ElectionWebAdministration.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Role;

@Transactional
@Repository("roleDAO")
public class RoleDAO extends AbstractDAO<Role> implements IRoleDAO{

	public RoleDAO() {
		super(Role.class);
	}

	@Override
	public boolean roleExists(String roleName) {
		Criteria searchCriteria = super.getSession().createCriteria(Role.class)
				.add(Restrictions.eq("roleName", roleName))
				.setMaxResults(1);
		
		List<Role> foundRoleList = findByCriteria(searchCriteria);
		
		return foundRoleList.size() > 0;
	}

	@Override
	public Role findRoleByName(String roleName) {
		Criteria searchCriteria = super.getSession().createCriteria(Role.class)
				.add(Restrictions.eq("roleName", roleName))
				.setMaxResults(1);
		
		List<Role> foundRoleList = findByCriteria(searchCriteria);
		
		return foundRoleList.get(0);
	}

}
