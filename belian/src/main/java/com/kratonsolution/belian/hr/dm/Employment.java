/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.PartyRelationship;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.production.dm.TimeEntry;
import com.kratonsolution.belian.production.dm.Timesheet;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="employment")
public class Employment extends PartyRelationship implements Listable
{
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="fk_internal_organization")
	private InternalOrganization internalOrganization;
	
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PayHistory> salarys = new HashSet<>();
	
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<Benefit> benefits = new HashSet<>();
	
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PayrollPreference> preferences = new HashSet<>();
	
	public Employment(){}

	@Override
	public String getLabel()
	{
		return employee.getParty().getLabel();
	}

	@Override
	public String getValue()
	{
		return employee.getParty().getValue();
	}
	
	public BigDecimal getGross(Date date,Date start,Date end)
	{
		BigDecimal salary = BigDecimal.ZERO;
		BigDecimal gross = BigDecimal.ZERO;
		
		for(PayHistory history:salarys)
		{
			if(DateTimes.inRange(date,history.getStart(),history.getEnd()))
			{
				salary = history.getAmount();
				break;
			}
		}
		
		for(Timesheet timesheet:employee.getTimesheet())
		{
			if(timesheet.getStart().equals(start) && timesheet.getEnd().equals(end))
			{
				for(TimeEntry entry:timesheet.getTimeEntrys())
					gross = gross.add(entry.getHour().multiply(salary));

				break;
			}
		}
		
		for(Benefit benefit:benefits)
			gross = gross.add(benefit.getCost().multiply(benefit.getEmployerPaid()).divide(BigDecimal.valueOf(100)));
		
		return gross;
	}
}
