package com.ElectionWebAdministration.web.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Candidate;
import com.ElectionWebAdministration.web.dao.ICandidateDAO;

@Service("candidateService")
@Transactional
public class CandidateService {

	@Autowired
	@Qualifier("candidateDAO")
	private ICandidateDAO candidateDAO;
	
	public Serializable createCandidate(Candidate candidate) {
		
		return candidateDAO.create(candidate);
		
	}
	
	public Candidate getCandidateById(long id) {
		
		return candidateDAO.get(id);
	}
	
	public boolean candidateExists(Candidate candidate) {
		try {
			if(candidateDAO.get(candidate.getId()) != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}
	
	public List<Candidate> getAllCandidates() {
		return candidateDAO.getAll();
	}
	
	public void deleteCandidate(long id) {
		candidateDAO.delete(id);
	}
}
