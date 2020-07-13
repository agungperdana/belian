package com.kratonsolution.belian.party.api.application;

import java.time.Instant;

import com.kratonsolution.belian.party.api.model.PartyClassificationType;

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
public class PartyClassificationCreateCommand {

	@NonNull
	private String partyCode;

	private Instant start;

	private Instant end;

	private PartyClassificationType type;

	private String value;


}
