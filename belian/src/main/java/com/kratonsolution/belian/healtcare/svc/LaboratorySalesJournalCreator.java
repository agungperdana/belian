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
import com.kratonsolution.belian.healtcare.dm.LaboratorySales;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LaboratorySalesJournalCreator extends AutoJournalCreator<LaboratorySales>
{
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#isSupported(java.lang.Object)
	 */
	@Override
	public boolean isSupported(Object target)
	{
		return target instanceof LaboratorySales;
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#generate(com.kratonsolution.belian.accounting.svc.Journalable)
	 */
	@Override
	public JournalEntry generate(LaboratorySales laboratory)
	{
		if(laboratory != null)
		{
			AccountingPeriod period = periodRepo.findOneOpenChild(laboratory.getOrganization().getId(), laboratory.getDate());
			OrganizationAccount coa = coaRepo.findOneByOrganizationId(laboratory.getOrganization().getId());
			AutoJournalSetting setting = repository.findOneByOrganizationId(laboratory.getOrganization().getId());
			
			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getGoodsSales() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(laboratory.getCurrency());
				entry.setDate(laboratory.getDate());
				entry.setNote("Pharmacy Sales["+laboratory.getNumber()+"]");
				entry.setOwner(laboratory.getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getCash(), laboratory.getBillingAmount().add(laboratory.getTaxAmount()), "Posting to Cash Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxSales(), laboratory.getTaxAmount(), "Posting to Tax Payable Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getServiceSales(), laboratory.getNet(), "Posting to Sales (Service) Account"));

				if(entry.isBalance());
					return entry;
			}
		}
		
		return null;
	}

}
