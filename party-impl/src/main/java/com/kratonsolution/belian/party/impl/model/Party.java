package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.kratonsolution.belian.party.api.model.AddressType;
import com.kratonsolution.belian.party.api.model.ContactType;
import com.kratonsolution.belian.party.api.model.Gender;
import com.kratonsolution.belian.party.api.model.MaritalStatusType;
import com.kratonsolution.belian.party.api.model.PartyClassificationType;
import com.kratonsolution.belian.party.api.model.PartyRelationshipType;
import com.kratonsolution.belian.party.api.model.PartyRoleType;
import com.kratonsolution.belian.party.api.model.PartyType;
import com.kratonsolution.belian.party.api.model.PhysicalCharacteristicType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Entity
@Table(name="party")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Party implements Serializable
{	
	private static final long serialVersionUID = 1L;

	@Getter
	@Id
	private String id = UUID.randomUUID().toString();

	@Getter
	@Column(name="code")
	private String code;

	@Getter
	@Setter
	@Column(name="name")
	private String name;

	@Getter
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private PartyType type;

	@Getter
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="birth_place_code")),
		@AttributeOverride(name = "name", column = @Column(name="birth_place_name"))})
	private PartyGeographicInfo birthPlace;

	@Getter
	@Setter
	@Column(name="birth_date")
	private Date birthDate;

	@Getter
	@Setter
	@Column(name="tax_code")
	private String taxCode;
	
	@Setter
	@Getter
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Version
	private Long version;

	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<MaritalStatus> maritalStatuses = new HashSet<>();

	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PhysicalCharacteristic> physicalCharacteristics = new HashSet<>();

	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Citizenship> citizenships = new HashSet<>();

	@OneToMany(mappedBy="party", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Address> addresses = new HashSet<>();

	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Set<Contact> contacts = new HashSet<>();

	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Set<PartyRole> partyRoles = new HashSet<>();

	@OneToMany(mappedBy="fromParty",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Set<PartyRelationship> partyRelationships = new HashSet<>();

	@OneToMany(mappedBy="party",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private Set<PartyClassification> partyClassifications = new HashSet<>();

	Party(){}

	public Party(@NonNull String code, @NonNull String name, @NonNull PartyType type)
	{
		this.code = code;
		this.name = name;
		this.type = type;
	}

	public Address createAddress(@NonNull String description, @NonNull AddressType type, @NonNull String locationCode, @NonNull String locationName) {

		Optional<Address> opt = this.addresses.stream()
				.filter(p->p.getDescription().equals(description) && 
						p.getType().equals(type)).findAny();

		Preconditions.checkState(!opt.isPresent(), "Address already exist");

		Address obj = new Address(this, description, type, new PartyGeographicInfo(locationCode, locationName));
		this.addresses.add(obj);

		return obj;
	}

	public Address updateAddress(@NonNull String id) {

		Optional<Address> opt = this.addresses.stream().filter(p->p.getId().equals(id)).findAny();
		return opt.orElse(null);
	}

	public void removeAddress(@NonNull String id) {
		this.addresses.removeIf(p->p.getId().equals(id));
	}

	/**
	 * for creating new address use createAddress() method
	 * calling getAddress().add() will not add newly created address
	 * @return new Set containing address
	 */
	public Set<Address> getAddresses() {
		return new HashSet<>(this.addresses);
	}

	public Contact createContact(@NonNull String contact, @NonNull ContactType type, boolean isActive) {

		Contact obj = new Contact(this, contact, type, isActive);
		this.contacts.add(obj);

		return obj;
	}

	public Contact updateContact(@NonNull String id) {

		Optional<Contact> opt = this.contacts.stream()
				.filter(p->p.getId().equals(id))
				.findFirst();
		return opt.orElse(null);
	}

	public void removeContact(@NonNull String id) {
		this.contacts.removeIf(p->p.getId().equals(id));
	}

	/**
	 * for creating new Contact use createContact() method
	 * calling getContacts().add() will not add newly created Contact
	 * @return new Set containing Contact
	 */
	public Set<Contact> getContacts() {
		return new HashSet<>(this.contacts);
	}

	public PartyRole createPartyRole(@NonNull Date start, @NonNull PartyRoleType type) {

		Optional<PartyRole> opt = this.partyRoles.stream()
				.filter(p->p.getStart().equals(start) && p.getType().equals(type)).findAny();

		Preconditions.checkState(!opt.isPresent(), "Party Role already exist");

		PartyRole obj = new PartyRole(this, start, type);
		this.partyRoles.add(obj);

		return obj;
	}

	public PartyRole updatePartyRole(@NonNull String id) {

		Optional<PartyRole> opt = this.partyRoles.stream()
				.filter(p->p.getId().equals(id))
				.findFirst();

		return opt.orElse(null);
	}

	public void removePartyRole(@NonNull String id) {

		partyRoles.removeIf(p->p.getId().equals(id));
	}

	/**
	 * for creating new PartyRole use createPartyRole() method
	 * calling getPartyRoles().add() will not add newly created PartyRole
	 * @return new Set containing PartyRole
	 */
	public Set<PartyRole> getPartyRoles() {
		return new HashSet<>(this.partyRoles);
	}

	public PartyRelationship createPartyRelationship(@NonNull Party toParty, 
													 @NonNull Date start, 
													 @NonNull PartyRelationshipType type) {

		Optional<PartyRelationship> opt = this.partyRelationships.stream()
				.filter(p->p.getStart().equals(start) 
						&& p.getType().equals(type)
						&& p.getToParty().getId().equals(toParty.getId())).findAny();

		Preconditions.checkState(!opt.isPresent(), "Party Relationship already exist");

		PartyRelationship obj = new PartyRelationship(this, toParty, start, type);
		this.partyRelationships.add(obj);

		return obj;
	}

	public PartyRelationship updatePartyRelationship(@NonNull String id, @NonNull Date end) {

		Optional<PartyRelationship> opt = this.partyRelationships.stream()
				.filter(p->p.getId().equals(id))
				.findAny();

		Preconditions.checkState(opt.isPresent(), "Relationship object not found");
		
		opt.get().setEnd(end);
		
		return opt.orElse(null);
	}

	public void removePartyRelationship(@NonNull String id) {
		partyRelationships.removeIf(p->p.getId().equals(id));
	}

	/**
	 * for creating new PartyRelationship use createPartyRelationship() method
	 * calling getPartyRelationships().add() will not add newly created PartyRelationship
	 * @return new Set containing PartyRelationship
	 */
	public Set<PartyRelationship> getPartyRelationships() {
		return new HashSet<>(this.partyRelationships);
	}

	public PartyClassification createPartyClassification(@NonNull Date start, @NonNull String value, @NonNull PartyClassificationType type) {

		Optional<PartyClassification> opt = this.partyClassifications.stream()
				.filter(p->p.getStart().equals(start) 
						&& p.getType().equals(type)
						&& p.getValue().equals(value)).findAny();

		Preconditions.checkState(!opt.isPresent(), "Party Classification already exist");

		PartyClassification obj = new PartyClassification(this, start, value, type);
		this.partyClassifications.add(obj);

		return obj;
	}

	public PartyClassification updatePartyClassification(@NonNull String id) {

		Optional<PartyClassification> opt = this.partyClassifications.stream()
				.filter(p->p.getId().equals(id))
				.findFirst();
		return opt.orElse(null);
	}

	public PartyClassification removePartyClassification(@NonNull String id) {
		
		Optional<PartyClassification> obj = partyClassifications.stream().filter(p->p.getId().equals(id)).findFirst();
		partyClassifications.removeIf(p->p.getId().equals(id));
		
		return obj.orElse(new PartyClassification());
	}

	/**
	 * for creating new PartyClassification use createPartyClassification() method
	 * calling getPartyClassification().add() will not add newly created PartyClassification
	 * @return new Set containing PartyClassification
	 */
	public Set<PartyClassification> getPartyClassifications() {
		return new HashSet<>(this.partyClassifications);
	}

	public MaritalStatus createMaritalStatus(@NonNull Date start, Date end, @NonNull MaritalStatusType type) {

		Optional<MaritalStatus> status = this.maritalStatuses
				.stream()
				.filter(p-> p.getStart().equals(start) 
						&& p.getType().equals(type)).findAny();

		Preconditions.checkState(!status.isPresent(), "Marital Status already exist");

		MaritalStatus obj = new MaritalStatus(this, start, type);
		this.maritalStatuses.add(obj);

		return obj;
	}

	public MaritalStatus updateMaritalStatus(@NonNull String id, @NonNull Date end) {

		MaritalStatus status = this.maritalStatuses
				.stream()
				.filter(p-> p.getId().equals(id)).findAny().orElse(null);
		
		if(status != null) {
			status.setEnd(end);
		}
		
		return status;
	}

	public void removeMaritalStatus(@NonNull String id) {
		this.maritalStatuses.removeIf(p -> p.getId().equals(id));
	}

	/**
	 * for creating new MaritalStatus use createMaritalStatus() method\n
	 * calling getMaritalStatuses().add() will not add newly created MaritalStatus\n
	 * @return new Set containing MaritalStatus
	 */
	public Set<MaritalStatus> getMaritalStatuses() {
		return new HashSet<>(this.maritalStatuses);
	}

	public PhysicalCharacteristic createPhysicalCharacteristic(@NonNull Instant start, Instant end, @NonNull String value, @NonNull PhysicalCharacteristicType type) {

		Optional<PhysicalCharacteristic> status = this.physicalCharacteristics
				.stream()
				.filter(p-> p.getStart().equals(start) 
						&& p.getValue().equals(value)
						&& p.getType().equals(type)).findAny();

		Preconditions.checkState(!status.isPresent(), "PhysicalCharacteristic already exist");

		PhysicalCharacteristic obj = new PhysicalCharacteristic(this, start, value, type);
		obj.setEnd(end);
		this.physicalCharacteristics.add(obj);

		return obj;
	}

	public PhysicalCharacteristic updatePhysicalCharacteristic(@NonNull String id) {

		return this.physicalCharacteristics
				.stream()
				.filter(p-> p.getId().equals(id)).findAny().orElse(null);
	}

	public void removePhysicalCharacteristic(@NonNull String id) {
		physicalCharacteristics.removeIf(p -> p.getId().equals(id));
	}

	/**
	 * for creating new PhysicalCharacteristic use createPhysicalCharacteristic() method\n
	 * calling getMPhysicalCharacteristics().add() will not add newly created PhysicalCharacteristic\n
	 * @return new Set containing PhysicalCharacteristic
	 */
	public Set<PhysicalCharacteristic> getPhysicalCharacteristics() {
		return new HashSet<>(this.physicalCharacteristics);
	}

	public Citizenship createCitizenship(@NonNull Date start, Date end, @NonNull String countryCode, @NonNull String countryName) {

		Optional<Citizenship> status = this.citizenships
				.stream()
				.filter(p-> p.getStart().equals(start) 
						&& p.getCountry().getCode().equals(countryCode)).findAny();

		Preconditions.checkState(!status.isPresent(), "Citizenship already exist");

		Citizenship obj = new Citizenship(this, start, countryCode, countryName);
		obj.setEnd(end);
		this.citizenships.add(obj);

		return obj;
	}

	public Citizenship updateCitizenship(@NonNull String id, Date end, 
										 Date passportIssuedDate, Date passportExpiredDate,
										 String passportNumber) {

		Citizenship data = this.citizenships
								.stream()
								.filter(p-> p.getId().equals(id))
								.findAny().orElse(null);
		if(data != null) {
			
			data.setEnd(end);
			data.setPassportExpiredDate(passportExpiredDate);
			data.setPassportIssuedDate(passportIssuedDate);
			data.setPassportNumber(passportNumber);
		}
		
		return data;
	}

	public void removeCitizenship(@NonNull String id) {
		citizenships.removeIf(p->p.getId().equals(id));
	}

	/**
	 * for creating new Citizenship use createCitizenship() method\n
	 * calling getCitizenships().add() will not add newly created Citizenship\n
	 * @return new Set containing Citizenship
	 */
	public Set<Citizenship> getCitizenships() {
		return new HashSet<>(this.citizenships);
	}

	@Override
	public String toString()
	{
		return MoreObjects.toStringHelper(this)
				.add("code", this.code)
				.add("name", this.name)
				.add("type", this.type)
				.toString();
	}
}
