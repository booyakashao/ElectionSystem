package com.ElectionWebAdministration.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Candidate;
import com.ElectionWebAdministration.web.be.Vote;
import com.ElectionWebAdministration.web.be.Voter;

@Transactional
@Repository("voteDAO")
public class VoteDAO extends AbstractDAO<Vote> implements IVoteDAO{

	public VoteDAO() {
		super(Vote.class);
	}

	public Vote getVoteByUser(Voter voter) {
		Criteria voterIdSearchCriteria = this.getSession().createCriteria(Vote.class)
				.add(Restrictions.eq("voter", voter))
				.setMaxResults(1);
		
		if(findByCriteria(voterIdSearchCriteria).isEmpty()) {
			return null;
		}
		
		return findByCriteria(voterIdSearchCriteria).get(0);
	}
	
	public List<Vote> getVotesForCandidate(Candidate targetCandidate) {
		Criteria votesSearchCriteria = this.getSession().createCriteria(Vote.class)
				.add(Restrictions.eq("candidate", targetCandidate));
		
		if(findByCriteria(votesSearchCriteria).isEmpty()) {
			return null;
		}
		
		return findByCriteria(votesSearchCriteria);
	}
}
