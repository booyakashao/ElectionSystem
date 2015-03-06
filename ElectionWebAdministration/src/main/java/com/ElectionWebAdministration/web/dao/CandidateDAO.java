package com.ElectionWebAdministration.web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Candidate;

@Transactional
@Repository("candidateDAO")
public class CandidateDAO extends AbstractDAO<Candidate> implements ICandidateDAO{

	public CandidateDAO() {
		super(Candidate.class);
	}

}
