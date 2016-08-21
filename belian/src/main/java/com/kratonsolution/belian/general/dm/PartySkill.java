/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="party_skill")
public class PartySkill implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="fk_type")
	private PartySkillType type;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
}
