package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.UUID;

import com.kratonsolution.belian.party.api.model.AddressType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class AddressData implements Serializable
{
	private static final long serialVersionUID = 5974009777137751638L;
	
	private final String dataID = UUID.randomUUID().toString();
	
	private String address;
		
	private String postal;
	
	private boolean active;
	
	private AddressType type;

	private PartyGeographicInfoData location;
	
	public AddressData(){}
}
