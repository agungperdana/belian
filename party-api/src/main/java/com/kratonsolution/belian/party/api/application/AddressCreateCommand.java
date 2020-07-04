package com.kratonsolution.belian.party.api.application;

import com.kratonsolution.belian.party.api.model.AddressType;

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
public class AddressCreateCommand {

	@NonNull
	private String partyCode;
	
	@NonNull
	private String address;
	
	private String postal;
	
	private boolean active;
	
	@NonNull
	private AddressType type;

	@NonNull
	private String location;
}
