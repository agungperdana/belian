/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.payment.dm.Discount;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="course_discount")
public class CourseDiscount implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@ManyToOne
	@JoinColumn(name="fk_discount")
	private Discount discount;
	
	@ManyToOne
	@JoinColumn(name="fk_registration")
	private CourseRegistration registration;

	@Version
	private Long version;
}
