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
import com.kratonsolution.belian.healtcare.dm.MedicalTreatmentSales;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MedicalTreatmentSalesJournalCreator extends AutoJournalCreator<MedicalTreatmentSales>
{

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#isSupported(java.lang.Object)
	 */
	@Override
	public boolean isSupported(Object target)
	{
		return target instanceof MedicalTreatmentSales;
	}

	@Override
	public JournalEntry generate(MedicalTreatmentSales treatment)
	{
		if(treatment != null)
		{
			AccountingPeriod period = periodRepo.findOneOpenChild(treatment.getOrganization().getId(), treatment.getDate());
			OrganizationAccount coa = coaRepo.findOneByOrganizationId(treatment.getOrganization().getId());
			AutoJournalSetting setting = repository.findOneByOrganizationId(treatment.getOrganization().getId());
			
			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getGoodsSales() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(treatment.getCurrency());
				entry.setDate(treatment.getDate());
				entry.setNote("Medical Treatment["+treatment.getNumber()+"]");
				entry.setOwner(treatment.getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getCash(), treatment.getBillingAmount().add(treatment.getTaxAmount()), "Posting to Cash Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxSales(), treatment.getTaxAmount(), "Posting to Tax Payable Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getServiceSales(), treatment.getNet(), "Posting to Sales (Service) Account"));

				if(entry.isBalance());
					return entry;
			}
		}
		
		return null;
	}

}
