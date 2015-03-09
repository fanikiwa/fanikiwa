package com.sp.fanikiwa.entity;
 
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Organization  {
	
	@Id Long  organizationID;

	private String andress;
	private String email;
	private String name;
    
	public Organization() {
	}

	public Organization(Long Id) {
		setOrganizationID(Id);
	}

	public Long getOrganizationID() {
		return this.organizationID;
	}

	public void setOrganizationID(Long organizationID) {
		this.organizationID = organizationID;
	}

	public String getAndress() {
		return this.andress;
	}

	public void setAndress(String andress) {
		this.andress = andress;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}