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
public class PartyUpdateCommand implements Serializable {

	private static final long serialVersionUID = 5512864270414005583L;

	@NonNull
	private String code;
	
	private String name;

	private String taxCode;
	
	private String birthPlace;
	
	private Instant birthDate;

	private PartyType type;
	
	private Gender gender;	
}
