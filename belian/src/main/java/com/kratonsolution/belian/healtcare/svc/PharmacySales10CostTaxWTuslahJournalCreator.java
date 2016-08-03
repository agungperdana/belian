/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AutoJournalCreator;
import com.kratonsolution.belian.healtcare.dm.PharmacySales;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class PharmacySales10CostTaxWTuslahJournalCreator extends AutoJournalCreator<PharmacySales>
{
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#isSupported(java.lang.Object)
	 */
	@Override
	public boolean isSupported(Object target)
	{
		return target instanceof PharmacySales;
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#generate(com.kratonsolution.belian.accounting.svc.Journalable)
	 */
	@Override
	public JournalEntry generate(PharmacySales pharmacy)
	{
		if(pharmacy != null)
		{
			AccountingPeriod period = getAccountingPeriod(pharmacy.getOrganization(), pharmacy.getDate());
			OrganizationAccount coa = getCOA(pharmacy.getOrganization());
			AutoJournalSetting setting = getAutoJournalSetting(pharmacy.getOrganization());
			
			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getGoodsSales() != null 
				&& setting.getSales().getTaxSales() != null 
				&& setting.getSales().getTuslah() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(pharmacy.getCurrency());
				entry.setDate(pharmacy.getDate());
				entry.setNote("Auto [Pharmacy Sales "+pharmacy.getNumber()+"]");
				entry.setOwner(pharmacy.getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getCash(), pharmacy.getBillingAmount(), "Posting to Cash Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxSales(), pharmacy.getCostTax(), "Posting to Tax Payable Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getGoodsSales(), pharmacy.getBillingAmount().subtract(pharmacy.getCostTax()).subtract(pharmacy.getTuslah()), "Posting to Sales (Goods) Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTuslah(), pharmacy.getTuslah(), "Posting to Tuslah Account"));
				
				entry.isBalance();
				
				return entry;
			}
		}
		
		return null;
	}

}
