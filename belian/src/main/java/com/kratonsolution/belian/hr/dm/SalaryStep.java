/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Version;

import lombok.Setter;
import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="salary_step")
public class SalaryStep implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="sequence")
	private int sequence = 1;
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="fk_pay_grade")
	private PayGrade payGrade;
	
	@ManyToOne
	@JoinColumn(name="fk_position_type_rate")
	private PositionTypeRate positionTypeRate;
	
	@Version
	private Long version;
}
