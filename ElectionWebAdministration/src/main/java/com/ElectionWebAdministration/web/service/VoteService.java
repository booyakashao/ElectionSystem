package com.ElectionWebAdministration.web.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Candidate;
import com.ElectionWebAdministration.web.be.Vote;
import com.ElectionWebAdministration.web.be.Voter;
import com.ElectionWebAdministration.web.dao.IVoteDAO;

@Service("voteService")
@Transactional
public class VoteService {

	@Autowired
	@Qualifier("voteDAO")
	private IVoteDAO voteDAO;
	
	public Serializable createVote(Vote vote) {
		return voteDAO.create(vote);
	}
	
	public void updateVote(Vote vote) {
		voteDAO.update(vote);
	}
	
	public Vote getVoteById(long id) {
		return voteDAO.get(id);
	}
	
	public boolean voteExists(Vote vote) {
		try {
			if(voteDAO.get(vote.getId()) != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public List<Vote> getAllVotes() {
		return voteDAO.getAll();
	}
	
	public void deleteVote(long id) {
		voteDAO.delete(id);
	}
	
	public boolean voterHasVote(Voter voter) {
		try {
			if(voteDAO.getVoteByUser(voter) != null) {
				return true;
			}
		} catch(Exception e) {
			return false;
		}
		
		return false;
	}
	
	public Vote getVoteByVoter(Voter voter) {
		return voteDAO.getVoteByUser(voter);
	}
	
	public int voteCount(Candidate candidate) {
		try {
			return voteDAO.getVotesForCandidate(candidate).size();
		} catch (Exception e) {
			return 0;
		}
	}
}
