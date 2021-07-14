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
public class PartyRoleUpdateCommand implements Serializable {

	private static final long serialVersionUID = 1031918806338540345L;

	@NonNull
	private String partyCode;

	@NonNull
	private String partyRoleId;
	
	@NonNull
	private Instant end;
}
