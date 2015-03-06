package com.ElectionWebAdministration.web.dao;

import com.ElectionWebAdministration.web.be.Voter;

public class VoterDAO extends AbstractDAO<Voter> implements IVoterDAO{

	public VoterDAO() {
		super(Voter.class);
	}

}
