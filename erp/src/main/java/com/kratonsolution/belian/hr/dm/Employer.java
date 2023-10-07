
package com.kratonsolution.belian.hr.dm;

import com.kratonsolution.belian.party.impl.orm.PartyRole;
import com.kratonsolution.belian.party.impl.orm.PartyRoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
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
