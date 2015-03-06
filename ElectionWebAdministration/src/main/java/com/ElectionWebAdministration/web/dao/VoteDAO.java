package com.ElectionWebAdministration.web.dao;

import com.ElectionWebAdministration.web.be.Vote;

public class VoteDAO extends AbstractDAO<Vote> implements IVoteDAO{

	public VoteDAO() {
		super(Vote.class);
	}

}
