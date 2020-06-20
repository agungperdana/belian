package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.common.model.Country;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
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
	private Date issuedDate;
	
	@Column(name="expiration_date")
	private Date expirationDate;
	
	@ManyToOne
	@JoinColumn(name="fk_country")
	private Country country;
	
	@Version
	private Long version;
	
	public Passport(){}
}
