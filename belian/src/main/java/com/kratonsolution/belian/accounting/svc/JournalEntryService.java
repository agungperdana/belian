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
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryRepository;

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
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
