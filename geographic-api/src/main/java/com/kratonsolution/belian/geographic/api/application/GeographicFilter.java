package com.kratonsolution.belian.geographic.api.application;

import java.io.Serializable;
import java.util.Optional;

import com.kratonsolution.belian.geographic.api.GeographicType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Getter
@Setter
public class GeographicFilter implements Serializable {
    
	private static final long serialVersionUID = -3420130689050937320L;

	private Optional<String> code = Optional.empty();
	
	private Optional<String> name = Optional.empty();
	
	private Optional<GeographicType> type = Optional.empty();
	
	public boolean isValid() {
		return code.isPresent() || name.isPresent() || type.isPresent();
	}
}
