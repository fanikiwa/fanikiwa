package com.sp.fanikiwa.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.googlecode.objectify.annotation.Id;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Settingsgroup   {
	
	@Id Long id;

	private String groupName;

	private int parent;

	public Settingsgroup() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getParent() {
		return this.parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

}