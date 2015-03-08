package com.ElectionWebAdministration.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ElectionWebAdministration.web.be.WebUser;
import com.ElectionWebAdministration.web.dao.IVoterDAO;


@Repository("userAuthenticationService")
@Transactional
public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	@Qualifier("voterDAO")
	private IVoterDAO voterDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		WebUser currentWebUser = new WebUser(voterDAO.findByUsername(username));
		
		return currentWebUser;
	}

}
