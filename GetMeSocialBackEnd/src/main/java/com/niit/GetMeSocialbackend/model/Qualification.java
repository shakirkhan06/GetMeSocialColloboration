package com.niit.GetMeSocialbackend.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Embeddable
public class Qualification extends BaseDomain {
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private BigDecimal tenthPercentage;
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private BigDecimal twelfthPercentage;
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private BigDecimal bachelorCGPAPercentage;

	public BigDecimal getTenthPercentage() {
		return tenthPercentage;
	}

	public void setTenthPercentage(BigDecimal num) {
		this.tenthPercentage = num;
	}

	public BigDecimal getTwelfthPercentage() {
		return twelfthPercentage;
	}

	public void setTwelfthPercentage(BigDecimal num) {
		this.twelfthPercentage = num;
	}

	public BigDecimal getBachelorCGPAPercentage() {
		return bachelorCGPAPercentage;
	}

	public void setBachelorCGPAPercentage(BigDecimal num) {
		this.bachelorCGPAPercentage = num;
	}
	
}
