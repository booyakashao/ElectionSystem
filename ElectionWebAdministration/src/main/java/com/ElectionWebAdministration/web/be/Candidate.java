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

@Entity
@Table(name="candidates")
@Proxy(lazy=false)
public class Candidate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8220947521349892032L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="candidates_id_seq")
	@SequenceGenerator(name="candidates_id_seq", sequenceName="candidates_id_seq", allocationSize=1)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	public Candidate() {
		
	}

	public Candidate(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Candidate other = (Candidate) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.matches(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.matches(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
}
