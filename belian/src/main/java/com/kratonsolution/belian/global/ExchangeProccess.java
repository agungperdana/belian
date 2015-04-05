/**
 * 
 */
package com.kratonsolution.belian.global;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="exchange_proccess")
public class ExchangeProccess
{
	@Id
	private String id;

	@Column(name="date")
	private Date date;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_economic_agent_producer")
	private EconomicAgent producer;
	
	@ManyToOne
	@JoinColumn(name="fk_economic_agent_consumer")
	private EconomicAgent consumer;
	
	@ManyToOne
	@JoinColumn(name="fk_economic_event_receive")
	private EconomicEvent receive;
	
	@ManyToOne
	@JoinColumn(name="fk_economic_event_give")
	private EconomicEvent give;
	
	@Version
	private Long version;
}
