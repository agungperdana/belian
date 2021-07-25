package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;

import com.kratonsolution.belian.party.api.model.AddressType;

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
public class AddressCreateCommand implements Serializable {

	private static final long serialVersionUID = 5315672072103634858L;

	@NonNull
	private String partyCode;
	
	@NonNull
	private String address;
	
	private String postal;
	
	private boolean active;
	
	@NonNull
	private AddressType type;

	@NonNull
	private String location;
}
