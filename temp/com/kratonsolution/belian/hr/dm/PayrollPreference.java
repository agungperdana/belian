/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.PeriodType;
import com.kratonsolution.belian.invoice.dm.PaymentMethodType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * t is possible that an employee may want part of his or her pay in check form and the rest in cash. 
 * Others may want their money split up and elec- tronically deposited to several different banks. 
 * Some employees may want standard deductions to be accounted for each and every paycheck.
 */
@Getter
@Setter
@Entity
@Table(name="payroll_preference")
public class PayrollPreference implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start",nullable=false)
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Enumerated(EnumType.STRING)
	@Column(name="fk_payment_method_type")
	private PaymentMethodType paymentType = PaymentMethodType.CASH;
	
	@Column(name="percent")
	private BigDecimal percent;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="bank_number")
	private String bankNumber;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="period_type")
	private PeriodType periodType;
	
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employment employment;
	
	@Version
	private Long version;
	
	public PayrollPreference(){}
}
