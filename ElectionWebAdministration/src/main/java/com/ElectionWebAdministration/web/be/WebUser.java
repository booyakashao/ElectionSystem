package com.ElectionWebAdministration.web.be;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class WebUser implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2599215883649832076L;
	private Voter voter;

	public WebUser(Voter passedInVoter) {
		this.voter = passedInVoter;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(voter.getRole());
		return roles;
	}

	@Override
	public String getPassword() {
		return voter.getPassword();
	}

	@Override
	public String getUsername() {
		return voter.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

}
