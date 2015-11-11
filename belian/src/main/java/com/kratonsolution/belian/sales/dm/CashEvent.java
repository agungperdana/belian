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
import com.kratonsolution.belian.global.dm.EconomicEvent;
import com.kratonsolution.belian.global.dm.EconomicResource;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_event")
public class CashEvent extends EconomicEvent
{
	@ManyToOne
	@JoinColumn(name="cash_account")
	private GLAccount cashAccount;
	
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
		return this.cashAccount;
	}
}
