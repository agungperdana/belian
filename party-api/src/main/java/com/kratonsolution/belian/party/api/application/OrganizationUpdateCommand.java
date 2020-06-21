package com.kratonsolution.belian.party.api.application;

import java.time.Instant;
import java.util.Optional;

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
public class OrganizationUpdateCommand {

	@NonNull
	private String code;
	
	private Optional<String> name = Optional.empty();

	private Optional<String> taxCode = Optional.empty();
	
	private Optional<String> birthPlace = Optional.empty();
	
	private Optional<Instant> birthDate = Optional.empty();
	
	public boolean isValid() {
		return (getName().isPresent() || getTaxCode().isPresent() || getBirthDate().isPresent() || getBirthPlace().isPresent());
	}
}
