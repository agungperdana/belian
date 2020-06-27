package com.kratonsolution.belian.party.impl.model;

import javax.persistence.Embeddable;

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
@Embeddable
public class PartyGeographicInfo {
	
	private String code;

	private String name;
	
	PartyGeographicInfo() {}
	
	public PartyGeographicInfo(@NonNull String code, @NonNull String name) {
		
		this.code = code;
		this.name = name;
	}
}
