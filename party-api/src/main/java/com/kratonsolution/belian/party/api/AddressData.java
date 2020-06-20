package com.kratonsolution.belian.party.api;

import java.io.Serializable;

import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.party.api.model.AddressType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
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
	private GeographicData country;
	
	/**
	 * Provinsi
	 */
	private GeographicData province;
	
	/**
	 * Kota/kabupaten
	 */
	private GeographicData city;
	
	/**
	 * Kecamatan
	 */
	private GeographicData district;
	
	/**
	 * Kelurahan
	 */
	private GeographicData subDistrict;
	
	/**
	 * RW
	 */
	private GeographicData rw;
	
	/**
	 * RT
	 */
	private GeographicData rt;
	
	public AddressData(){}
}
