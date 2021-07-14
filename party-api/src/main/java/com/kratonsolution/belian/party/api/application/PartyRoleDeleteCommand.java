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
public class PartyRoleDeleteCommand implements Serializable {

	private static final long serialVersionUID = -8698395787961789301L;

	@NonNull
	private String partyCode;
	
	@NonNull
	private String partyRoleId;
}
