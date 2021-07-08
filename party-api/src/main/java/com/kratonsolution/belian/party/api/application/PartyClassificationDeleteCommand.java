package com.kratonsolution.belian.party.api.application;

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
public class PartyClassificationDeleteCommand implements Serializable {

	private static final long serialVersionUID = 6761069037799894595L;

	@NonNull
	private String partyCode;
	
	@NonNull
	private String partyClassificationId;
}