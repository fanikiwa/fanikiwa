package com.sp.fanikiwa.entity;

import java.math.BigDecimal;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TieredDet   {
	
	 @PrimaryKey
        @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
        Long  id;
@Persistent
	private byte absolute;
@Persistent
	private BigDecimal max;
@Persistent
	private BigDecimal min;
@Persistent
	private BigDecimal rate;
@Persistent
	private long tieredID;

	public TieredDet() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getAbsolute() {
		return this.absolute;
	}

	public void setAbsolute(byte absolute) {
		this.absolute = absolute;
	}

	public BigDecimal getMax() {
		return this.max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public BigDecimal getMin() {
		return this.min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public long getTieredID() {
		return this.tieredID;
	}

	public void setTieredID(long tieredID) {
		this.tieredID = tieredID;
	}

}