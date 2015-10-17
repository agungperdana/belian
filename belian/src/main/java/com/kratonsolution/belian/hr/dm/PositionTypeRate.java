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

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.PeriodType;

import lombok.Setter;
import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="position_type_rate")
public class PositionTypeRate implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start_date")
	private Date start;

	@Column(name="end_date")
	private Date end;

	@Column(name="amount")
	private BigDecimal amount;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@ManyToOne
	@JoinColumn(name="fk_position_type")
	private PositionType positionType;

	@Enumerated(EnumType.STRING)
	@Column(name="rate_type")
	private RateType rateType = RateType.STANDARD_PAY_RATE;

	@Enumerated(EnumType.STRING)
	@Column(name="period_type")
	private PeriodType periodType = PeriodType.PER_MONTH;
	
	@Column(name="comment")
	private String comment;

	public PositionTypeRate(){}
}
