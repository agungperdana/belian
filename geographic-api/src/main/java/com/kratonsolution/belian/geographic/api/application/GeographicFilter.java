package com.kratonsolution.belian.geographic.api.application;

import java.io.Serializable;

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

	private String key;
	
	private Integer page = 0;
	
	private Integer size = 1000;
	
	private boolean root = false;
	
}
