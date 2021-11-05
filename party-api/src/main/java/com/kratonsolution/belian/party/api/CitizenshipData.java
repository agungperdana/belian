package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class CitizenshipData implements Serializable
{
	private static final long serialVersionUID = 5343761111880173663L;

	private String id;
	
	private Date start;
	
	private Date end;
	
	private String passportNumber;
	
	private Date passportIssuedDate;
	
	private Date passportExpiredDate;
	
	private PartyGeographicInfoData country;
	
	public CitizenshipData(){}
}
