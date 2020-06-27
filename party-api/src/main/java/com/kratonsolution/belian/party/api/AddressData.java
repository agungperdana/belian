package com.kratonsolution.belian.party.api;

import java.io.Serializable;

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
	
	private String address;
		
	private String postal;
	
	private boolean active;
	
	private AddressType type;

	/**
	 * Negara
	 */
	private PartyGeographicInfoData country;
	
	/**
	 * Provinsi
	 */
	private PartyGeographicInfoData province;
	
	/**
	 * Kota/kabupaten
	 */
	private PartyGeographicInfoData city;
	
	/**
	 * Kecamatan
	 */
	private PartyGeographicInfoData district;
	
	/**
	 * Kelurahan
	 */
	private PartyGeographicInfoData subDistrict;
	
	/**
	 * RW
	 */
	private PartyGeographicInfoData rw;
	
	/**
	 * RT
	 */
	private PartyGeographicInfoData rt;
	
	public AddressData(){}
}
