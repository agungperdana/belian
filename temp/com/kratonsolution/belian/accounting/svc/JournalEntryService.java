/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.GLAccountBalanceRepository;
import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryDetail;
import com.kratonsolution.belian.accounting.dm.JournalEntryRepository;
import com.kratonsolution.belian.accounting.dm.JournalPosting;
import com.kratonsolution.belian.accounting.dm.JournalPostingRepository;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;

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
	private SessionUtils utils;
	
	@Autowired
	private Language lang;
	
	@Autowired
	private JournalEntryRepository repository;
	
	@Autowired
	private JournalPostingRepository postingRepository;
	
	@Autowired
	private GLAccountBalanceRepository balanceRepository;
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public int size()
	{
		if(!utils.getOrganizationIds().isEmpty())
			return repository.count(utils.getOrganizationIds()).intValue();
		
		return 0;
	}
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.count(utils.getOrganizationIds(), key).intValue();
		
		return size();
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
	public List<JournalEntry> findAll(int pageIndex,int pageSize)
	{
		if(!utils.getOrganizationIds().isEmpty())
			return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds());
		
		return new ArrayList<JournalEntry>();
	}
	
	@Secured("ROLE_JOURNALENTRY_READ")
	public List<JournalEntry> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(new PageRequest(pageIndex, pageSize),utils.getOrganizationIds(),key);
		
		return findAll(pageIndex, pageSize);
	}
	
	@Secured("ROLE_JOURNALENTRY_CREATE")
	public void silence(JournalEntry entry)
	{
		if(entry != null)
		{
			repository.save(entry);
			
			if(entry.isAuto())
				post(entry);
		}
	}
	
	@Secured("ROLE_JOURNALENTRY_CREATE")
	public void add(JournalEntry entry)
	{
		if(entry == null)
			throw new RuntimeException("Journal cannot be emtpy.");
		
		repository.save(entry);
		
		if(entry.isAuto())
			post(entry);
	}
	
	@Secured("ROLE_JOURNALENTRY_UPDATE")
	public void edit(JournalEntry entry)
	{
		if(!entry.isAuto())
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
			JournalPosting posting = new JournalPosting();
			posting.setAccount(detail.getAccount());
			posting.setAmount(detail.getAmount());
			posting.setDate(entry.getDate());
			posting.setType(detail.getType());
			
			postingRepository.save(posting);
			
			detail.setReference(posting.getAccount().getAccount().getNumber());
		}

		entry.setPosted(true);
		
		repository.saveAndFlush(entry);
	}
	
	@Secured("ROLE_JOURNALENTRY_UPDATE")
	public void unpost(JournalEntry entry)
	{
		if(entry.isAuto())
			throw new RuntimeException(lang.get("journalentry.message.warning"));
			
		forceUnpost(entry);
	}
	
	@Secured("ROLE_JOURNALENTRY_UPDATE")
	public void forceUnpost(JournalEntry entry)
	{
		for(JournalEntryDetail detail:entry.getJournals())
		{
			if(!Strings.isNullOrEmpty(detail.getPosting()))
				postingRepository.delete(detail.getPosting());
	
			detail.setReference(null);
			detail.setPosting(null);
		}
		
		entry.setPosted(false);
		
		repository.saveAndFlush(entry);
	}
}
