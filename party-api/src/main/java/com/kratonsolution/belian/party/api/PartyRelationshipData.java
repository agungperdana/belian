package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;

import com.kratonsolution.belian.party.api.model.PartyRelationshipStatusType;
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

	private Instant start;
	
	private Instant end;
	
	private String toPartyCode;
	
	private String toPartyName;
	
	private PartyRoleData fromRole;
	
	private PartyRoleData toRole;
	
	private PartyRelationshipType type;
	
	private PartyRelationshipStatusType status;
	
	public PartyRelationshipData(){}
}
