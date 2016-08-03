/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.svc.AutoJournalCreator;
import com.kratonsolution.belian.healtcare.dm.ClinicSales;
import com.kratonsolution.belian.healtcare.dm.ClinicSalesItem;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class ClinicSalesJournalCreator extends AutoJournalCreator<ClinicSales>
{

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#isSupported(java.lang.Object)
	 */
	@Override
	public boolean isSupported(Object target)
	{
		return target instanceof ClinicSales;
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.accounting.svc.AutoJournalCreator#generate(com.kratonsolution.belian.accounting.svc.Journalable)
	 */
	@Override
	public JournalEntry generate(ClinicSales clinicSales)
	{
		BigDecimal tuslah = BigDecimal.ZERO;
		
		for(ClinicSalesItem item:clinicSales.getItems())
		{
			if(item.getProduct().getName().contains("TUSLAH"))
				tuslah = tuslah.add(item.getPrice()).multiply(item.getQuantity());
		}
		
		if(clinicSales != null)
		{
			AccountingPeriod period = periodRepo.findOneOpenChild(clinicSales.getOrganization().getId(), clinicSales.getDate());
			OrganizationAccount coa = coaRepo.findOneByOrganizationId(clinicSales.getOrganization().getId());
			AutoJournalSetting setting = repository.findOneByOrganizationId(clinicSales.getOrganization().getId());
			
			if(setting != null && coa != null && period != null 
				&& setting.getSales() != null && setting.getSales().getCash() != null 
				&& setting.getSales().getGoodsSales() != null)
			{
				JournalEntry entry = new JournalEntry();
				entry.setAuto(true);
				entry.setCoa(coa);
				entry.setCurrency(clinicSales.getCurrency());
				entry.setDate(clinicSales.getDate());
				entry.setNote("Clinic Sales["+clinicSales.getNumber()+"]");
				entry.setOwner(clinicSales.getOrganization());
				entry.setPeriod(period);
				entry.setPosted(false);
				
				entry.addDetail(JournalEntryDetail.DEBET(setting.getSales().getCash(), clinicSales.getBillingAmount().add(clinicSales.getTaxAmount()), "Posting to Cash Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxSales(), clinicSales.getTaxAmount(), "Posting to Tax Payable Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getGoodsSales(), clinicSales.getBillingAmount().subtract(tuslah), "Posting to Sales (Goods) Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTuslah(), tuslah, "Posting to Tuslah Account"));

				if(entry.isBalance());
					return entry;
			}
		}
		
		return null;
	}

}
