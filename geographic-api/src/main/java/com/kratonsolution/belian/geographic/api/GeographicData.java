package com.kratonsolution.belian.geographic.api;

import java.util.HashSet;
import java.util.Set;

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
public class GeographicData {

	@NonNull
	private String code;

	private String name;

	private String note;
	
	private String parent;

	private GeographicType type;
	
	private Set<GeographicData> childs = new HashSet<>();
}
