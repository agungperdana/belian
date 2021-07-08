package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;
import java.time.Instant;

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
public class PartyClassificationUpdateCommand implements Serializable {

	private static final long serialVersionUID = 7041303275774063153L;

	@NonNull
	private String partyCode;

	@NonNull
	private String partyClassificationId;
	
	private Instant end;
}