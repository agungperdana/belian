package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.MoreObjects;

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
	
	private String code;

	private String name;

	private String taxCode;

	private Instant birthDate;
	
	private PartyGeographicInfoData birthPlace;
	
	private Set<AddressData> addresses = new HashSet<AddressData>();
	
	private Set<ContactData> contacts = new HashSet<ContactData>();
	
	private Set<PartyRoleData> partyRoles = new HashSet<>();
	
	private Set<PartyRelationshipData> relationships = new HashSet<>();
	
	private Set<PartyClassificationData> classifications = new HashSet<>();
	
	public PartyData(){}
	
	@Override
	public String toString()
	{
		return MoreObjects.toStringHelper(this)
				.add("code", this.code)
				.add("name", this.name).toString();
	}
}
