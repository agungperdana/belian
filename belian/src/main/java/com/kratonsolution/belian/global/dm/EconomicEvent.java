/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
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
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="economic_event")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="event_type")
public abstract class EconomicEvent<R extends EconomicResource>
{
	public enum Type{GET,GIVE}
	
	public enum EconomicalType{ECONOMIC,NONECONOMIC}
	
	@Id
	protected String id;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	protected Type type = Type.GIVE;
	
	@Column(name="economical_type")
	@Enumerated(EnumType.STRING)
	protected EconomicalType economicType = EconomicalType.ECONOMIC;

	@Column(name="date")
	protected Date date;
	
	@Column(name="value")
	protected BigDecimal value;
	
	@ManyToOne
	@JoinColumn(name="fk_party_producer")
	protected EconomicAgent producer;
	
	@ManyToOne
	@JoinColumn(name="fk_party_consumer")
	protected EconomicAgent consumer;
	
	@Version
	protected Long version;
	
	public abstract R getResource();
}
