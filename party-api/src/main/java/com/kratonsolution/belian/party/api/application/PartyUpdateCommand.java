package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.CitizenshipData;
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.MaritalStatusData;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.api.PhysicalCharacteristicData;
import com.kratonsolution.belian.party.api.model.Gender;
import com.kratonsolution.belian.party.api.model.PartyType;

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
public class PartyUpdateCommand implements Serializable {

	private static final long serialVersionUID = 5512864270414005583L;

	@NonNull
	private String code;
	
	private String name;

	private String taxCode;
	
	private String birthPlace;
	
	private Instant birthDate;

	private PartyType type;
	
	private Gender gender;
	
	private List<AddressData> addresses = new ArrayList<>();

	private List<ContactData> contacts = new ArrayList<>();

	private List<PartyRoleData> partyRoles = new ArrayList<>();

	private List<PartyRelationshipData> partyRelationships = new ArrayList<>();

	private List<PartyClassificationData> partyClassifications = new ArrayList<>();
	
	private List<MaritalStatusData> maritalStatuses = new ArrayList<>();
	
	private List<PhysicalCharacteristicData> physicalCharacteristics = new ArrayList<>();
	
	private List<CitizenshipData> citizenships = new ArrayList<>();
}
