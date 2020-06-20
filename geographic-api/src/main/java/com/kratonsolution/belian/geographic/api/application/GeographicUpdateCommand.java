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
public class GeographicUpdateCommand {

	@NonNull
	private String code;

	private Optional<String> name = Optional.empty();

	private Optional<String> note = Optional.empty();

	private Optional<GeographicType> type = Optional.empty();
}
