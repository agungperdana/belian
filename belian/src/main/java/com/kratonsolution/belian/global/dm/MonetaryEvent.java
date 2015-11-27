/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.Currency;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="financial_event")
public abstract class MonetaryEvent extends EconomicEvent
{
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
}
