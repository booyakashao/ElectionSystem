package com.ElectionWebAdministration.web.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.Role;
import com.ElectionWebAdministration.web.be.Voter;
import com.ElectionWebAdministration.web.dao.IRoleDAO;
import com.ElectionWebAdministration.web.dao.IVoterDAO;

@Service("userService")
@Transactional
public class UserService {

	@Autowired
	@Qualifier("voterDAO")
	private IVoterDAO voterDAO;
	
	@Autowired
	@Qualifier("roleDAO")
	private IRoleDAO roleDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Voter getVoterById(long id) {
		return voterDAO.get(id);
	}
	
	public Serializable createVoter(Voter newVoter, Role role) {
		
		if(!roleDAO.roleExists(role.getRoleName())) {
			roleDAO.create(role);
		} else {
			role = roleDAO.findRoleByName(role.getRoleName());
		}
		
		
		newVoter.setPassword( passwordEncoder.encode(newVoter.getPassword()) );
		newVoter.setEnabled(true);
		newVoter.setRole(role);
		return voterDAO.create(newVoter);
	}
	
	public Serializable createVoter(Voter newVoter) {
		
		if(!roleDAO.roleExists(newVoter.getRole().getRoleName())) {
			roleDAO.create(newVoter.getRole());
		} else {
			newVoter.setRole(roleDAO.findRoleByName("ROLE_VOTER"));
		}
		
		
		newVoter.setPassword( passwordEncoder.encode(newVoter.getPassword()) );
		newVoter.setEnabled(true);
		return voterDAO.create(newVoter);
	}
	
	public boolean voterExists(Voter voter) {
		try {
			if(voterDAO.get(voter.getId()) != null) {
				return true;
			}
				
		} catch(Exception e) {
			return false;
		}
		
		return false;
	}
	
	public List<Voter> getAllVoters() {
		return voterDAO.getAll();
	}
}
