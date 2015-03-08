package com.ElectionWebAdministration.web.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Voter;

@Transactional
@Repository("voterDAO")
public class VoterDAO extends AbstractDAO<Voter> implements IVoterDAO{

	public VoterDAO() {
		super(Voter.class);
	}

	public Voter findByUsername(String username) {
		Criteria searchCriteria = super.getSession().createCriteria(Voter.class)
				.add(Restrictions.eqOrIsNull("username", username))
				.setMaxResults(1);
		
		return findByCriteria(searchCriteria).get(0);
	}
}
