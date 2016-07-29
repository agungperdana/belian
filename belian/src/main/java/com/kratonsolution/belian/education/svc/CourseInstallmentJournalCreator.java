/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AutoJournalCreator;
import com.kratonsolution.belian.education.dm.CourseInstallment;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CourseInstallmentJournalCreator extends AutoJournalCreator<CourseInstallment>
{

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#isSupported(java.lang.Object)
	 */
	@Override
	public boolean isSupported(Object target)
	{
		return target instanceof CourseInstallment;
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#generate(com.kratonsolution.belian.accounting.svc.Journalable)
	 */
	@Override
	public JournalEntry generate(CourseInstallment installment)
	{
		if(installment != null)
		{
			AccountingPeriod period = periodRepo.findOneOpenChild(installment.getOrganization().getId(), installment.getDate());
			OrganizationAccount coa = coaRepo.findOneByOrganizationId(installment.getOrganization().getId());
			AutoJournalSetting setting = repository.findOneByOrganizationId(installment.getOrganization().getId());
			
			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getGoodsSales() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(installment.getCurrency());
				entry.setDate(installment.getDate());
				entry.setNote("Course Installment["+installment.getNumber()+"]");
				entry.setOwner(installment.getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getReceivable(), installment.getBillingAmount().add(installment.getTaxAmount()), "Posting to Cash Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxSales(), installment.getTaxAmount(), "Posting to Tax Sales Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getServiceSales(), installment.getNet(), "Posting to Sales (Service) Account"));

				if(entry.isBalance());
					return entry;
			}
		}
		
		return null;
	}

}
