/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="organization_role")
public class OrganizationRole extends PartyRole
{
	@ManyToOne
	@JoinColumn(name="fk_organization_from")
	private Organization from;
	
	@ManyToOne
	@JoinColumn(name="fk_organization_to")
	private Organization to;
	
	public OrganizationRole(){}
}
