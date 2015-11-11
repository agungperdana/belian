/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.accounting.dm.Currency;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="financial_event")
public abstract class FinancialEvent extends EconomicEvent
{
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
}
