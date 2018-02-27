package com.abc.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Gemployee")
public class Gemployee  extends BaseEntity {
	private String fullname;
	private String email;
	private String phoneNumer;
	private String gender;
   	private String contactPrefernce;
   	
   	private String isActive;
   
	private String department;
	private String dob;
	private String photo;
	
	
	
	
	
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumer() {
		return phoneNumer;
	}
	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactPrefernce() {
		return contactPrefernce;
	}
	public void setContactPrefernce(String contactPrefernce) {
		this.contactPrefernce = contactPrefernce;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}
