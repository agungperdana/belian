/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class PartyRoleType
{
	@Id
	private String id;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Version
	private Long version;
}
