/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.PeriodType;
import com.kratonsolution.belian.general.dm.Employment;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="pay_history")
public class PayHistory implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start_date")
	private Date start;
	
	@Column(name="end_date")
	private Date end;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="comment")
	private String comment;
	
	@Enumerated(EnumType.STRING)
	@Column(name="period_type")
	private PeriodType periodType;
	
	@ManyToOne
	@JoinColumn(name="fk_salary_step")
	private SalaryStep salaryStep;
	
	@ManyToOne
	@JoinColumn(name="fk_employment")
	private Employment employment;
	
	@Version
	private Long version;
}
