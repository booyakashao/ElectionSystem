package com.ElectionWebAdministration.web.dao;

import com.ElectionWebAdministration.web.be.Role;

public interface IRoleDAO extends IDAO<Role>{
	public boolean roleExists(String roleName);
	public Role findRoleByName(String roleName);
}
