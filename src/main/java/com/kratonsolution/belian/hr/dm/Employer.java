/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.partys.dm.PartyRole;
import com.kratonsolution.belian.partys.dm.PartyRoleType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="employer")
public class Employer extends PartyRole
{
	public Employer()
	{
		setType(PartyRoleType.EMPLOYER);
	}
}
