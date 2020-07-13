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
public class AddressUpdateCommand {

	@NonNull
	private String partyCode;

	@NonNull
	private String addressId;
	
	private String address;
	
	private boolean active;
	
	private AddressType type;

	private String postal;
	
	private String location;
}
