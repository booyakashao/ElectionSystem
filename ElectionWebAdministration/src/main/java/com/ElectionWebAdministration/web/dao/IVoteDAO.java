package com.ElectionWebAdministration.web.dao;

import java.util.List;

import com.ElectionWebAdministration.web.be.Candidate;
import com.ElectionWebAdministration.web.be.Vote;
import com.ElectionWebAdministration.web.be.Voter;

public interface IVoteDAO extends IDAO<Vote>{
	public Vote getVoteByUser(Voter voter);
	public List<Vote> getVotesForCandidate(Candidate targetCandidate);
}
