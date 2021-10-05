package com.kratonsolution.belian.party.api.connector;

import java.util.List;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.CitizenshipData;
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.MaritalStatusData;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.api.PartyRouteName;
import com.kratonsolution.belian.party.api.application.AddressCreateCommand;
import com.kratonsolution.belian.party.api.application.AddressDeleteCommand;
import com.kratonsolution.belian.party.api.application.AddressUpdateCommand;
import com.kratonsolution.belian.party.api.application.CitizenshipCreateCommand;
import com.kratonsolution.belian.party.api.application.CitizenshipDeleteCommand;
import com.kratonsolution.belian.party.api.application.CitizenshipUpdateCommand;
import com.kratonsolution.belian.party.api.application.ContactCreateCommand;
import com.kratonsolution.belian.party.api.application.ContactDeleteCommand;
import com.kratonsolution.belian.party.api.application.ContactUpdateCommand;
import com.kratonsolution.belian.party.api.application.MaritalStatusCreateCommand;
import com.kratonsolution.belian.party.api.application.MaritalStatusDeleteCommand;
import com.kratonsolution.belian.party.api.application.MaritalStatusUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyFilter;
import com.kratonsolution.belian.party.api.application.PartyRelationshipCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyRelationshipDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyRelationshipUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;
import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.api.model.PartyType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@SuppressWarnings("unchecked")
public class PartyServiceProxy implements PartyService {

	@Autowired
	private ProducerTemplate producer;
	
	@Override
	public PartyData create(@NonNull PartyCreateCommand command) {
		return producer.requestBody(PartyRouteName.CREATE, command, PartyData.class);
	}

	@Override
	public PartyData update(@NonNull PartyUpdateCommand command) {
		return producer.requestBody(PartyRouteName.UPDATE, command, PartyData.class);
	}

	@Override
	public PartyData delete(@NonNull PartyDeleteCommand command) {
		return producer.requestBody(PartyRouteName.DELETE, command, PartyData.class);
	}

	@Override
	public int count() {
		return producer.requestBody(PartyRouteName.COUNT, null, Integer.class);
	}

	@Override
	public int count(@NonNull PartyType type) {
		return producer.requestBody(PartyRouteName.COUNT_WITH_TYPE, type, Integer.class);
	}

	@Override
	public int count(@NonNull PartyFilter filter) {
		return producer.requestBody(PartyRouteName.COUNT_WITH_FILTER, filter, Integer.class);
	}

	@Override
	public PartyData getById(@NonNull String id) {
		return producer.requestBody(PartyRouteName.BY_CODE, id, PartyData.class);
	}

	@Override
	public PartyData getByCode(@NonNull String code) {
		return producer.requestBody(PartyRouteName.BY_CODE, code, PartyData.class);
	}

	@Override
	public List<PartyData> getAllPartys() {
		return producer.requestBody(PartyRouteName.ALL_PARTYS, null, List.class);
	}

	@Override
	public List<PartyData> getAllPartys(@NonNull PartyType type) {
		return producer.requestBody(PartyRouteName.ALL_PARTYS_TYPE, type, List.class);
	}

	@Override
	public List<PartyData> getAllPartys(@NonNull PartyType type, int page, int size) {
		return producer.requestBody(
				PartyRouteName.ALL_PARTYS_TYPE_PAGING, 
				new Object[] {type, page, size}, List.class);
	}

	@Override
	public List<PartyData> getAllPartys(int page, int size) {
		return producer.requestBody(PartyRouteName.ALL_PARTYS_PAGING, new Integer[] {page, size}, List.class);
	}

	@Override
	public List<PartyData> getAllPartys(@NonNull PartyFilter filter, int page, int size) {
		return producer.requestBody(
				PartyRouteName.ALL_PARTYS_FILTER_PAGING, 
				new Object[] {filter, page, size}, List.class);
	}

