package com.kratonsolution.belian.party.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.kratonsolution.belian.common.spring.SpecificationBuilder;
import com.kratonsolution.belian.common.spring.SpecificationBuilder.Operator;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.api.application.AddressCreateCommand;
import com.kratonsolution.belian.party.api.application.AddressDeleteCommand;
import com.kratonsolution.belian.party.api.application.AddressUpdateCommand;
import com.kratonsolution.belian.party.api.application.ContactCreateCommand;
import com.kratonsolution.belian.party.api.application.ContactDeleteCommand;
import com.kratonsolution.belian.party.api.application.ContactUpdateCommand;
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
import com.kratonsolution.belian.party.impl.model.Contact;
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
@Transactional(readOnly = true)
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyRepository repo;

	@Autowired
	private GeographicService geoService;

	@Override
	public PartyData create(@NonNull PartyCreateCommand command) {

		Party ondb = repo.findOneByCode(command.getCode());
		Preconditions.checkState(ondb == null, "Party with code {} already exist");

		Party party = new Party(command.getCode(), command.getName(), command.getType());
		party.setTaxCode(command.getTaxCode());
		party.setBirthDate(command.getBirthDate());
		
		if(!Strings.isNullOrEmpty(command.getBirthPlace()) && geoService.getByCode(command.getBirthPlace()) != null) {

			GeographicData geo = geoService.getByCode(command.getBirthPlace());
			party.setBirthPlace(new PartyGeographicInfo(geo.getCode(), geo.getName()));
		}

		repo.save(party);
		log.info("Create new party data {}", party);

		return PartyMapper.INSTANCE.toData(party);
	}

	@Override
	public PartyData update(@NonNull PartyUpdateCommand command) {

		Party party = getAndCheck(command.getCode());

		if(command.getBirthDate() != null) {
			party.setBirthDate(command.getBirthDate());
		}

		if(!Strings.isNullOrEmpty(command.getBirthPlace()) && geoService.getByCode(command.getBirthPlace()) != null) {
			
			GeographicData geo = geoService.getByCode(command.getBirthPlace());
			party.setBirthPlace(new PartyGeographicInfo(geo.getCode(), geo.getName()));
		}

		if(!Strings.isNullOrEmpty(command.getName())) {
			party.setName(command.getName());
		}

		if(!Strings.isNullOrEmpty(command.getTaxCode())) {
			party.setTaxCode(command.getTaxCode());
		}

		repo.save(party);
		
		log.info("Updating Party data {}", party);

		return PartyMapper.INSTANCE.toData(party);

	}

	@Override
	public PartyData delete(@NonNull PartyDeleteCommand command) {

		Party party = getAndCheck(command.getCode());
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
		
		if(filter.isValid()) {

			SpecificationBuilder<Party> builder = new SpecificationBuilder<>();

			if(!Strings.isNullOrEmpty(filter.getCode())) {
				builder.combine((root, query, cb) -> {return cb.like(root.get("code"), filter.getCode());}, Operator.OR);
			}

			if(!Strings.isNullOrEmpty(filter.getName())) {
				builder.combine((root, query, cb) -> {return cb.like(root.get("name"), filter.getName());}, Operator.OR);
			}

			if(filter.getType() != null) {
				builder.combine((root, query, cb) -> {return cb.equal(root.get("type"), filter.getType());}, Operator.OR);
			}
			
			if(builder.getParent().isPresent()) {
				return Long.valueOf(repo.count(Specification.where(builder.getParent().get()))).intValue();
			}
		}
		
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

		if(filter.isValid()) {

			SpecificationBuilder<Party> builder = new SpecificationBuilder<>();

			if(!Strings.isNullOrEmpty(filter.getCode())) {
				builder.combine((root, query, cb) -> {return cb.like(root.get("code"), filter.getCode());}, Operator.OR);
			}

			if(!Strings.isNullOrEmpty(filter.getName())) {
				builder.combine((root, query, cb) -> {return cb.like(root.get("name"), filter.getName());}, Operator.OR);
			}

			if(filter.getType() != null) {
				builder.combine((root, query, cb) -> {return cb.equal(root.get("type"), filter.getType());}, Operator.OR);
			}
			
			if(builder.getParent().isPresent()) {
				return PartyMapper.INSTANCE.toDatas(repo.findAll(Specification.where(builder.getParent().get()), PageRequest.of(page, size)).getContent());
			}
		}

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
	
	private Party getAndCheck(@NonNull String partyCode) {
		
		Party party = repo.findOneByCode(partyCode);
		Preconditions.checkState(party != null, "Party does not exist");
		return party;
	}
	
	@Override
	public AddressData createAddress(@NonNull AddressCreateCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		
		GeographicData location = geoService.getByCode(command.getLocation());
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

		Party party = getAndCheck(command.getPartyCode());
		Address address = party.updateAddress(command.getAddressId());
		
		Preconditions.checkState(address != null, "Address not exist");
		
		GeographicData location = geoService.getByCode(command.getLocation());
		Preconditions.checkState(location != null, "Geographic location does not exist");
		
		address.setActive(command.isActive());
		address.setPostal(command.getPostal());
		address.setType(command.getType());
		address.setLocation(new PartyGeographicInfo(location.getCode(), location.getName()));
		
		repo.save(party);
		log.info("Update address", address);
		
		return AddressMapper.INSTANCE.toData(address);
	}

	@Override
	public void deleteAddress(@NonNull AddressDeleteCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		party.removeAddress(command.getAddressId());
		
		repo.save(party);
		log.info("Removing address ...");
	}

	@Override
	public ContactData createContact(@NonNull ContactCreateCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		
		boolean exist = party.getContacts().stream().anyMatch(con -> 
				con.getContact().equals(command.getContact()) && con.getType().equals(command.getType()));
		
		Preconditions.checkState(!exist, "Contact already exist");
		
		Contact contact = party.createContact(command.getContact(), command.getType());
		contact.setActive(command.isActive());
		
		repo.save(party);
		log.info("Creating new Contact {}", contact);
		
		return ContactMapper.INSTANCE.toData(contact);
	}

	@Override
	public ContactData updateContact(@NonNull ContactUpdateCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		
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
		
		Party party = getAndCheck(command.getPartyCode());	
		party.getContacts().removeIf(p->p.getId().equals(command.getContactId()));
		log.info("Deleteing contact..");
	}

	@Override
	public PartyRoleData createPartyRole(@NonNull PartyRoleCreateCommand command) {

		Party party = getAndCheck(command.getPartyCode());
		
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
		
		Party party = getAndCheck(command.getPartyCode());
		
		PartyRole opt = party.updatePartyRole(command.getPartyRoleId());
		opt.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Updating party role {}", opt);
		
		return PartyRoleMapper.INSTANCE.toData(opt);
	}

	@Override
	public void deletePartyRole(@NonNull PartyRoleDeleteCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		party.removePartyRole(command.getPartyRoleId());
		log.info("Deleting partyRole ..");
	}

	@Override
	public PartyRelationshipData createPartyRelationship(@NonNull PartyRelationshipCreateCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		Party toParty = getAndCheck(command.getToPartyCode());
		
		PartyRelationship relationship = party.createPartyRelationship(toParty, command.getStart(), command.getType());
		relationship.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Creating new Party Relationship {}", relationship);
		
		return PartyRelationshipMapper.INSTANCE.toData(relationship);
	}

	@Override
	public PartyRelationshipData updatePartyRelationship(@NonNull PartyRelationshipUpdateCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		PartyRelationship opt = party.updatePartyRelationship(command.getPartyRelationshipId());
		opt.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Updating party relationship", opt);
		
		return PartyRelationshipMapper.INSTANCE.toData(opt);
	}

	@Override
	public void deletePartyRelationship(@NonNull PartyRelationshipDeleteCommand command) {

		Party party = getAndCheck(command.getPartyCode());
		party.removePartyRelationship(command.getPartyRelationshipId());
		
		repo.save(party);
		log.info("Removinf party relationship ...");
	}
	
	@Override
	public PartyClassificationData createPartyClassification(@NonNull PartyClassificationCreateCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		PartyClassification opt = party.createPartyClassification(command.getStart(), 
				command.getValue(), command.getType());
		opt.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Creating Party Classification {}", opt);
		
		return PartyClassificationMapper.INSTANCE.toData(opt);
	}

	@Override
	public PartyClassificationData updatePartyRelationship(@NonNull PartyClassificationUpdateCommand command) {
		
		Party party = getAndCheck(command.getPartyCode());
		PartyClassification opt = party.updatePartyClassification(command.getPartyClassificationId());
		opt.setEnd(command.getEnd());
		
		repo.save(party);
		log.info("Updating party classification {}", opt);
		
		return PartyClassificationMapper.INSTANCE.toData(opt);
	}

	@Override
	public void deletePartyClassification(@NonNull PartyClassificationDeleteCommand command) {
		Party party = getAndCheck(command.getPartyCode());
		party.removePartyClassification(command.getPartyClassificationId());
		log.info("Removing party classification ...");
	}
}
