/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.accounting.dm.GLAccountBalance;
import com.kratonsolution.belian.accounting.dm.GLAccountBalanceRepository;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.JournalEntryRepository;
import com.kratonsolution.belian.accounting.dm.JournalPosting;
import com.kratonsolution.belian.accounting.dm.JournalPostingRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class JournalEntryService
{
	@Autowired
	private JournalEntryRepository repository;
	
	@Autowired
	private JournalPostingRepository postingRepository;
	
	@Autowired
	private GLAccountBalanceRepository balanceRepository;
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public int count(@Param("companys")List<String> companys)
	{
		return repository.count(companys);
	}
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public JournalEntry findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public List<JournalEntry> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public List<JournalEntry> findAll(int pageIndex,int pageSize,List<String> companys)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize,new Sort(Sort.Direction.DESC,"date")),companys);
	}
	
	@Secured("ROLE_JOURNALENTRY_CREATE")
	public void add(JournalEntry entry)
	{
		entry.setId(UUID.randomUUID().toString());
		repository.save(entry);
	}
	
	@Secured("ROLE_JOURNALENTRY_UPDATE")
	public void edit(JournalEntry entry)
	{
		repository.saveAndFlush(entry);
	}
	
	@Secured("ROLE_JOURNALENTRY_DELETE")
	public void delete(String id)
	{
		JournalEntry entry = repository.findOne(id);
		if(entry != null)
		{
			if(entry.isPosted())
				unpost(entry);
			
			repository.delete(entry);
		}
	}
	
	@Secured("ROLE_JOURNALENTRY_UPDATE")
	public void post(JournalEntry entry)
	{
		for(JournalEntryDetail detail:entry.getJournals())
		{
			GLAccountBalance balance = balanceRepository.findOneByPeriodIdAndAccountIdAndCurrencyId(entry.getPeriod().getId(), detail.getAccount().getId(), entry.getCurrency().getId());
			if(balance == null)
			{
				balance = new GLAccountBalance();
				balance.setAccount(detail.getAccount());
				balance.setPeriod(entry.getPeriod());
				balance.setCurrency(entry.getCurrency());
			}

			if(detail.getType().equals(JournalEntryDetail.Type.DEBET))
				balance.setDebet(balance.getDebet().add(detail.getAmount()));
			else 
				balance.setCredit(balance.getCredit().add(detail.getAmount()));
			
			balanceRepository.save(balance);
			
			JournalPosting posting = new JournalPosting();
			posting.setAmount(detail.getAmount());
			posting.setDate(entry.getDate());
			posting.setType(detail.getType());
			posting.setAccount(balance);
			
			postingRepository.save(posting);
			
			detail.setPosting(posting);
		}
		
		entry.setPosted(true);
		
		repository.save(entry);
	}
	
	@Secured("ROLE_JOURNALENTRY_UPDATE")
	public void unpost(JournalEntry entry)
	{
		for(JournalEntryDetail detail:entry.getJournals())
		{
			GLAccountBalance balance = balanceRepository.findOneByPeriodIdAndAccountIdAndCurrencyId(entry.getPeriod().getId(), detail.getAccount().getId(), entry.getCurrency().getId());
			if(balance != null)
			{
				if(detail.getType().equals(JournalEntryDetail.Type.DEBET))
					balance.setDebet(balance.getDebet().subtract(detail.getAmount()));
				else 
					balance.setCredit(balance.getCredit().subtract(detail.getAmount()));
				
				balanceRepository.save(balance);
			}
			
			postingRepository.delete(detail.getPosting());
		}
		
		entry.setPosted(false);
		entry.clearPost();
		
		repository.save(entry);
	}
}
