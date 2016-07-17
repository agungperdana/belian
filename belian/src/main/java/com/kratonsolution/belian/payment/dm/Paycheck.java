/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.hr.dm.Employment;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * PAYCHECK is a subtype of the DISBURSEMENT entity and is modeled sep- arately 
 * because of some of the unique aspects of a paycheck as opposed to other disbursements
 */
@Getter
@Setter
@Entity
@Table(name="paycheck")
public class Paycheck extends Disbursement
{
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@ManyToOne
	@JoinColumn(name="fk_empployment")
	private Employment employment;
	
	@OneToMany(mappedBy="paycheck",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Deduction> deductions = new HashSet<>();
	
	@OneToMany(mappedBy="paycheck",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PaycheckItem> items = new HashSet<>();
	
	public Paycheck(){}
	
	public BigDecimal getNetAmount()
	{
		BigDecimal net = getAmount();
		
		for(Deduction deduction:deductions)
			net = net.subtract(deduction.getAmount());
		
		return net;
	}
	
	public BigDecimal getDeductionAmount()
	{
		BigDecimal deduction = BigDecimal.ZERO;
		
		for(Deduction ded:deductions)
			deduction = deduction.add(ded.getAmount());
		
		return deduction;
	}

	public BigDecimal getRate()
	{
		return employment.getRate(date);
	}
	
	public BigDecimal getHour()
	{
		return employment.getHours(end, start, end);
	}
}
