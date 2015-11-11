/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="decrement_commitment")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="commitment_type")
public abstract class DecrementCommitment
{
	@Id
	protected String id = UUID.randomUUID().toString();

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="event")
	protected EconomicEvent event;
	
	@Version
	protected Long version;
}