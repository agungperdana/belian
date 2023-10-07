
package com.kratonsolution.belian.party.impl.orm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import com.kratonsolution.belian.country.impl.orm.Country;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name="passport")
public class Passport implements Serializable
{
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
