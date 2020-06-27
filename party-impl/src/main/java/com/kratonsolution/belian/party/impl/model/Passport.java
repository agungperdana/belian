package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Entity
@Table(name="passport")
public class Passport implements Serializable
{
	private static final long serialVersionUID = 7679815085218407895L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="number")
	private String number;
	
	@Column(name="issued_date")
	private Instant issuedDate;
	
	@Column(name="expired_date")
	private Instant expirationDate;
		
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="country_code")),
		@AttributeOverride(name = "name", column = @Column(name="country_name"))
	})
	private PartyGeographicInfo country;
	
	@Version
	private Long version;
	
	Passport(){}
	
	public Passport(@NonNull String number, @NonNull Instant issued, @NonNull Instant expired, @NonNull String countryCode, @NonNull String countryName){
		
		this.number = number;
		this.issuedDate = issued;
		this.expirationDate = expired;
		this.country = new PartyGeographicInfo(countryCode, countryName);
	}
}
