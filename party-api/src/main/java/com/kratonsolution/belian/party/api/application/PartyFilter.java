package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;

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
public class PartyFilter implements Serializable {

	private static final long serialVersionUID = -4668723464787436775L;

	private String code;
	
	private String name;
	
	private PartyType type;
	
	public boolean isValid() {
		return !Strings.isNullOrEmpty(code) || 
				!Strings.isNullOrEmpty(name) ||
				type != null;
	}
}
