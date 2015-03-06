package com.ElectionWebAdministration.web.be;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Vote")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Vote_id_seq")
	@SequenceGenerator(name="Vote_id_seq", sequenceName="Vote_id_seq", allocationSize=1)
	@Column(name="id")
	private long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="voter_id")
	private Voter voter;
	
	public Vote() {
		
	}

	public Vote(Candidate candidate, Voter voter) {
		this.candidate = candidate;
		this.voter = voter;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((candidate == null) ? 0 : candidate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((voter == null) ? 0 : voter.hashCode());
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
		Vote other = (Vote) obj;
		if (candidate == null) {
			if (other.candidate != null)
				return false;
		} else if (!candidate.equals(other.candidate))
			return false;
		if (id != other.id)
			return false;
		if (voter == null) {
			if (other.voter != null)
				return false;
		} else if (!voter.equals(other.voter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", candidate=" + candidate + ", voter="
				+ voter + "]";
	}
	
	
}
