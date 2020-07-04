package com.kratonsolution.belian.party.api.application;

import java.util.List;
import java.util.Optional;

import com.kratonsolution.belian.party.api.PartyData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface PartyService {

	public Optional<PartyData> getByCode(@NonNull String code);
	
	public List<PartyData> getAllParty();
}
