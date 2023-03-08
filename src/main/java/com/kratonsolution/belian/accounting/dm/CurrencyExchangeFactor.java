/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

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
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="currency_exchange_factor")
public class CurrencyExchangeFactor implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@ManyToOne
	@JoinColumn(name="fk_currency_from")
	private Currency from;

	@ManyToOne
	@JoinColumn(name="fk_currency_to")
	private Currency to;
	
	@Column(name="value")
	private BigDecimal value;
	
	@Version
	private Long version;
}
