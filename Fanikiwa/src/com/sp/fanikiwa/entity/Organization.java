package com.sp.fanikiwa.entity;

import java.util.List;
import java.util.Set;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Organization  {
	
	@Id Long organizationID;

	private String andress;
	private String email;
	private String name;
  //  private List<Key<Customer>> customers; 
    
	public Organization() {
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

//	public List<Customer> getCustomers()
//	{
//		return this.customers;
//	}
//	public void setCustomers(List<Customer> customers)
//	{
//		this.customers=customers;
//	}
//	public Customer addCustomer(Customer customer)
//	{
//		getCustomers().add(customer);
//		customer.setOrganization(this);
//		return customer;
//	}
//
//	public Customer removeCustomer(Customer customer)
//	{
//		getCustomers().remove(customer);
//		customer.setOrganization(null);
//		return customer;
//	}

}