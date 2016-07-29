/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

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
public class PharmacySalesJournalCreator extends AutoJournalCreator<PharmacySales>
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
			AccountingPeriod period = periodRepo.findOneOpenChild(pharmacy.getOrganization().getId(), pharmacy.getDate());
			OrganizationAccount coa = coaRepo.findOneByOrganizationId(pharmacy.getOrganization().getId());
			AutoJournalSetting setting = repository.findOneByOrganizationId(pharmacy.getOrganization().getId());
			
			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getGoodsSales() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(pharmacy.getCurrency());
				entry.setDate(pharmacy.getDate());
				entry.setNote("Pharmacy Sales["+pharmacy.getNumber()+"]");
				entry.setOwner(pharmacy.getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getCash(), pharmacy.getBillingAmount().add(pharmacy.getTaxAmount()), "Posting to Cash Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxSales(), pharmacy.getTaxAmount(), "Posting to Tax Payable Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getGoodsSales(), pharmacy.getNet(), "Posting to Sales (Goods) Account"));

				if(entry.isBalance());
					return entry;
			}
		}
		
		return null;
	}

}
