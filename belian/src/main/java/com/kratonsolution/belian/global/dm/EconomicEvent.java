/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="economic_event")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class EconomicEvent implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	protected String name;
	
	@Column(name="amount")
	protected BigDecimal amount = BigDecimal.ONE;
	
	@Column(name="date")
	protected Date date;
	
	@Version
	protected Long version;
	
	public abstract EconomicAgent getInternal();
	
	public abstract EconomicAgent getExternal();
	
	public abstract EconomicResource getResource();
}
