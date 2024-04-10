package ait.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Table(name="Candidate")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Candidate {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String candidateName;
	private String candidateExperience;
	@ElementCollection
	private List<String> skills;

	
//	public String getPreferredRole() {
//		return preferredRole;
//	}
//	public void setPreferredRole(String preferredRole) {
//		this.preferredRole = preferredRole;
//	}
	private Boolean canGoOnsite;
	private String locationRequirement;
	private String visaStatus;
	private String employer;
	private Boolean onBench; 
//	private String preferredRole;
//
//	public Candidate() {
//		super();
//	}
//	
//	public Long getCandidateId() {
//		return id;
//	}
//	public void setCandidateId(Long candidateId) {
//		this.id = candidateId;
//	}
//	public String getCandidateName() {
//		return candidateName;
//	}
//	public void setCandidateName(String candidateName) {
//		this.candidateName = candidateName;
//	}
//	public String getCandidateExperience() {
//		return candidateExperience;
//	}
//	
//	public void setCandidateExperience(String candidateExperience) {
//		this.candidateExperience = candidateExperience;
//	}
//	public List<String> getSkills() {
//		return skills;
//	}
//	public void setSkills(List<String> skills) {
//		this.skills = skills;
//	}
//	
//	public Boolean getCanGoOnsite() {
//		return canGoOnsite;
//	}
//	public void setCanGoOnsite(Boolean canGoOnsite) {
//		this.canGoOnsite = canGoOnsite;
//	}
//	public String getLocationRequirement() {
//		return locationRequirement;
//	}
//	public void setLocationRequirement(String locationRequirement) {
//		this.locationRequirement = locationRequirement;
//	}
//	public String getVisaStatus() {
//		return visaStatus;
//	}
//	public void setVisaStatus(String visaStatus) {
//		this.visaStatus = visaStatus;
//	}
//	public String getEmployer() {
//		return employer;
//	}
//	public void setEmployer(String employer) {
//		this.employer = employer;
//	}
//	public Boolean getOnBench() {
//		return onBench;
//	}
//	public void setOnBench(Boolean onBench) {
//		this.onBench = onBench;
//	}
//	 
//	public Candidate(String candidateName, String candidateExperience, List<String> skills, Boolean canGoOnsite, String locationRequirement, String visaStatus,
//			String employer, Boolean onBench) {
//		super();
//		this.candidateName = candidateName;
//		this.candidateExperience = candidateExperience;
//		this.skills = skills;
//		this.canGoOnsite = canGoOnsite;
//		this.locationRequirement = locationRequirement;
//		this.visaStatus = visaStatus;
//		this.employer = employer;
//		this.onBench = onBench;
//	}
	
}
