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
	
	@Column(name="address",nullable=false)
	private String address;

	@Setter
	@Column(name="postal",nullable=false)
	private String postal;
	
	@Setter
	@Column(name="status",nullable=false)
	private boolean active;
	
	@Setter
	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private AddressType type = AddressType.OFFICE;

	/**
	 * Negara
	 */
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="country_code")),
		@AttributeOverride(name = "name", column = @Column(name="country_name"))})
	private PartyGeographicInfo country;
	
	/**
	 * Provinsi
	 */
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="province_code")),
		@AttributeOverride(name = "name", column = @Column(name="province_name"))})
	private PartyGeographicInfo province;
	
	/**
	 * Kota/kabupaten
	 */
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="city_code")),
		@AttributeOverride(name = "name", column = @Column(name="city_name"))})
	private PartyGeographicInfo city;
	
	/**
	 * Kecamatan
	 */
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="district_code")),
		@AttributeOverride(name = "name", column = @Column(name="district_name"))})
	private PartyGeographicInfo district;
	
	/**
	 * Kelurahan
	 */
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="sub_district_code")),
		@AttributeOverride(name = "name", column = @Column(name="sub_district_name"))})
	private PartyGeographicInfo subDistrict;
	
	/**
	 * RW
	 */
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="rw_code")),
		@AttributeOverride(name = "name", column = @Column(name="rw_name"))})
	private PartyGeographicInfo rw;
	
	/**
	 * RT
	 */
	@Setter
	@AttributeOverrides({
		@AttributeOverride(name = "code", column = @Column(name="rt_code")),
		@AttributeOverride(name = "name", column = @Column(name="rt_name"))})
	private PartyGeographicInfo rt;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	@NotFound(action = NotFoundAction.IGNORE)
	private Party party;
	
	@Version
	private Long version;
	
	Address(){}
	
	public Address(@NonNull Party parent, @NonNull String address, @NonNull AddressType type) {
		
		this.party = parent;
		this.address = address;
		this.type = type;
	}
}
