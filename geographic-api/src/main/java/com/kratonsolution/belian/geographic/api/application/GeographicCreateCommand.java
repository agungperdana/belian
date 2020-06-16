package com.kratonsolution.belian.geographic.api.application;

import java.util.Optional;

import com.kratonsolution.belian.geographic.api.GeographicType;

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
public class GeographicCreateCommand {

	@NonNull
	private String code;

	@NonNull
	private String name;

	private String note;

	@NonNull
	private GeographicType type;

	private Optional<String> parent = Optional.ofNullable(null);
}
