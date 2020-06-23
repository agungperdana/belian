package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.google.common.base.Preconditions;
import com.kratonsolution.belian.common.model.Auditable;
import com.kratonsolution.belian.party.api.model.Gender;
import com.kratonsolution.belian.party.api.model.MaritalStatusType;
import com.kratonsolution.belian.party.api.model.PhysicalCharacteristicType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Entity
@Table(name="person")
public class Person extends Auditable implements Serializable
{
	private static final long serialVersionUID = 304354227477648871L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_party")
	@NotFound(action = NotFoundAction.IGNORE)
	private Party party;
	
	@Setter
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.MALE;
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<MaritalStatus> maritalStatuses = new HashSet<>();
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PhysicalCharacteristic> physicalCharacteristics = new HashSet<>();
	
	@OneToMany(mappedBy="person",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Citizenship> citizenships = new HashSet<>();
	
	@Version
	private Long version;
	
	Person(){}
	
	public Person(@NonNull String code, @NonNull String name){
		
		this.party = new Party(code, name);
	}
	
	public MaritalStatus createMaritalStatus(@NonNull Instant start, Instant end, @NonNull MaritalStatusType type) {

		Optional<MaritalStatus> status = this.maritalStatuses
				.stream()
				.filter(p-> p.getStart().equals(start) 
						&& p.getType().equals(type)).findAny();

		Preconditions.checkState(!status.isPresent(), "MaritalStatus already exist");

		MaritalStatus obj = new MaritalStatus(this, start, type);
		this.maritalStatuses.add(obj);

		return obj;
	}

	public Optional<MaritalStatus> updateMaritalStatus(@NonNull Instant start, @NonNull Instant end , @NonNull MaritalStatusType type) {

		Optional<MaritalStatus> status = this.maritalStatuses
											.stream()
											.filter(p-> p.getStart().equals(start) 
													&& p.getType().equals(type)).findAny();
		
		if(status.isPresent()) {
			status.get().setEnd(end);
		}
		
		return status;
	}

	public void removeMaritalStatus(@NonNull Instant start, @NonNull Optional<Instant> end, @NonNull MaritalStatusType type) {
		
		if(end.isPresent()) {
			
			this.maritalStatuses.removeIf(p->p.getStart().equals(start)
					&& p.getEnd().equals(end.get())
					&& p.getType().equals(type));
		}
		else {
			
			this.maritalStatuses.removeIf(p->p.getStart().equals(start) && p.getType().equals(type));
		}

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

	public Optional<PhysicalCharacteristic> updatePhysicalCharacteristic(@NonNull Instant start, @NonNull Instant end, @NonNull String value , @NonNull PhysicalCharacteristicType type) {

		Optional<PhysicalCharacteristic> status = this.physicalCharacteristics
											.stream()
											.filter(p-> p.getStart().equals(start) 
													&& p.getType().equals(type)).findAny();
		
		if(status.isPresent()) {
			status.get().setEnd(end);
			status.get().setValue(value);
		}
		
		return status;
	}

	public void removePhysicalCharacteristic(@NonNull Instant start, @NonNull Optional<Instant> end, @NonNull String value, @NonNull PhysicalCharacteristicType type) {
		
		if(end.isPresent()) {
			
			this.physicalCharacteristics.removeIf(p->p.getStart().equals(start)
					&& p.getEnd().equals(end.get())
					&& p.getValue().equals(value)
					&& p.getType().equals(type));
		}
		else {
			
			this.physicalCharacteristics.removeIf(p->p.getStart().equals(start)
					&& p.getValue().equals(value)
					&& p.getType().equals(type));
		}
	}

	/**
	 * for creating new PhysicalCharacteristic use createPhysicalCharacteristic() method\n
	 * calling getMPhysicalCharacteristics().add() will not add newly created PhysicalCharacteristic\n
	 * @return new Set containing PhysicalCharacteristic
	 */
	public Set<PhysicalCharacteristic> getPhysicalCharacteristic() {
		return new HashSet<>(this.physicalCharacteristics);
	}
	
	public Citizenship createCitizenship(@NonNull Instant start, Instant end, @NonNull String passport, @NonNull String countryCode, @NonNull String countryName) {

		Optional<Citizenship> status = this.citizenships
				.stream()
				.filter(p-> p.getStart().equals(start) 
						&& p.getPassport().equals(passport)
						&& p.getCountry().getCode().equals(countryCode)).findAny();

		Preconditions.checkState(!status.isPresent(), "Citizenship already exist");

		Citizenship obj = new Citizenship(this, start, passport, countryCode, countryName);
		obj.setEnd(end);
		this.citizenships.add(obj);

		return obj;
	}

	public Optional<Citizenship> updateCitizenship(@NonNull Instant start, @NonNull Instant end, @NonNull String passport , @NonNull PartyGeographicInfo country) {

		Optional<Citizenship> status = this.citizenships
											.stream()
											.filter(p-> p.getStart().equals(start) 
													&& p.getCountry().getCode().equals(country.getCode())
													&& p.getPassport().equals(passport)).findAny();
		
		if(status.isPresent()) {
			status.get().setEnd(end);
		}
		
		return status;
	}

	public void removeCitizenship(@NonNull Instant start, @NonNull Optional<Instant> end, @NonNull String passport, @NonNull PartyGeographicInfo country) {
		
		if(end.isPresent()) {
			
			this.citizenships.removeIf(p->p.getStart().equals(start)
					&& p.getEnd().equals(end.get())
					&& p.getPassport().equals(passport)
					&& p.getCountry().getCode().equals(country.getCode()));
		}
		else {
			
			this.citizenships.removeIf(p->p.getStart().equals(start)
					&& p.getPassport().equals(passport)
					&& p.getCountry().getCode().equals(country.getCode()));
		}
	}

	/**
	 * for creating new Citizenship use createCitizenship() method\n
	 * calling getCitizenships().add() will not add newly created Citizenship\n
	 * @return new Set containing Citizenship
	 */
	public Set<Citizenship> getCitizenships() {
		return new HashSet<>(this.citizenships);
	}
}