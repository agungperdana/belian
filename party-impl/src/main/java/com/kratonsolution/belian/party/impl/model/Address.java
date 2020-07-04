package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.party.api.model.AddressType;

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
@Table(name="party_address")
public class Address implements Serializable
{
	private static final long serialVersionUID = 5974009777137751638L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="address", nullable=false)
	private String description;

	@Setter
	@Column(name="postal", nullable=false)
	private String postal;
	
	@Setter
	@Column(name="status", nullable=false)
	private boolean active;
	
	@Setter
	@Column(name="type", nullable=false)
	@Enumerated(EnumType.STRING)
	private AddressType type = AddressType.OFFICE;

	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="location_code")),
		@AttributeOverride(name = "name", column = @Column(name="location_name"))})
	private PartyGeographicInfo location;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	@NotFound(action = NotFoundAction.IGNORE)
	private Party party;
	
	@Version
	private Long version;
	
	Address(){}
	
	public Address(@NonNull Party parent, @NonNull String descriotion, @NonNull AddressType type, @NonNull PartyGeographicInfo location) {
		
		this.party = parent;
		this.description = descriotion;
		this.type = type;
		this.location = location;
	}
}
