/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import org.springframework.beans.factory.annotation.Autowired;

import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;
import com.kratonsolution.belian.accounting.dm.AutoJournalSettingRepository;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AutoJournalCreator<E extends Journalable>
{
	@Autowired
	protected AutoJournalSettingRepository repository;
	
	@Autowired
	protected OrganizationAccountRepository coaRepo;
	
	@Autowired
	protected AccountingPeriodRepository periodRepo;
	
	public abstract boolean isSupported(Object target);
	
	public abstract JournalEntry generate(E e);
}
