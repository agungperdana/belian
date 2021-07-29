package com.kratonsolution.belian.party.api.application;

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
public class MaritalStatusDeleteCommand {

	@NonNull
	private String partyCode;
	
	@NonNull
	private String statusId;
}
