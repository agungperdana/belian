package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name="citizenship")
public class Citizenship implements Serializable
{
	private static final long serialVersionUID = 5343761111880173663L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Setter
	@Column(name="end")
	private Date end;

	@Column(name="passport_number")
	private String passportNumber;
	
	@Column(name="passport_issued_date")
	private Date passportIssuedDate;
	
	@Column(name="passport_expired_date")
	private Date passportExpiredDate;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="country_code")),
		@AttributeOverride(name = "name", column = @Column(name="country_name"))
	})
	private PartyGeographicInfo country;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
	
	Citizenship(){}
	
	public Citizenship(@NonNull Party parent, @NonNull Date start,
			@NonNull String countryCode, @NonNull String countryName){
		
		this.party = parent;
		this.start = start;
		this.country = new PartyGeographicInfo(countryCode, countryName); 
	}
}
