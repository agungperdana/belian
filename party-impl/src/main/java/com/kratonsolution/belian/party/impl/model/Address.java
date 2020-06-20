package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.util.UUID;

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

import com.kratonsolution.belian.geographic.impl.model.Geographic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name="party_address")
public class Address implements Serializable
{
	private static final long serialVersionUID = 5974009777137751638L;

	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="address",nullable=false)
	private String address;
		
	@Column(name="postal",nullable=false)
	private String postal;
	
	@Column(name="status",nullable=false)
	private boolean active;
	
	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private AddressType type = AddressType.OFFICE;

	/**
	 * Negara
	 */
	@ManyToOne
	@JoinColumn(name="fk_country")
	@NotFound(action = NotFoundAction.IGNORE)
	private Geographic country;
	
	/**
	 * Provinsi
	 */
	@ManyToOne
	@JoinColumn(name="fk_province")
	@NotFound(action = NotFoundAction.IGNORE)
	private Geographic province;
	
	/**
	 * Kota/kabupaten
	 */
	@ManyToOne
	@JoinColumn(name="fk_city")
	@NotFound(action = NotFoundAction.IGNORE)
	private Geographic city;
	
	/**
	 * Kecamatan
	 */
	@ManyToOne
	@JoinColumn(name="fk_district")
	@NotFound(action = NotFoundAction.IGNORE)
	private Geographic district;
	
	/**
	 * Kelurahan
	 */
	@ManyToOne
	@JoinColumn(name="fk_sub_district")
	@NotFound(action = NotFoundAction.IGNORE)
	private Geographic subDistrict;
	
	/**
	 * RW
	 */
	@ManyToOne
	@JoinColumn(name="fk_rw")
	@NotFound(action = NotFoundAction.IGNORE)
	private Geographic rw;
	
	/**
	 * RT
	 */
	@ManyToOne
	@JoinColumn(name="fk_rt")
	@NotFound(action = NotFoundAction.IGNORE)
	private Geographic rt;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	@NotFound(action = NotFoundAction.IGNORE)
	private Party party;
	
	@Version
	private Long version;
	
	public Address(){}
}
