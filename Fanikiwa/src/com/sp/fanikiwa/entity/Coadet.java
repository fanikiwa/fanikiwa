package com.sp.fanikiwa.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Coadet {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long  id;
@Persistent
	private int coaID;
@Persistent
	private int COALevel;
@Persistent
	private String description;
@Persistent
	private int parent;
@Persistent
	private int rorder;
@Persistent
	private String shortCode;

	public Coadet() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCoaID() {
		return this.coaID;
	}

	public void setCoaID(int coaID) {
		this.coaID = coaID;
	}

	public int getCOALevel() {
		return this.COALevel;
	}

	public void setCOALevel(int COALevel) {
		this.COALevel = COALevel;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParent() {
		return this.parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getRorder() {
		return this.rorder;
	}

	public void setRorder(int rorder) {
		this.rorder = rorder;
	}

	public String getShortCode() {
		return this.shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

}