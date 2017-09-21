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

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="benefit")
public class Benefit implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="cost")
	private BigDecimal cost = BigDecimal.ONE;
	
	@Column(name="percent_employer_paid")
	private BigDecimal employerPaid = BigDecimal.ZERO;
	
	@Column(name="available_time")
	private int availableTime = 0;
	
	@ManyToOne
	@JoinColumn(name="fk_benefit_type")
	private BenefitType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="period_type")
	private PeriodType periodType = PeriodType.Monthly;
	
	@ManyToOne
	@JoinColumn(name="fk_employment")
	private Employment employment;
	
	@Version
	private Long version;
}
