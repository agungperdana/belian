
package com.kratonsolution.belian.partys.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="party_role")
@Inheritance(strategy=InheritanceType.JOINED)
public class PartyRole implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="start",nullable=false)
	protected Date start;
	
	@Column(name="end")
	protected Date end;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	protected Party party;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	protected PartyRoleType type;
	
	@Version
	protected Long version;
	
	public PartyRole(){}
}
