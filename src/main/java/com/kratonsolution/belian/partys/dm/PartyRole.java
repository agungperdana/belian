/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

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
