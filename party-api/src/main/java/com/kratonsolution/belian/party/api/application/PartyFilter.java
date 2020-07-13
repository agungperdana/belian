package com.kratonsolution.belian.party.api.application;

import com.google.common.base.Strings;
import com.kratonsolution.belian.party.api.model.PartyType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class PartyFilter {

	private String code;
	
	private String name;
	
	private PartyType type;
	
	public boolean isValid() {
		return !Strings.isNullOrEmpty(code) || 
				!Strings.isNullOrEmpty(name) ||
				type != null;
	}
}
