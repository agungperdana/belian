/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Strings;
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
@Table(name="course_registration")
public class CourseRegistration extends Billable
{
	@ManyToOne
	@JoinColumn(name="fk_study_day")
	private StudyDay day;
	
	@ManyToOne
	@JoinColumn(name="fk_study_time")
	private StudyTime time;
	
	@ManyToOne
	@JoinColumn(name="fk_study_period")
	private StudyPeriod period;
	
	@OneToMany(mappedBy="registration",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CourseItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="registration",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CourseDiscount> discounts = new HashSet<>();

	@Override
	public String getBillingType(String lang)
	{
		if(!Strings.isNullOrEmpty(lang) && lang.equals("in_ID"))
			return "Kursus";

		return "Course Registration";
	}

	@Override
	public int getTableNumber()
	{
		return 0;
	}
	
	public BigDecimal getDiscount()
	{
		BigDecimal disc = BigDecimal.ZERO;
		for(CourseDiscount discount:discounts)
			disc = disc.add(discount.getAmount());
		
		return disc;
	}
	
	@Override
	public BigDecimal getBillingAmount()
	{
		return super.getBillingAmount().subtract(getDiscount());
	}
}
