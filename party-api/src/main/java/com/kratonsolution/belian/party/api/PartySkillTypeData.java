package com.kratonsolution.belian.party.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Setter
public class PartySkillTypeData implements Serializable
{
	private static final long serialVersionUID = -9027523263865253100L;

	private String name;

	public PartySkillTypeData(){}
}
