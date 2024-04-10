package ait.model;


import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Job")
public class Job {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String client;
	private String experience;
	private String payrate;
	private String role;
	private String description;
	private Date date_of_entry;
	private Date last_date_submission;
	private Boolean isOpen; 
	private String locationType;
	private String location;
	private String jobKind;
	private String duration;
	private String hiringManagerName;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hiring_manager_id")
	private HiringManager hiringManager;
	
	@ElementCollection
	private List<String> skills;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vendor> vendor_details;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getHiringManagerName() {
		return hiringManagerName;
	}
	public void setHiringManagerName(String hiringManagerName) {
		this.hiringManagerName = hiringManagerName;
	}
	public HiringManager getHiringManager() {
		return hiringManager;
	}
	public void setHiringManager(HiringManager hiringManager) {
		this.hiringManager = hiringManager;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getJobKind() {
		return jobKind;
	}
	public void setJobKind(String jobKind) {
		this.jobKind = jobKind;
	}
	public Job() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getPayrate() {
		return payrate;
	}
	public void setPayrate(String payrate) {
		this.payrate = payrate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_of_entry() {
		return date_of_entry;
	}
	
	public void setDate_of_entry(Date date_of_entry) {
		this.date_of_entry = date_of_entry;
	}
	public Date getLast_date_submission() {
		return last_date_submission;
	}
	public void setLast_date_submission(Date last_date_submission) {
		this.last_date_submission = last_date_submission;
	}
	
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public List<Vendor> getVendor_details() {
		return vendor_details;
	}
	public void setVendor_details(List<Vendor> vendor_details) {
		this.vendor_details = vendor_details;
	}
	public Boolean getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Boolean submitted) {
		this.isOpen = submitted;
	}
	public Job(String client, String experience, String payrate, String description, Date date_of_entry,
			Date last_date_submission, Boolean isOpen, String locationType, String location, String jobKind,
			String duration, String hiring_manager_name, List<String> skills, List<Vendor> vendor_details) {
		super();
		this.client = client;
		this.experience = experience;
		this.payrate = payrate;
		this.description = description;
		this.date_of_entry = date_of_entry;
		this.last_date_submission = last_date_submission;
		this.isOpen = isOpen;
		this.locationType = locationType;
		this.location = location;
		this.jobKind = jobKind;
		this.duration = duration;
		this.hiringManagerName = hiring_manager_name;
		this.skills = skills;
		this.vendor_details = vendor_details;
	}
	

	
}
