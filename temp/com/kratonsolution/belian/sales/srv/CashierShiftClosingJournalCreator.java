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
import com.kratonsolution.belian.sales.dm.CashierShift;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class CashierShiftClosingJournalCreator extends AutoJournalCreator<CashierShift>
{

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#isSupported(java.lang.Object)
	 */
	@Override
	public boolean isSupported(Object target)
	{
		return target instanceof CashierShift;
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#generate(com.kratonsolution.belian.accounting.svc.Journalable)
	 */
	@Override
	public JournalEntry generate(CashierShift shift)
	{
		if(shift != null)
		{
			AccountingPeriod period = getAccountingPeriod(shift.getMachine().getOrganization(), shift.getDate());
			OrganizationAccount coa = getCOA(shift.getMachine().getOrganization());
			AutoJournalSetting setting = getAutoJournalSetting(shift.getMachine().getOrganization());

			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getBranchCash() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(shift.getCurrency());
				entry.setDate(shift.getDate());
				entry.setNote("Auto [Closing Cashier shift]");
				entry.setOwner(shift.getMachine().getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getBranchCash(), shift.getTotalAmount(), "Posting to Kas Umum"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getCash(), shift.getTotalAmount(), "Crediting Cashier account"));

				entry.isBalance();

				return entry;
			}
		}
		
		return null;
	}

}
