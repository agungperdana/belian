/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.UUID;

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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="increment_commitment")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="commitment_type")
public abstract class IncrementCommitment
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Version
	protected Long version;
}
