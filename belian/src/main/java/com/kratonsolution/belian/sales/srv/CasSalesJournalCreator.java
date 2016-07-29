/**
 * 
 */
package com.kratonsolution.belian.sales.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;
import com.kratonsolution.belian.accounting.dm.AutoJournalSetting;
import com.kratonsolution.belian.accounting.dm.AutoJournalSettingRepository;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;
import com.kratonsolution.belian.accounting.svc.AutoJournalCreator;
import com.kratonsolution.belian.sales.dm.CashSales;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class CasSalesJournalCreator implements AutoJournalCreator<CashSales>
{
	@Autowired
	private AutoJournalSettingRepository repository;
	
	@Autowired
	private OrganizationAccountRepository coaRepo;
	
	@Autowired
	private AccountingPeriodRepository periodRepo;
	
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
			AccountingPeriod period = periodRepo.findOneOpenChild(cashSales.getOrganization().getId(), cashSales.getDate());
			OrganizationAccount coa = coaRepo.findOneByOrganizationId(cashSales.getOrganization().getId());
			AutoJournalSetting setting = repository.findOneByOrganizationId(cashSales.getOrganization().getId());
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
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getTaxPayable(), cashSales.getTaxAmount(), "Posting to Tax Payable Account"));
				entry.addDetail(JournalEntryDetail.CREDIT(setting.getSales().getGoodsSales(), cashSales.getNet(), "Posting to Sales (Goods) Account"));

				if(entry.isBalance());
					return entry;
			}
		}

		
		return null;
	}
}
