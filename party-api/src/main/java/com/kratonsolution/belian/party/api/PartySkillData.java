package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PartySkillData implements Serializable
{
	private static final long serialVersionUID = 4506941101593072678L;

	private Instant start;
	
	private Instant end;
	
	private PartySkillTypeData type;
	
	private PartyData party;
	
	public PartySkillData() {}
}