	@Override
	public AddressData createAddress(@NonNull AddressCreateCommand command) {
		return producer.requestBody(PartyRouteName.CREATE_ADDRESS, command, AddressData.class);	
	}

	@Override
	public AddressData updateAddress(@NonNull AddressUpdateCommand command) {
		return producer.requestBody(PartyRouteName.UPDATE_ADDRESS, command, AddressData.class);	
	}

	@Override
	public void deleteAddress(@NonNull AddressDeleteCommand command) {
		producer.sendBody(PartyRouteName.DELETE_ADDRESS, ExchangePattern.InOnly, command);	
	}

	@Override
	public ContactData createContact(@NonNull ContactCreateCommand command) {
		return producer.requestBody(PartyRouteName.CREATE_CONTACT, command, ContactData.class);	
	}

	@Override
	public ContactData updateContact(@NonNull ContactUpdateCommand command) {
		return producer.requestBody(PartyRouteName.UPDATE_CONTACT, command, ContactData.class);	
	}

	@Override
	public void deleteContact(@NonNull ContactDeleteCommand command) {
		producer.sendBody(PartyRouteName.DELETE_CONTACT, ExchangePattern.InOnly, command);
	}

	@Override
	public PartyRoleData createPartyRole(@NonNull PartyRoleCreateCommand command) {
		return producer.requestBody(PartyRouteName.CREATE_ROLE, command, PartyRoleData.class);	
	}

	@Override
	public PartyRoleData updatePartyRole(@NonNull PartyRoleUpdateCommand command) {
		return producer.requestBody(PartyRouteName.UPDATE_ROLE, command, PartyRoleData.class);	
	}

	@Override
	public void deletePartyRole(@NonNull PartyRoleDeleteCommand command) {
		producer.sendBody(PartyRouteName.DELETE_ROLE, ExchangePattern.InOnly, command);
	}

	@Override
	public PartyRelationshipData createPartyRelationship(@NonNull PartyRelationshipCreateCommand command) {
		return producer.requestBody(PartyRouteName.CREATE_RELATIONSHIP, command, PartyRelationshipData.class);	
	}

	@Override
	public PartyRelationshipData updatePartyRelationship(@NonNull PartyRelationshipUpdateCommand command) {
		return producer.requestBody(PartyRouteName.UPDATE_RELATIONSHIP, command, PartyRelationshipData.class);	
	}

	@Override
	public void deletePartyRelationship(@NonNull PartyRelationshipDeleteCommand command) {
		producer.sendBody(PartyRouteName.DELETE_RELATIONSHIP, ExchangePattern.InOnly, command);
	}

	@Override
	public PartyClassificationData createPartyClassification(@NonNull PartyClassificationCreateCommand command) {
		return producer.requestBody(PartyRouteName.CREATE_CLASSIFICATION, command, PartyClassificationData.class);	
	}

	@Override
	public PartyClassificationData updatePartyClassification(@NonNull PartyClassificationUpdateCommand command) {
		return producer.requestBody(PartyRouteName.UPDATE_CLASSIFICATION, command, PartyClassificationData.class);	
	}

	@Override
	public PartyClassificationData deletePartyClassification(@NonNull PartyClassificationDeleteCommand command) {
		return producer.requestBody(PartyRouteName.DELETE_CLASSIFICATION, command, PartyClassificationData.class);
	}

	@Override
	public List<PartyData> getAllPartys(@lombok.NonNull PartyFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaritalStatusData createMaritalStatus(@lombok.NonNull MaritalStatusCreateCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MaritalStatusData updateMaritalStatus(@lombok.NonNull MaritalStatusUpdateCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMaritalStatus(@lombok.NonNull MaritalStatusDeleteCommand command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CitizenshipData createCitizenship(@lombok.NonNull CitizenshipCreateCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CitizenshipData updateCitizenship(@lombok.NonNull CitizenshipUpdateCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCitizenship(@lombok.NonNull CitizenshipDeleteCommand command) {
		// TODO Auto-generated method stub
		
	}
}
