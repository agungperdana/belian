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
@Table(name="mix_role")
public class MixRole extends PartyRole
{
	@ManyToOne
	@JoinColumn(name="fk_party_from")
	private Party from;
	
	@ManyToOne
	@JoinColumn(name="fk_party_to")
	private Party to;
}
