package com.ElectionWebAdministration.web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Vote;

@Transactional
@Repository("voteDAO")
public class VoteDAO extends AbstractDAO<Vote> implements IVoteDAO{

	public VoteDAO() {
		super(Vote.class);
	}

}
