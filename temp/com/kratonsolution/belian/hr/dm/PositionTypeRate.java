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

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.PeriodType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * @Description too provide the costs and standard rates for various types of positions
 * 				in order to capture appropriate cost estimates for work efforts.
 */
@Getter
@Setter
@Entity
@Table(name="position_type_rate")
public class PositionTypeRate implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;

	@Column(name="end")
	private Date end;

	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ONE;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@ManyToOne
	@JoinColumn(name="fk_position_type")
	private PositionType positionType;

	@Enumerated(EnumType.STRING)
	@Column(name="rate_type")
	private RateType rateType = RateType.PAYROLL;

	@Enumerated(EnumType.STRING)
	@Column(name="period_type")
	private PeriodType periodType = PeriodType.Monthly;
	
	@Column(name="comment")
	private String comment;

	@Version
	private Long version;
	
	public PositionTypeRate(){}
}
