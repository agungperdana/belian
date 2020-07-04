package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.kratonsolution.belian.party.api.model.PartyRelationshipStatus;
import com.kratonsolution.belian.party.api.model.PartyRelationshipType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PartyRelationshipData implements Serializable
{
	private static final long serialVersionUID = -3810420990043934420L;

	private final String dataID = UUID.randomUUID().toString();
	
	private Instant start;
	
	private Instant end;
	
	private String toPartyCode;
	
	private String toPartyName;
	
	private PartyRelationshipType type;
	
	private PartyRelationshipStatus status;
	
	public PartyRelationshipData(){}
}
