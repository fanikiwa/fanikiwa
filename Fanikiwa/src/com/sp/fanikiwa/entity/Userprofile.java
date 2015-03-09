package com.sp.fanikiwa.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.googlecode.objectify.annotation.Id;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Userprofile  {
	
	@Id Long userId; 
	
	private String userName;

	public Userprofile() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}