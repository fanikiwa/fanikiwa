package com.sp.fanikiwa.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.googlecode.objectify.annotation.Id;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TieredDet   {
	
	@Id Long id;

	private byte absolute;

	private double max;

	private double min;

	private double rate;

	private long tieredID;

	public TieredDet() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte getAbsolute() {
		return this.absolute;
	}

	public void setAbsolute(byte absolute) {
		this.absolute = absolute;
	}

	public double getMax() {
		return this.max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return this.min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Long getTieredID() {
		return this.tieredID;
	}

	public void setTieredID(Long tieredID) {
		this.tieredID = tieredID;
	}

}