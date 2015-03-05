package com.sp.fanikiwa.entity;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Organization  {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long  organizationID;
@Persistent
	private String andress;
@Persistent
	private String email;
@Persistent
	private String name;

@Persistent
    private List<Customer> customers; 
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

	public List<Customer> getCustomers()
	{
		return this.customers;
	}
	public void setCustomers(List<Customer> customers)
	{
		this.customers=customers;
	}
	public Customer addCustomer(Customer customer)
	{
		getCustomers().add(customer);
		customer.setOrganization(this);
		return customer;
	}

	public Customer removeCustomer(Customer customer)
	{
		getCustomers().remove(customer);
		customer.setOrganization(null);
		return customer;
	}

}