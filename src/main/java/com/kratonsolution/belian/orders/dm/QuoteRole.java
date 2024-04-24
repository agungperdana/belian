
package com.kratonsolution.belian.orders.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.partys.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="quote_role")
public class QuoteRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;

	@ManyToOne
	@JoinColumn(name="fk_quote")
	private Quote quote;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RoleType type = RoleType.INITIATOR;
	
	@Version
	private Long version;

	public QuoteRole(){}
}
