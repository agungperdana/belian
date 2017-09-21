/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="party_relationship")
@Inheritance(strategy=InheritanceType.JOINED)
public class PartyRelationship implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="start",nullable=false)
	protected Date start;
	
	@Column(name="end")
	protected Date end;
	
	@ManyToOne
	@JoinColumn(name="fk_from_role")
	protected PartyRole fromRole;
	
	@ManyToOne
	@JoinColumn(name="fk_to_role")
	protected PartyRole toRole;
	
	@Version
	protected Long version;
	
	public PartyRelationship(){}
}
