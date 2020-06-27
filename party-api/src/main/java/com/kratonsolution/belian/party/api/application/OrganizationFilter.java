package com.kratonsolution.belian.party.api.application;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class OrganizationFilter {

	private Optional<String> code = Optional.empty();
	
	private Optional<String> name = Optional.empty();
	
	public boolean isValid() {
		return code.isPresent() && name.isPresent();
	}
}
