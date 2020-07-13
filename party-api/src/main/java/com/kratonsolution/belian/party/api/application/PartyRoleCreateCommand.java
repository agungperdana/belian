package com.kratonsolution.belian.party.api.application;

import java.time.Instant;

import com.kratonsolution.belian.party.api.model.PartyRoleType;

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
public class PartyRoleCreateCommand {

	@NonNull
	private String partyCode;

	@NonNull
	private Instant start;

	private Instant end;

	@NonNull
	private PartyRoleType type;
}
