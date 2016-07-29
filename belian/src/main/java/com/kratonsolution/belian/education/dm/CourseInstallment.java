/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.sales.dm.Billable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="course_installment")
public class CourseInstallment extends Billable
{	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_course_registration")
	private CourseRegistration registration;
	
	@OneToMany(mappedBy="installment",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<CourseInstallmentItem> items = new HashSet<>();
	
	public CourseInstallment(){}

	@Override
	public String getBillingType(String lang)
	{
		return "Course Installment";
	}

	@Override
	public int getTableNumber()
	{
		return 0;
	}
	
	@Override
	public BigDecimal getBillingAmount()
	{
		return amount;
	}
	
	@Override
	public BigDecimal getTaxAmount()
	{
		return BigDecimal.ZERO;
	}
}
