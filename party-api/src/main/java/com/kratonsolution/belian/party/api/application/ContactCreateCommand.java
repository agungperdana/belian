package com.kratonsolution.belian.party.api.application;

import com.kratonsolution.belian.party.api.model.ContactType;

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
public class ContactCreateCommand {

	@NonNull
	private String partyCode;
	
	@NonNull
	private String contact;

	@NonNull
	private ContactType type;
	
	private boolean active;
}
