/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.accounting.dm.JournalSetting;
import com.kratonsolution.belian.accounting.dm.JournalSettingRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class JournalSettingService
{
	@Autowired
	private JournalSettingRepository repository;

	@Secured("ROLE_JOURNALSETTING_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}

	@Secured("ROLE_JOURNALSETTING_READ")
	public JournalSetting findOne(String id)
	{
		return repository.findOne(id);
	}

	@Secured("ROLE_JOURNALSETTING_READ")
	public List<JournalSetting> findAll()
	{
		return repository.findAll();
	}

	@Secured("ROLE_JOURNALSETTING_READ")
	public List<JournalSetting> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}

	@Secured("ROLE_JOURNALSETTING_CREATE")
	public void add(JournalSetting setting)
	{
		setting.setId(UUID.randomUUID().toString());
		repository.save(setting);
	}

	@Secured("ROLE_JOURNALSETTING_UPDATE")
	public void edit(JournalSetting setting)
	{
		repository.saveAndFlush(setting);
	}

	@Secured("ROLE_JOURNALSETTING_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
