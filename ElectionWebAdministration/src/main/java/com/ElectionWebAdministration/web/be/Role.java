package com.ElectionWebAdministration.web.be;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="Role")
@Proxy(lazy=false)
public class Role implements Serializable, GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1154299090980757247L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="role_id_seq")
	@SequenceGenerator(name="role_id_seq", sequenceName="role_id_seq", allocationSize=1)
	@Column(name="id")
	private long id;
	
	@Column(name="role_name")
	private String roleName;
	
	public Role() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

	@Override
	public String getAuthority() {
		return roleName;
	}

}
