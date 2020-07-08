package com.kratonsolution.belian.geographic.api.application;

import java.io.Serializable;

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
public class GeographicDeleteCommand implements Serializable {

	private static final long serialVersionUID = 972560748927960037L;

	@NonNull
	private String code;
}
