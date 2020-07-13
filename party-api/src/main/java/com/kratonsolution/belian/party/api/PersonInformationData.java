package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.kratonsolution.belian.party.api.model.Gender;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PersonInformationData implements Serializable
{
	private static final long serialVersionUID = 304354227477648871L;
	
	private Gender gender;
	
	private Set<MaritalStatusData> maritalStatuses = new HashSet<>();
	
	private Set<PhysicalCharacteristicData> physicalCharacteristics = new HashSet<>();
	
	private Set<CitizenshipData> citizenships = new HashSet<>();
	
	public PersonInformationData(){}
}
