package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;
import java.time.Instant;

import com.kratonsolution.belian.party.api.model.PartyRelationshipType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class PartyRelationshipCreateCommand implements Serializable {

	private static final long serialVersionUID = -2267618775074275933L;

	@NonNull
	private String partyCode;

	@NonNull
	private Instant start;

	@NonNull
	private String toPartyCode;

	@NonNull
	private PartyRelationshipType type;
	
	private Instant end;

	private boolean active;
	

}
