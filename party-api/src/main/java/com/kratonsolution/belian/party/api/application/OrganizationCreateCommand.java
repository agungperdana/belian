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
public class OrganizationCreateCommand {

	@NonNull
	private String code;
	
	@NonNull
	private String name;

	private Optional<String> taxCode = Optional.empty();
	
	private Optional<String> birthPlace = Optional.empty();
	
	private Optional<Instant> birthDate = Optional.empty();
}
