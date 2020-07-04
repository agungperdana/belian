package com.kratonsolution.belian.party.api.application;

import java.util.Optional;

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
	private String address;
	
	private boolean active;
	
	@NonNull
	private AddressType type;

	private Optional<String> postal = Optional.empty();
	
	private Optional<String> location = Optional.empty();
}
