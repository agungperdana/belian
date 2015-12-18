/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.Listable;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="party_role")
@Inheritance(strategy=InheritanceType.JOINED)
public class PartyRole implements Serializable, Listable
{
	public enum Type{
		HOLDING,SUBSIDIARY,DEPARTMENT,DIVISION,
		CUSTOMER,SUPPLIER,EMPLOYEE,EMPLOYER,CONTACT,
		INTERNALORGANIZATION,BUDGETREVIEWER,
		BRANCH
	}
	
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="date_from",nullable=false)
	protected Date from;
	
	@Column(name="date_to")
	protected Date to;
	
	@Column(name="party_role_type")
	@Enumerated(EnumType.STRING)
	protected Type type = Type.HOLDING;
	
	@ManyToOne
	@JoinColumn(name="fk_economic_agent")
	protected EconomicAgent party;
	
	@Column(name="is_deleted")
	protected boolean deleted = false;
	
	@Version
	private Long version;

	public static PartyRole newInstance(Type type)
	{
		switch(type)
		{
			case HOLDING:return new Holding();
			case SUBSIDIARY:return new Subsidiary();
			case DEPARTMENT:return new Department();
			case DIVISION:return new Division();
			case CUSTOMER:return new Customer();
			case SUPPLIER:return new Supplier();
			case EMPLOYEE:return new Employee();
			case EMPLOYER:return new Employer();
			case BUDGETREVIEWER:return new BudgetReviewer();
			default:
				return new PartyRole();
		}
	}
	
	@Override
	public String toString()
	{
		Map<String,String> map = new HashMap<String, String>();
		map.put("id",getId());
		map.put("from",getFrom()+"");
		map.put("to",getTo()+"");
		map.put("type",getType().name());
		map.put("party",getParty().getClass().getName());
		
		return map.toString();
	}

	@Override
	public String getLabel()
	{
		return type.name();
	}

	@Override
	public String getValue()
	{
		return type.name();
	}
}
