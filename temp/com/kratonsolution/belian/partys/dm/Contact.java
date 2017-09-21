/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

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

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="contact")
public class Contact implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="contact",nullable=false)
	private String contact;

	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private ContactType type = ContactType.OFFICE_PHONE;
	
	@Column(name="status")
	private boolean active;

	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
}
