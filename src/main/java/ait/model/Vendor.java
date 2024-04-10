package ait.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Vendor")
public class Vendor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendorId; 
	private String name;
	private String email;
	private Long phone;
	private String company;
	public Vendor(String name, String email, Long phone, String company) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.company = company;
	}
	public Vendor() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

}
