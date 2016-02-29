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
@Table(name="person_role")
public class PersonRole extends PartyRole
{
	@ManyToOne
	@JoinColumn(name="fk_organization_to")
	protected Organization to;

	@ManyToOne
	@JoinColumn(name="fk_person_from")
	protected Person from;
}
