/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="company_structure")
public class CompanyStructure extends PartyRelationship
{
	public CompanyStructure()
	{
		setType(Type.COMPANYSTRUCTURE);
	}
}
