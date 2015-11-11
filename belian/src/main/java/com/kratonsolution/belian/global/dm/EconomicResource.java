/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name="economic_resource")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="resource_type")
public class EconomicResource implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();

	@Column(name="code")
	protected String code;
	
	@Column(name="name")
	protected String name;
	
	@Version
	protected Long version;
}