package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.kratonsolution.belian.party.api.model.PartyRoleType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PartyRoleData implements Serializable
{
	private static final long serialVersionUID = -2424004223402414808L;

	private String id = UUID.randomUUID().toString();
	
	private Instant start = Instant.now();
	
	private Instant end;
	
	private PartyRoleType type;
	
	public PartyRoleData(){}
}
