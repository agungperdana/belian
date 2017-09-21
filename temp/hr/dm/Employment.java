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
import com.kratonsolution.belian.effort.dm.TimeEntry;
import com.kratonsolution.belian.effort.dm.Timesheet;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.partys.dm.PartyRelationship;

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
	
	public BigDecimal getRate(Date date)
	{
		BigDecimal salary = BigDecimal.ZERO;
		
		for(PayHistory history:salarys)
		{
			if(DateTimes.inRange(date,history.getStart(),history.getEnd()))
			{
				salary = history.getAmount();
				break;
			}
		}
		
		return salary;
	}
	
	public BigDecimal getHours(Date date,Date start,Date end)
	{
		BigDecimal hours = BigDecimal.ZERO;
		
		for(Timesheet timesheet:employee.getTimesheet())
		{
			if(timesheet.getStart().equals(start) && timesheet.getEnd().equals(end))
			{
				for(TimeEntry entry:timesheet.getTimeEntrys())
					hours = hours.add(entry.getHour());
			}
		}
		
		return hours;
	}
}
