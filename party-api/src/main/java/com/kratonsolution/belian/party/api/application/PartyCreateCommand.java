package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;
import java.time.Instant;

import com.kratonsolution.belian.party.api.model.Gender;
import com.kratonsolution.belian.party.api.model.PartyType;

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
public class PartyCreateCommand implements Serializable {

	private static final long serialVersionUID = -8961482566968042225L;

	@NonNull
	private String code;
	
	@NonNull
	private String name;
	
	@NonNull
	private PartyType type;

	private String taxCode;
	
	private String birthPlace;
	
	private Instant birthDate;
	
	private Gender gender;
}
