package ait.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hiring_Manager")
public class HiringManager {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
	private String name;
	private String location;
	private String email;
	private String contactNumber;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public HiringManager( String name, String location,String email,String contactNumber) {
		this.name = name;
		this.location = location;
		this.email = email;
		this.contactNumber = contactNumber;
	}
	public HiringManager() {
		super();
	}
	
  
}
