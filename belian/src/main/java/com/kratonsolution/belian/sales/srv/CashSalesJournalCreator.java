/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AutoJournalCreator;
import com.kratonsolution.belian.sales.dm.CashSales;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class CashSalesJournalCreator extends AutoJournalCreator<CashSales>
{
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#isSupported(java.lang.Class)
	 */
	@Override
	public boolean isSupported(Object target)
	{
		return (target instanceof CashSales);
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#generate(com.kratonsolution.belian.accounting.svc.Journalable)
	 */
	@Override
	public JournalEntry generate(CashSales cashSales)
	{
		if(cashSales != null)
		{
			AccountingPeriod period = getAccountingPeriod(cashSales.getOrganization(), cashSales.getDate());
			OrganizationAccount coa = getCOA(cashSales.getOrganization());
			AutoJournalSetting setting = getAutoJournalSetting(cashSales.getOrganization());

			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getGoodsSales() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(cashSales.getCurrency());
				entry.setDate(cashSales.getDate());
				entry.setNote("Auto ");
				entry.setOwner(cashSales.getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getCash(), cashSales.getBillingAmount().add(cashSales.getTaxAmount()), "Posting to Cash Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxSales(), cashSales.getTaxAmount(), "Posting to Tax Payable Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getGoodsSales(), cashSales.getBillingAmount(), "Posting to Sales (Goods) Account"));

				entry.isBalance();

				return entry;
			}
		}

		
		return null;
	}
}