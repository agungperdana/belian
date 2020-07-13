package com.kratonsolution.belian.party.api.application;

import java.util.List;

import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.api.model.PartyType;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface PartyService {

	public PartyData create(@NonNull PartyCreateCommand command);

	public PartyData update(@NonNull PartyUpdateCommand command);

	public PartyData delete(@NonNull PartyDeleteCommand command);

	public int count();

	public int count(@NonNull PartyType type);

	public int count(@NonNull PartyFilter filter);

	public PartyData getById(@NonNull String id);

	public PartyData getByCode(@NonNull String code);

	public List<PartyData> getAllPartys();

	public List<PartyData> getAllPartys(@NonNull PartyType type);

	public List<PartyData> getAllPartys(@NonNull PartyType type, int page, int size);

	public List<PartyData> getAllPartys(int page, int size);

	public List<PartyData> getAllPartys(@NonNull PartyFilter filter, int page, int size);

	public AddressData createAddress(@NonNull AddressCreateCommand command);

	public AddressData updateAddress(@NonNull AddressUpdateCommand command);

	public void deleteAddress(@NonNull AddressDeleteCommand command);

	public ContactData createContact(@NonNull ContactCreateCommand command);

	public ContactData updateContact(@NonNull ContactUpdateCommand command);

	public void deleteContact(@NonNull ContactDeleteCommand command);
	
	public PartyRoleData createPartyRole(@NonNull PartyRoleCreateCommand command);

	public PartyRoleData updatePartyRole(@NonNull PartyRoleUpdateCommand command);

	public void deletePartyRole(@NonNull PartyRoleDeleteCommand command);
	
	public PartyRelationshipData createPartyRelationship(@NonNull PartyRelationshipCreateCommand command);

	public PartyRelationshipData updatePartyRelationship(@NonNull PartyRelationshipUpdateCommand command);

	public void deletePartyRelationship(@NonNull PartyRelationshipDeleteCommand command);
	
	public PartyClassificationData createPartyClassification(@NonNull PartyClassificationCreateCommand command);

	public PartyClassificationData updatePartyRelationship(@NonNull PartyClassificationUpdateCommand command);

	public void deletePartyClassification(@NonNull PartyClassificationDeleteCommand command);
}
