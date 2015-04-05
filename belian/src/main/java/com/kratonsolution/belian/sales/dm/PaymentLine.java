/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import com.kratonsolution.belian.accounting.dm.CashAccount;
import com.kratonsolution.belian.global.IncrementCommitment;

/**
 * @author agungdodiperdana
 *
 */
public class PaymentLine extends IncrementCommitment<CashAccount,CashReceipt>
{

	@Override
	public CashAccount getResource()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CashReceipt getEvent()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
