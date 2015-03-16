package com.sp.fanikiwa.entity;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
 
@Entity
public class Userprofile  {
 
	@Id String userId;
	
	private String Password;
	private Date CreateDate;
	private String ConfirmationToken;
	private String PasswordFailuresSinceLastSuccess;
	private Date PasswordChangedDate;
	private String PasswordSalt;
	private String PasswordVerificationToken;
	private Date PasswordVerificationTokenExpirationDate;

	public Userprofile() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getConfirmationToken() {
		return ConfirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		ConfirmationToken = confirmationToken;
	}

	public String getPasswordFailuresSinceLastSuccess() {
		return PasswordFailuresSinceLastSuccess;
	}

	public void setPasswordFailuresSinceLastSuccess(
			String passwordFailuresSinceLastSuccess) {
		PasswordFailuresSinceLastSuccess = passwordFailuresSinceLastSuccess;
	}

	public Date getPasswordChangedDate() {
		return PasswordChangedDate;
	}

	public void setPasswordChangedDate(Date passwordChangedDate) {
		PasswordChangedDate = passwordChangedDate;
	}

	public String getPasswordSalt() {
		return PasswordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		PasswordSalt = passwordSalt;
	}

	public String getPasswordVerificationToken() {
		return PasswordVerificationToken;
	}

	public void setPasswordVerificationToken(String passwordVerificationToken) {
		PasswordVerificationToken = passwordVerificationToken;
	}

	public Date getPasswordVerificationTokenExpirationDate() {
		return PasswordVerificationTokenExpirationDate;
	}

	public void setPasswordVerificationTokenExpirationDate(
			Date passwordVerificationTokenExpirationDate) {
		PasswordVerificationTokenExpirationDate = passwordVerificationTokenExpirationDate;
	}

	
}