package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PassportData implements Serializable
{
	private static final long serialVersionUID = 7679815085218407895L;

	private String number;
	
	private Instant issuedDate;
	
	private Instant expirationDate;
	
	private PartyGeographicInfoData country;
	
	public PassportData(){}
}
