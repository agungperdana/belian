package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;

import com.kratonsolution.belian.party.api.model.ContactType;

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
public class ContactCreateCommand implements Serializable {

	private static final long serialVersionUID = -2693016297671967959L;

	@NonNull
	private String partyCode;
	
	@NonNull
	private String contact;

	@NonNull
	private ContactType type;
	
	private boolean active;
}
