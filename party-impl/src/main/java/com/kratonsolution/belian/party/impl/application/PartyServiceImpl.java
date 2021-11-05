package com.kratonsolution.belian.party.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.CitizenshipData;
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.MaritalStatusData;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.PartyRoleData;
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
import com.kratonsolution.belian.party.impl.model.Address;
import com.kratonsolution.belian.party.impl.model.Citizenship;
import com.kratonsolution.belian.party.impl.model.Contact;
import com.kratonsolution.belian.party.impl.model.MaritalStatus;
import com.kratonsolution.belian.party.impl.model.Party;
import com.kratonsolution.belian.party.impl.model.PartyClassification;
import com.kratonsolution.belian.party.impl.model.PartyGeographicInfo;
import com.kratonsolution.belian.party.impl.model.PartyRelationship;
import com.kratonsolution.belian.party.impl.model.PartyRole;
import com.kratonsolution.belian.party.impl.repository.PartyRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository repo;

	@Autowired
	private GeographicService geo;
	
	@Override
	public PartyData create(@NonNull PartyCreateCommand command) {

		Party ondb = repo.findOneByCode(command.getCode());
		Preconditions.checkState(ondb == null, "Party with code {} already exist");

		Party party = new Party(command.getCode(), command.getName(), command.getType());
		party.setTaxCode(command.getTaxCode());
		party.setBirthDate(command.getBirthDate());
		party.setGender(command.getGender());
		
		if(!Strings.isNullOrEmpty(command.getBirthPlace())) {

			GeographicData data = geo.getByCode(command.getBirthPlace());
			if(data != null) {
				party.setBirthPlace(new PartyGeographicInfo(data.getCode(), data.getName()));
			}
		}
		
		repo.save(party);
		
		log.info("Create new party data {}", party);

		return PartyMapper.INSTANCE.toData(party);
	}

	@Override
	public PartyData update(@NonNull PartyUpdateCommand command) {

		Party party = check(command.getCode());
		party.setName(command.getName());
		party.setTaxCode(command.getTaxCode());
		party.setBirthDate(command.getBirthDate());
		party.setGender(command.getGender());
		
		if(!Strings.isNullOrEmpty(command.getBirthPlace())) {
			
			GeographicData data = geo.getByCode(command.getBirthPlace());
			party.setBirthPlace(new PartyGeographicInfo(data.getCode(), data.getName()));
		}
		
		repo.save(party);
		
		log.info("Updating Party data {}", party);

		return PartyMapper.INSTANCE.toData(party);
	}

	@Override
	public PartyData delete(@NonNull PartyDeleteCommand command) {

		Party party = check(command.getCode());
		repo.delete(party);
		log.info("Removing organization data {}", party);

		return PartyMapper.INSTANCE.toData(party);
	}

	@Override
	public int count() {
		return Long.valueOf(repo.count()).intValue();
	}

	@Override
	public int count(@NonNull PartyFilter filter) {
				
		return 0;
	}

	@Override
	public PartyData getByCode(@NonNull String code) {
		return PartyMapper.INSTANCE.toData(repo.findOneByCode(code));
	}

	@Override
	public List<PartyData> getAllPartys() {
		return PartyMapper.INSTANCE.toDatas(repo.findAll());
	}

	@Override
	public List<PartyData> getAllPartys(int page, int size) {
		return PartyMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
	}

	@Override
	public List<PartyData> getAllPartys(@NonNull PartyFilter filter, int page, int size) {

		return getAllPartys(page, size);
	}

	@Override
	public PartyData getById(@NonNull String id) {
		return PartyMapper.INSTANCE.toData(repo.getOne(id));
	}

	@Override
	public List<PartyData> getAllPartys(@NonNull PartyType type) {
		return PartyMapper.INSTANCE.toDatas(repo.findAllByType(type));
	}

	@Override
	public List<PartyData> getAllPartys(@NonNull PartyType type, int page, int size) {
		return PartyMapper.INSTANCE.toDatas(repo.findAllByType(type, PageRequest.of(page, size)));
	}

	@Override
	public int count(@NonNull PartyType type) {
		return repo.count(type).intValue();
	}
	
	private Party check(@NonNull String code) {
		
		Party party = repo.findOneByCode(code);
		Preconditions.checkState(party != null, "Party does not exist");
		return party;
	}
	
	@Override
	public AddressData createAddress(@NonNull AddressCreateCommand command) {
		
		Party party = check(command.getPartyCode());
		
		GeographicData location = geo.getByCode(command.getLocation());
		Preconditions.checkState(location != null, "Geographic location does not exist");
		
		Address address = party.createAddress(command.getAddress(), command.getType(), location.getCode(), location.getName());
		address.setActive(command.isActive());
		address.setPostal(command.getPostal());
		
		repo.save(party);
		
		log.info("Adding new address {} for party {}", address, party);
		
		return AddressMapper.INSTANCE.toData(address);
	}

	@Override
	public AddressData updateAddress(@NonNull AddressUpdateCommand command) {

		Party party = check(command.getPartyCode());
		Address address = party.updateAddress(command.getAddressId());
		
		Preconditions.checkState(address != null, "Address not exist");
		
		address.setActive(command.isActive());
		address.setPostal(command.getPostal());
		
		repo.save(party);
		log.info("Update address", address);
		
		return AddressMapper.INSTANCE.toData(address);
	}

	@Override
	public void deleteAddress(@NonNull AddressDeleteCommand command) {
		
		Party party = check(command.getPartyCode());
		party.removeAddress(command.getAddressId());
		
		repo.save(party);
		log.info("Removing address ...");
	}

	@Override
	public ContactData createContact(@NonNull ContactCreateCommand command) {
		
		Party party = check(command.getPartyCode());
		
		boolean exist = party.getContacts().stream().anyMatch(con -> 
				con.getContact().equals(command.getContact()) && con.getType().equals(command.getType()));
		
		Preconditions.checkState(!exist, "Contact already exist");
		
		Contact contact = party.createContact(command.getContact(), command.getType(), command.isActive());
		
		repo.save(party);
		log.info("Creating new Contact {}", contact);
		
		return ContactMapper.INSTANCE.toData(contact);
	}

	@Override
	public ContactData updateContact(@NonNull ContactUpdateCommand command) {
		
		Party party = check(command.getPartyCode());
		
		Optional<Contact> opt = party.getContacts().stream().filter(p->
									p.getId().equals(command.getContactId()))
									.findFirst();
		
		Preconditions.checkState(opt.isPresent(), "Contact does not exist");
		
		opt.get().setActive(command.isActive());
		repo.save(party);
		log.info("Update Contact {}", opt.get());
		
		return ContactMapper.INSTANCE.toData(opt.get());
	}

	@Override
	public void deleteContact(@NonNull ContactDeleteCommand command) {
		
		Party party = check(command.getPartyCode());	
		party.removeContact(command.getContactId());

		repo.save(party);
		log.info("deleting contact with id {}", command.getContactId());
	}

	@Override
	public PartyRoleData createPartyRole(@NonNull PartyRoleCreateCommand command) {

		Party party = check(command.getPartyCode());
		
		Optional<PartyRole> on = party.getPartyRoles().stream()
				.filter(rol->rol.getStart().equals(command.getStart()) && 
						rol.getType().equals(command.getType())).findFirst();
		
		Preconditions.checkState(!on.isPresent(), "Party role already exist");
		
		PartyRole role = party.createPartyRole(command.getStart(), command.getType());
		role.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Creating new Party Role {}", role);
		
		return PartyRoleMapper.INSTANCE.toData(role);
	}

	@Override
	public PartyRoleData updatePartyRole(@NonNull PartyRoleUpdateCommand command) {
		
		Party party = check(command.getPartyCode());
		
		PartyRole opt = party.updatePartyRole(command.getPartyRoleId());
		opt.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Updating party role {}", opt);
		
		return PartyRoleMapper.INSTANCE.toData(opt);
	}

	@Override
	public void deletePartyRole(@NonNull PartyRoleDeleteCommand command) {
		
		Party party = check(command.getPartyCode());
		party.removePartyRole(command.getPartyRoleId());
		log.info("Deleting partyRole ..");
	}

	@Override
	public PartyRelationshipData createPartyRelationship(@NonNull PartyRelationshipCreateCommand command) {
		
		Party party = check(command.getPartyCode());
		Party toParty = check(command.getToPartyCode());
		
		PartyRelationship relationship = party.createPartyRelationship(toParty, command.getStart(), command.getType());
		relationship.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Creating new Party Relationship {}", relationship);
		
		return PartyRelationshipMapper.INSTANCE.toData(relationship);
	}

	@Override
	public PartyRelationshipData updatePartyRelationship(@NonNull PartyRelationshipUpdateCommand command) {
		
		Party party = check(command.getPartyCode());
		PartyRelationship opt = party.updatePartyRelationship(command.getRelationshipId(), command.getEnd());
		repo.save(party);

		log.info("Updating party relationship", opt);
		
		return PartyRelationshipMapper.INSTANCE.toData(opt);
	}

	@Override
	public void deletePartyRelationship(@NonNull PartyRelationshipDeleteCommand command) {

		Party party = check(command.getPartyCode());
		party.removePartyRelationship(command.getRelationshipId());
		
		repo.save(party);
		log.info("Removinf party relationship ...");
	}
	
	@Override
	public PartyClassificationData createPartyClassification(@NonNull PartyClassificationCreateCommand command) {
		
		Party party = check(command.getPartyCode());
		PartyClassification opt = party.createPartyClassification(command.getStart(), 
				command.getValue(), command.getType());
		opt.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Creating Party Classification {}", opt);
		
		return PartyClassificationMapper.INSTANCE.toData(opt);
	}

	@Override
	public PartyClassificationData updatePartyClassification(@NonNull PartyClassificationUpdateCommand command) {
		
		Party party = check(command.getPartyCode());
		PartyClassification opt = party.updatePartyClassification(command.getPartyClassificationId());
		opt.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Updating party classification {}", opt);
		
		return PartyClassificationMapper.INSTANCE.toData(opt);
	}

	@Override
	public PartyClassificationData deletePartyClassification(@NonNull PartyClassificationDeleteCommand command) {
		
		Party party = check(command.getPartyCode());
		return PartyClassificationMapper.INSTANCE.toData(
				party.removePartyClassification(
						command.getPartyClassificationId()));
	}

	@Override
	public List<PartyData> getAllPartys(@NonNull PartyFilter filter) {
		
		if(Strings.isNullOrEmpty(filter.getKey())) {
			return PartyMapper.INSTANCE.toDatas(repo.getAll(PageRequest.of(filter.getPage(), filter.getSize())));
		}
		else {
			return PartyMapper.INSTANCE.toDatas(
					repo.getAll("%"+filter.getKey()+"%", 
							PageRequest.of(filter.getPage(), filter.getSize())));
		}

	}

	@Override
	public MaritalStatusData createMaritalStatus(@NonNull MaritalStatusCreateCommand command) {

		Party party = check(command.getPartyCode());
		MaritalStatus data = party.createMaritalStatus(command.getStart(), command.getEnd(), command.getType());
		
		repo.save(party);
		
		return MaritalStatusMapper.INSTANCE.toData(data);
	}

	@Override
	public MaritalStatusData updateMaritalStatus(@NonNull MaritalStatusUpdateCommand command) {

		Party party = check(command.getPartyCode());
		MaritalStatus data = party.updateMaritalStatus(command.getStatusId(), command.getEnd());
		
		repo.save(party);
		
		return MaritalStatusMapper.INSTANCE.toData(data);
	}

	@Override
	public void deleteMaritalStatus(@NonNull MaritalStatusDeleteCommand command) {
		
		Party party = check(command.getPartyCode());
		party.removeMaritalStatus(command.getStatusId());
		repo.save(party);
	}

	@Override
	public CitizenshipData createCitizenship(@NonNull CitizenshipCreateCommand command) {

		Party party = check(command.getPartyCode());
		
		Preconditions.checkState(party.getType().equals(PartyType.PERSON), "Target party is not person");
		
		GeographicData country = geo.getByCode(command.getCountryCode());
		Preconditions.checkState(country != null, "Country does not exist!");
		
		Citizenship data = party.createCitizenship(command.getStart(), command.getEnd(), country.getCode(), country.getName());
		data.setPassportExpiredDate(command.getPassportExpiredDate());
		data.setPassportIssuedDate(command.getPassportIssuedDate());
		data.setPassportNumber(command.getPassportNumber());
		
		repo.save(party);
		
		return CitizenshipMapper.INSTANCE.toData(data);
	}

	@Override
	public CitizenshipData updateCitizenship(@NonNull CitizenshipUpdateCommand command) {

		Party party = check(command.getPartyCode());
		
		Preconditions.checkState(party.getType().equals(PartyType.PERSON), "Target party is not person");
		
		Citizenship data = party.updateCitizenship(command.getCitizenshipId(), command.getEnd(), 
												   command.getPassportIssuedDate(),
												   command.getPassportExpiredDate(), 
												   command.getPassportNumber());
		repo.save(party);
		
		return CitizenshipMapper.INSTANCE.toData(data);
	}

	@Override
	public void deleteCitizenship(@NonNull CitizenshipDeleteCommand command) {
		
		Party party = check(command.getPartyCode());

		Preconditions.checkState(party.getType().equals(PartyType.PERSON), "Target party is not person");
		
		party.removeCitizenship(command.getCitizenshipId());
		
		repo.save(party);
		log.info("Removing Pary {} citizenship data", command.getPartyCode());
	}
}
