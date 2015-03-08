package com.ElectionWebAdministration.web.dao;

import com.ElectionWebAdministration.web.be.Voter;

public interface IVoterDAO extends IDAO<Voter>{
	public Voter findByUsername(String username);
}
