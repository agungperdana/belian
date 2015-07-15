/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="employment")
public class Employment extends PartyRelationship
{
	public String getEmployee()
	{
		return getParty().getName();
	}
	
	public String getEmployer()
	{
		return getResponsibleTo().getName();
	}
}
