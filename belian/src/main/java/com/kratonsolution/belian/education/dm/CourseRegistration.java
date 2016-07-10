/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;

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
public class CourseRegistration implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	private String number;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;

	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_staff")
	private Person staff;
	
	@ManyToOne
	@JoinColumn(name="fk_student")
	private Person student;
	
	@ManyToOne
	@JoinColumn(name="fk_tax")
	private Tax tax;
	
	@ManyToOne
	@JoinColumn(name="fk_study_day")
	private StudyDay day;
	
	@ManyToOne
	@JoinColumn(name="fk_study_time")
	private StudyTime time;
	
	@ManyToOne
	@JoinColumn(name="fk_study_period")
	private StudyPeriod period;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="registration",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CourseItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="registration",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CourseDiscount> discounts = new HashSet<>();
	
	@OneToMany(mappedBy="registration",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CourseInstallment> installments = new HashSet<>();
	
	public BigDecimal getDiscountAmount()
	{
		BigDecimal disc = BigDecimal.ZERO;
		for(CourseDiscount discount:discounts)
			disc = disc.add(discount.getAmount());
		
		return disc;
	}
	
	public BigDecimal getBilledAmount()
	{
		BigDecimal bill = BigDecimal.ZERO;
		
		for(CourseItem item:items)
			bill = bill.add(item.getQuantity().multiply(item.getUnitPrice()));
		
		return bill;
	}
}
