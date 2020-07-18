package com.kratonsolution.belian.party.api;

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
public class PartyGeographicInfoData implements Serializable {

	private static final long serialVersionUID = 6706720169173687012L;

	@NonNull
	private String code;
	
	@NonNull
	private String name;

	public PartyGeographicInfoData() {
	}
	
	public PartyGeographicInfoData(@NonNull String code, @NonNull String name) {
		
		this.code = code;
		this.name = name;
	}
}
