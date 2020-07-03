package com.kratonsolution.belian.party.api.application;

import com.kratonsolution.belian.party.api.AddressData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface AddressService {

	public AddressData create(@NonNull AddressCreateCommand command);
	
	public AddressData update(@NonNull AddressUpdateCommand command);
	
	public void delete(@NonNull AddressDeleteCommand command);
}
