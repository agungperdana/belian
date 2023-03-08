
package com.kratonsolution.belian.healtcares.svc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.healtcares.dm.Visit;
import com.kratonsolution.belian.healtcares.dm.VisitRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class VisitService extends AbstractService
{
	@Autowired
	private VisitRepository repository;
	
	@Secured("ROLE_VISIT_READ")
	public int size()
	{
		if(utils.getOrganization() == null)
			return 0;

		return repository.count(utils.getOrganization().getId()).intValue();
	}
	
	@Secured("ROLE_VISIT_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganization().getId()).intValue();
	}

	@Secured("ROLE_VISIT_READ")
	public Visit getOne(String id)
	{
		return repository.getOne(id);
	}

	@Secured("ROLE_VISIT_READ")
	public List<Visit> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_VISIT_READ")
	public List<Visit> findAllToday(String doctor)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		if(Strings.isNullOrEmpty(doctor))
			return repository.findAllToday(utils.getOrganization().getId(), DateTimes.currentDate());
		
		return repository.findAllToday(utils.getOrganization().getId(), doctor, DateTimes.currentDate());
	}
	
	@Secured("ROLE_VISIT_READ")
	public List<Visit> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();
		
		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId());
	}

	@Secured("ROLE_VISIT_READ")
	public List<Visit> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganization() == null)
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganization().getId(),key);
	}

	@Secured("ROLE_VISIT_CREATE")
	public void add(Visit visit)
	{
		visit.setCode(gen.generate(visit.getDate(), utils.getOrganization().getId(), Code.VST));
		repository.save(visit);
	}

	@Secured("ROLE_VISIT_UPDATE")
	public void edit(Visit visit)
	{
		repository.saveAndFlush(visit);
	}
	
	@Secured("ROLE_VISIT_DELETE")
	public void delete(String id)
	{
		repository.deleteById(id);
	}
	
	@Secured("ROLE_VISIT_DELETE")
	public void delete(Collection<String> ids)
	{
		for(String id:ids)
			delete(id);
	}
}
