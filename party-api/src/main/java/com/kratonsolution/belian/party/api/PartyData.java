package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.MoreObjects;
import com.kratonsolution.belian.party.api.model.Gender;
import com.kratonsolution.belian.party.api.model.PartyType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PartyData implements Serializable
{	
	private static final long serialVersionUID = 1L;

	private String id;

	private String code;

	private String name;

	private String taxCode;

	private Date birthDate;

	private PartyType type;

	private PartyGeographicInfoData birthPlace;

	private Gender gender;

	private Set<MaritalStatusData> maritalStatuses = new HashSet<>();

	private Set<PhysicalCharacteristicData> physicalCharacteristics = new HashSet<>();

	private Set<CitizenshipData> citizenships = new HashSet<>();

	private Set<AddressData> addresses = new HashSet<>();

	private Set<ContactData> contacts = new HashSet<>();

	private Set<PartyRoleData> partyRoles = new HashSet<>();

	private Set<PartyRelationshipData> partyRelationships = new HashSet<>();

	private Set<PartyClassificationData> partyClassifications = new HashSet<>();

	public PartyData(){}

	@Override
	public String toString()
	{
		return MoreObjects.toStringHelper(this)
				.add("code", this.code)
				.add("name", this.name).toString();
	}
}
