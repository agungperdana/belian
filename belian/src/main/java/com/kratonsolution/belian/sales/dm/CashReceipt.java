/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.EconomicEvent;
import com.kratonsolution.belian.global.dm.EconomicResource;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashReceipt extends EconomicEvent
{
	private Person cashier;
	
	private EconomicAgent customer;
	
	private GLAccount cashAccount;

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
