/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.EconomicResource;
import com.kratonsolution.belian.global.dm.MonetaryEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="tax_event")
public class TaxEvent extends MonetaryEvent
{
	@ManyToOne
	@JoinColumn(name="tax_account")
	private GLAccount taxAccount;
	
	@ManyToOne
	@JoinColumn(name="cashier")
	private EconomicAgent cashier;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private EconomicAgent customer;
	
	@Override
	public EconomicAgent getInternal()
	{
		return this.cashier;
	}

	@Override
	public EconomicAgent getExternal()
	{
		return this.customer;
	}

	@Override
	public EconomicResource getResource()
	{
		return this.taxAccount;
	}
}
