/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="party_role_type")
@Inheritance(strategy=InheritanceType.JOINED)
public class PartyRoleType
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	protected String name;
	
	@Column(name="description")
	protected String description;
	
	@Column(name="deleteable")
	protected boolean deleteable = false;
	
	@Version
	protected Long version;
}
